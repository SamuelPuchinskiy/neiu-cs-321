package Astrology.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

//@Slf4j
@Controller
@RequestMapping("/submit")
public class submitResultsController {

    @GetMapping("/results")
    public String resultsPage() {
        //model.addAttribute("birthday", new birthday());
        return "submitResults";
    }

    /*
    @PostMapping
    public String processOrder() {
        return "birthMonth";

    }*/

}
