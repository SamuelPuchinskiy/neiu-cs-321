package Astrology.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import Astrology.BirthYear;
import Astrology.Day;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import Astrology.BirthMonth;

import javax.validation.Valid;


@Slf4j
@Controller
@RequestMapping("/AstrologyMain")
public class MainController {

    @GetMapping
    public String showDesignForm(Model model) {

       //BirthMonth bm = new BirthMonth("1", "January");

        return "birth-day";
    }

    @ModelAttribute
    public void addAttributes(Model model) {
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
    }


    @ModelAttribute
    public void addAttributesYear(Model model) {
        List<BirthYear> by = new ArrayList<>();

        int leap = 3;
        boolean ly = false;
        for(int i = 1900; i <= 2020; i++)
        {
            leap++;
            ly = false;
            if(leap == 4)
            {
                leap = 0;
                ly = true;
            }
            String num = i + "";
            BirthYear obj = new BirthYear(num, num, ly);
            by.add(obj);
        }

        model.addAttribute("year", by);
    }

    @ModelAttribute
    public void addAttributesDay(Model model) {
        List<Day> days = new ArrayList<>();

        for(int i = 1; i <=31; i++)
        {
            String num = i + "";
            Day obj = new Day(num, num);
            days.add(obj);
        }

        model.addAttribute("days", days);
    }
    
    @PostMapping
    public String processDesign(@Valid @ModelAttribute("birthMonth") Birthday birthdayUser, Errors errors){
        if(errors.hasFieldErrors()){
            return "birth-day";
        }

        log.info("Processing..." + birthdayUser);
        return "redirect:/Submit/Results";
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
