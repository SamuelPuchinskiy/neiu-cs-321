package Astrology.security;

import Astrology.data.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Slf4j
@Configuration
@RequestMapping("/register")
public class SignUpController {

    private UserRepository userRepo;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public SignUpController(UserRepository userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String signUpForm() {
        return "signup";
    }

    @ModelAttribute(name = "signUpForm")
    public SignUpForm addSignUpFormToModel() {
        return new SignUpForm();
    }

    @PostMapping
    public String processSignUp(@Valid @ModelAttribute("signUpForm") SignUpForm signUpForm, Errors errors) {
        if(errors.hasErrors())
            return  "/signup";

        try {
            userRepo.save(signUpForm.toUser(passwordEncoder));
        } catch (DataIntegrityViolationException e) {
            errors.rejectValue("username", "invalidUsername", "Username not available. please choose another username. (Case Sensitive)");
            return "/signup";
        }
        return "redirect:/login";
    }
}