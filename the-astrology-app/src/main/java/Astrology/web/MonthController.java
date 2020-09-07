package Astrology.web;

import java.util.Arrays;
import java.util.List;
//import javax.validation.Valid;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//import lombok.extern.slf4j.Slf4j;
import Astrology.BirthMonth;


//@Slf4j
@Controller
@RequestMapping("/BirthMonth.html")
public class MonthController {

    @GetMapping
    public String showDesignForm(Model model) {

       //BirthMonth bm = new BirthMonth("1", "January");


        List<BirthMonth> bm = Arrays.asList(
                new BirthMonth("1", "January"),
                new BirthMonth("2", "February"),
                new BirthMonth("3", "March"),
                new BirthMonth("4", "April"),
                new BirthMonth("5", "May"),
                new BirthMonth("6", "June"),
                new BirthMonth("7", "July"),
                new BirthMonth("8", "August"),
                new BirthMonth("9", "September"),
                new BirthMonth("10", "October"),
                new BirthMonth("11", "November"),
                new BirthMonth("12", "December")
        );

        model.addAttribute("month", bm);

        return "BirthMonth.html";
    }




    /*
    @ModelAttribute
    public void addAttributes(Model model) {
        List<BirthMonth> months = createBirthMonthList();
    }

    private List<BirthMonth> createBirthMonthList() {
        List<BirthMonth> months = Arrays.asList(
                new BirthMonth(1, "January"),
                new BirthMonth(2, "February"),
                new BirthMonth(3, "March"),
                new BirthMonth(4, "April"),
                new BirthMonth(5, "May"),
                new BirthMonth(6, "June"),
                new BirthMonth(7, "July"),
                new BirthMonth(8, "August"),
                new BirthMonth(9, "September"),
                new BirthMonth(10, "October"),
                new BirthMonth(11, "November"),
                new BirthMonth(12, "December")
        );
        return months;
    }
    */

}
