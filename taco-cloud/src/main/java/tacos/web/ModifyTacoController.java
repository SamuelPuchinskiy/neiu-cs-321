package tacos.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import tacos.Ingredient;
import tacos.Taco;
import tacos.User;
import tacos.data.IngredientRepository;
import tacos.data.TacoRepository;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/modify")
public class ModifyTacoController {

    private TacoRepository tacoRepo;
    private IngredientRepository ingredientRepo;

    @Autowired
    public ModifyTacoController(TacoRepository tacoRepo, IngredientRepository ingredientRepo) {
        this.tacoRepo = tacoRepo;
        this.ingredientRepo = ingredientRepo;
    }

    @GetMapping("/{tacoId}")
    public String updateTaco(@PathVariable("tacoId") long id, Model model) {
        Taco taco = tacoRepo.findById(id).get();
        model.addAttribute("ingredientIds", getIngredientIds(taco));
        model.addAttribute("taco", taco);
        addIngredientsToModel(model);
        return "update-taco";
    }

    @PostMapping("/update/{tacoId}")
    public String porcessUpdateTaco(@PathVariable("tacoId") long id, @Valid @ModelAttribute("taco") Taco taco, Errors errors) {
        if(errors.hasErrors())
            return "update-taco";

        Taco newTaco = tacoRepo.findById(id).get();
        newTaco.setIngredients(taco.getIngredients());
        newTaco.setName(taco.getName());
        tacoRepo.save(newTaco);
        log.info("Processing... " + newTaco);
        return "redirect:/view/all";
    }

    private List<String> getIngredientIds(Taco taco) {
        List<Ingredient> ingredients = taco.getIngredients();
        List<String> ingredientIds = new ArrayList<>();
        for(Ingredient ingredient: ingredients) {
            ingredientIds.add(ingredient.getId());
        }
        return ingredientIds;
    }

    @ModelAttribute
    private void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = (List<Ingredient>) ingredientRepo.findAll();
        Ingredient.Type[] types = Ingredient.Type.values();
        for (Ingredient.Type type: types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Ingredient.Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

}
