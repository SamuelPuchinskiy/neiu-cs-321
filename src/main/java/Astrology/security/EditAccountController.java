package Astrology.security;

import Astrology.User;
import Astrology.data.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
    public String EditAccount(@PathVariable("id") Long id, Model model, @AuthenticationPrincipal User user) {

        //User user = userRepo.findById(id).get();
        model.addAttribute("username", user.getUsername());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("fullname", user.getFullname());
        model.addAttribute("cell", user.getCell());
        model.addAttribute("userBirthday", user.getUserBirthday());

        return "edit-account";
    }

    @ModelAttribute(name = "SignUpForm")
    public SignUpForm addSignUpFormToModel() {
        return new SignUpForm();
    }

    @PostMapping("/update/{id}")
    public String processUpdateUser(@PathVariable("id") Long id, @Valid @ModelAttribute("SignUpForm") SignUpForm editForm, Errors errors, @AuthenticationPrincipal User user) {
        if(errors.hasErrors())
            return  "edit-account";

        try {
            User updateUser = user; //userRepo.findById(id).get();
            userRepo.save(SignUpForm.updateUser(updateUser, passwordEncoder, editForm));
        } catch (DataIntegrityViolationException e) {
            errors.rejectValue("username", "invalidUsername", "Username not available. please choose another username. (Case Sensitive)");
            return "/edit-account";
        }
        return "redirect:/AstrologyMain/loginpage";
    }
}