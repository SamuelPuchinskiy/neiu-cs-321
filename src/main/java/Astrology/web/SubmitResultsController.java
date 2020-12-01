package Astrology.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Submit")
public class SubmitResultsController {

    @GetMapping("/Results")
    public String resultsPage() {
        return "submitresults";
    }

    @PostMapping
    public String displayTable() {
        return "redirect:/DisplayAll/Tables";
    }
}