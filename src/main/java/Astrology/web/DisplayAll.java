package Astrology.web;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/DisplayAll")
public class DisplayAll {

    private final BirthdayRepository birthdayRepo;
    private final DayRepository dayRepo;
    private final MonthRepository monthRepo;
    private final YearRepository yearRepo;

    @Autowired
    public DisplayAll(BirthdayRepository birthdayRepo, DayRepository dayRepo, MonthRepository monthRepo, YearRepository yearRepo) {
        this.birthdayRepo = birthdayRepo;
        this.dayRepo = dayRepo;
        this.monthRepo = monthRepo;
        this.yearRepo = yearRepo;
    }

    @GetMapping("/Tables")
    public String displaytabs() {
        return "databaseview";
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

    @ModelAttribute(name = "Birthday")
    public void addBirthdayToModel(Model model) {
        List<Birthday> bday = (List<Birthday>) birthdayRepo.findAll();
        model.addAttribute("bday", bday);
    }
}