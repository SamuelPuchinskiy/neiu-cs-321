package Astrology.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//@Slf4j
@Controller
@RequestMapping("/Submit")
public class SubmitResultsController {

    @GetMapping("/Results")
    public String resultsPage() {
        //model.addAttribute("birthday", new birthday());
        return "submit-results";
    }


    @PostMapping
    public String displayTable()
    {
        return "redirect:/DisplayAll/Tables";
    }

    /*
    @PostMapping
    public String processOrder() {
        return "birthMonth";

    }*/

}
