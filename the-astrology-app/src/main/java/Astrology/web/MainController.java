package Astrology.web;

import java.util.List;
import Astrology.BirthMonth;
import Astrology.BirthYear;
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
        List<BirthMonth> months = (List<BirthMonth>) monthRepo.findAll();
        model.addAttribute("months", months);
    }

    @ModelAttribute(name = "Birth_Year")
    public void addYearToModel(Model model) {
        List<BirthYear> years = (List<BirthYear>) yearRepo.findAll();
        model.addAttribute("year", years);
    }

    @ModelAttribute(name = "Day")
    public void addDayToModel(Model model) {
        List<Day> days = (List<Day>) dayRepo.findAll();
        model.addAttribute("days", days);
    }

    @PostMapping
    public String processDesign(@Valid @ModelAttribute("birthdayUser") Birthday birthdayUser, Errors errors) {
        if (errors.hasFieldErrors()) {
            return "birthday";
        }

        Birthday savedBirthday = birthdayRepo.save(birthdayUser);

        log.info("Processing..." + birthdayUser);
        return "redirect:/Submit/Results";
    }
}

/*

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