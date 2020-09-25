package Astrology.web;

import java.util.List;


import Astrology.Birth_Year;
import Astrology.Birth_Month;
import Astrology.Birthday;
import Astrology.Day;
import Astrology.data.BirthdayRepository;
import Astrology.data.DayRepository;
import Astrology.data.MonthRepository;
import Astrology.data.YearRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;

import javax.validation.Valid;


@Slf4j
@Controller
@RequestMapping("/AstrologyMain")
@SessionAttributes("Birthday")
public class MainController {

    private final BirthdayRepository birthdayRepo;
    private final DayRepository dayRepo;
    private final MonthRepository monthRepo;
    private final YearRepository yearRepo;

    @Autowired
    public MainController(BirthdayRepository birthdayRepo, DayRepository dayRepo, MonthRepository monthRepo, YearRepository yearRepo) {
        this.birthdayRepo = birthdayRepo;
        this.dayRepo = dayRepo;
        this.monthRepo = monthRepo;
        this.yearRepo = yearRepo;
    }

    @ModelAttribute(name = "Birthday")
    public Birthday addBirthdayToModel() {
        return new Birthday();
    }

    @GetMapping
    public String showDesignForm(Model model) {
        return "birthday";
    }


    @ModelAttribute(name = "Birth_Month")
    public void addMonthToModel(Model model) {
        List<Birth_Month> months = (List<Birth_Month>) monthRepo.findAll();
        model.addAttribute("months", months);
    }


    @ModelAttribute(name = "Birth_Year")
    public void addYearToModel(Model model) {
        List<Birth_Year> years = (List<Birth_Year>) yearRepo.findAll();
        model.addAttribute("year", years);
    }

    @ModelAttribute(name = "Day")
    public void addDayToModel(Model model) {
        List<Day> days = (List<Day>) dayRepo.findAll();
        model.addAttribute("days", days);
    }
    
    @PostMapping
    public String processDesign(@Valid @ModelAttribute("birthdayUser") Birthday birthdayUser, Errors errors){
        if(errors.hasFieldErrors()){
            return "birthday";
        }

        Birthday savedBirthday = birthdayRepo.save(birthdayUser);

        log.info("Processing..." + birthdayUser);
        return "redirect:/Submit/Results";
    }



      /*
    @ModelAttribute
    public void addAttributesYear(Model model) {
        List<Birth_Year> by = new ArrayList<>();

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
            Birth_Year obj = new Birth_Year(num, num, ly);
            by.add(obj);
        }

        model.addAttribute("year", by);
    }
     */


     /*
    @ModelAttribute
    public void addAttributes(Model model) {
        List<Birth_Month> bm = Arrays.asList(
                new Birth_Month("1", "January"),
                new Birth_Month("2", "February"),
                new Birth_Month("3", "March"),
                new Birth_Month("4", "April"),
                new Birth_Month("5", "May"),
                new Birth_Month("6", "June"),
                new Birth_Month("7", "July"),
                new Birth_Month("8", "August"),
                new Birth_Month("9", "September"),
                new Birth_Month("10", "October"),
                new Birth_Month("11", "November"),
                new Birth_Month("12", "December")
        );

        model.addAttribute("month", bm);
    }
    */

       /* @ModelAttribute
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
    */


    /*
    @ModelAttribute
    public void addAttributes(Model model) {
        List<Birth_Month> months = createBirthMonthList();
    }

    private List<Birth_Month> createBirthMonthList() {
        List<Birth_Month> months = Arrays.asList(
                new Birth_Month(1, "January"),
                new Birth_Month(2, "February"),
                new Birth_Month(3, "March"),
                new Birth_Month(4, "April"),
                new Birth_Month(5, "May"),
                new Birth_Month(6, "June"),
                new Birth_Month(7, "July"),
                new Birth_Month(8, "August"),
                new Birth_Month(9, "September"),
                new Birth_Month(10, "October"),
                new Birth_Month(11, "November"),
                new Birth_Month(12, "December")
        );
        return months;
    }
    */

}
