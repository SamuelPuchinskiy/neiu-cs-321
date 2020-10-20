package Astrology.web;

import java.util.Iterator;
import java.util.List;

import Astrology.*;
import Astrology.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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

    private UserRepository userRepo;

    @Autowired
    public MainController(BirthdayRepository birthdayRepo, DayRepository dayRepo, MonthRepository monthRepo, YearRepository yearRepo, UserRepository userRepo) {
        this.birthdayRepo = birthdayRepo;
        this.dayRepo = dayRepo;
        this.monthRepo = monthRepo;
        this.yearRepo = yearRepo;
        this.userRepo = userRepo;
    }

    @ModelAttribute(name = "Birthday")
    public Birthday addBirthdayToModel() {
        return new Birthday();
    }

    @GetMapping
    public String showDesignForm(Model model) {
        return "birthday";
    }

    @GetMapping("/loginpage")
    public String displayUserLogin(Model model, @AuthenticationPrincipal User user) {
        addUserInforToModel(model, user);
        addBirthdayDataToUserPage(model, user);
        return "loginpage";
    }

    private void addUserInforToModel(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("fullname", user.getFullname());
        model.addAttribute("userBirthday", user.getUserBirthday());
        model.addAttribute("id", user.getId());

        //List<Birthday> bdayUser = (List<Birthday>) birthdayRepo.findAllByUser(user);
        //model.addAttribute("bdayUser", bdayUser);
    }

    @ModelAttribute
    public void addBirthdayDataToUserPage(Model model, @AuthenticationPrincipal User user) {
        //List<Birthday> bdayUsers = (List<Birthday>) birthdayRepo.findAll();
        List<Birthday> bdayUsers = (List<Birthday>) birthdayRepo.findAllByUser(user);

        model.addAttribute("bdayUsers", bdayUsers);//birthdayRepo.findAllByUser(user));
    }
        /*
    }
        //String userId = user.getId() + "";
        List<Birthday> bdayUser = (List<Birthday>) birthdayRepo.findByUser(user);
        //List<User> users = (List<User>) userRepo.findAll();
/*
        List<Birthday> bdayUser = null; //= new List<Birthday>();
        bdayUser

        //Iterator<Transaction> txnIterator = transactions.iterator();

        for(Birthday d : bday) {
            User v = d.getUser();
                if (v.getId() == user.getId())
                    bdayUser.add(d);
        }


        model.addAttribute("bdayUser", bdayUser);
    }
    */

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
    public String processDesign(@Valid @ModelAttribute("birthdayUser") Birthday birthdayUser, Errors errors, @AuthenticationPrincipal User user) {
        if (errors.hasFieldErrors()) {
            return "birthday";
        }

        birthdayUser.setUser(user);
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