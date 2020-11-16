package Astrology.security;

import Astrology.Birthday;
import Astrology.User;
import Astrology.data.UserRepository;
import Astrology.security.EditForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@Configuration
@RequestMapping("/edit-account")
public class EditAccountController {


    private UserRepository userRepo;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public EditAccountController(UserRepository userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/{id}")
    public String EditAccount(@PathVariable("id") Long id, Model model) {

        User user = userRepo.findById(id).get();

        model.addAttribute("user", user);


        return "edit-account";
    }

    @ModelAttribute(name = "editForm")
    public EditForm addEditFormToModel() {
        return new EditForm();
    }

    @PostMapping("/update")
    public String processUpdateUser(@Valid @ModelAttribute("editForm") EditForm editForm, Errors errors) {
        if(errors.hasErrors())
            return  "/edit-account";

        try {

            //SignUpForm newSign = userRepo.findById(id);

            //User newUser = userRepo.findById(id).get();

            //SignUpForm newSignUpForm = userRepo.findById(id).get();

            //newUser.set(signUpForm.getUsername());



            //userRepo.save(signUpForm.toUser(passwordEncoder));
        } catch (DataIntegrityViolationException e) {
            errors.rejectValue("username", "invalidUsername", "Username not available. please choose another username. (Case Sensitive)");
            return "/edit-account";
        }



        return "redirect:/AstrologyMain/loginpage";
    }

    /*
   // @GetMapping("/userId")
    //public

    @PostMapping("/{id}")
    public String processSignUp(@PathVariable("id") Long id, @Valid @ModelAttribute("signUpForm") SignUpForm signUpForm, Errors errors) {
        if(errors.hasErrors())
            return  "/edit-account";

        //User newUser = userRepo.findById(userId);


        try {
            userRepo.save(signUpForm.toUser(passwordEncoder));
        } catch (DataIntegrityViolationException e) {
            errors.rejectValue("username", "invalidUsername", "Username not available. please choose another username. (Case Sensitive)");
            return "/edit-account";
        }
        return "redirect:/login";
    }
*/


}
