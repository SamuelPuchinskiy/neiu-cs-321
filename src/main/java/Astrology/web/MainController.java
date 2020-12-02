package Astrology.web;

import java.util.List;

import Astrology.*;
import Astrology.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    private final BirthdayProperty birthdayProperty;

    private UserRepository userRepo;

    @Autowired
    public MainController(BirthdayRepository birthdayRepo, DayRepository dayRepo, MonthRepository monthRepo, YearRepository yearRepo, UserRepository userRepo, BirthdayProperty birthdayProperty) {
        this.birthdayRepo = birthdayRepo;
        this.dayRepo = dayRepo;
        this.monthRepo = monthRepo;
        this.yearRepo = yearRepo;
        this.userRepo = userRepo;
        this.birthdayProperty = birthdayProperty;
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
    }

    @ModelAttribute
    public void addBirthdayDataToUserPage(Model model, @AuthenticationPrincipal User user) {
        Pageable pageable = PageRequest.of(0, birthdayProperty.getPageSize());
        List<Birthday> bdayUsers = (List<Birthday>) birthdayRepo.findAllByUser(user, pageable);
        model.addAttribute("bdayUsers", bdayUsers);
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
    public String processDesign(@Valid @ModelAttribute("birthdayUser") Birthday birthdayUser, Errors errors, @AuthenticationPrincipal User user) {
        if (errors.hasFieldErrors()) {
            return "birthday";
        }

        birthdayUser.setUser(user);
        birthdayUser.setYearZodiac(YearAlgorithm(birthdayUser.getBirthYearUser()));
        birthdayUser.setMonthZodiac(MonthAlgorithm(birthdayUser.getBirthMonthUser(), birthdayUser.getBirthDayUser()));
        birthdayUser.setNumerology(NumerologyAlgorithm(birthdayUser.getBirthYearUser(), birthdayUser.getBirthMonthUser(), birthdayUser.getBirthDayUser()));

        Birthday savedBirthday = birthdayRepo.save(birthdayUser);

        log.info("Processing..." + birthdayUser);
        return "redirect:/Submit/Results";
    }

    public int getMonthInteger(String month) {
        int m = 0;
        if(month.equals("January"))
            m = 1;
        else if(month.equals("February"))
            m = 2;
        else if(month.equals("March"))
            m = 3;
        else if(month.equals("April"))
            m = 4;
        else if(month.equals("May"))
            m = 5;
        else if(month.equals("June"))
            m = 6;
        else if(month.equals("July"))
            m = 7;
        else if(month.equals("August"))
            m = 8;
        else if(month.equals("September"))
            m = 9;
        else if(month.equals("October"))
            m = 10;
        else if(month.equals("November"))
            m = 11;
        else if(month.equals("December"))
            m = 12;
        else
            m = 0;
        return m;
    }

    public String YearAlgorithm(String year) {
        int yr = Integer.parseInt(year);
        int yrMod = yr % 12;
        String yearStr = "";
        switch(yrMod) {
            case 0:
                yearStr = "Monkey";
                break;
            case 1:
                yearStr = "Rooster";
                break;
            case 2:
                yearStr = "Dog";
                break;
            case 3:
                yearStr = "Pig";
                break;
            case 4:
                yearStr = "Rat";
                break;
            case 5:
                yearStr = "Ox";
                break;
            case 6:
                yearStr = "Tiger";
                break;
            case 7:
                yearStr = "Rabbit";
                break;
            case 8:
                yearStr = "Dragon";
                break;
            case 9:
                yearStr = "Snake";
                break;
            case 10:
                yearStr = "Horse";
                break;
            case 11:
                yearStr = "Sheep";
                break;
            default:
                yearStr = "Unknown";
                break;
        }
        return yearStr;
    }

    public String MonthAlgorithm(String month, String day) {
        int m = getMonthInteger(month);
        int d = Integer.parseInt(day);
        String monthStr = "";
        if (m == 1) {
            if (d < 20)
                monthStr = "Capricorn";
            else
                monthStr = "Aquarius";
        } else if (m == 2) {
            if (d < 19)
                monthStr = "Aquarius";
            else
                monthStr = "Pisces";
        } else if(m == 3) {
            if (d < 21)
                monthStr = "Pisces";
            else
                monthStr = "Aries";
        } else if (m == 4) {
            if (d < 20)
                monthStr = "Aries";
            else
                monthStr = "Taurus";
        } else if (m == 5) {
            if (d < 21)
                monthStr = "Taurus";
            else
                monthStr = "Gemini";
        } else if(m == 6) {
            if (d < 21)
                monthStr = "Gemini";
            else
                monthStr = "Cancer";
        } else if (m == 7) {
            if (d < 23)
                monthStr = "Cancer";
            else
                monthStr = "Leo";
        } else if(m == 8) {
            if (d < 23)
                monthStr = "Leo";
            else
                monthStr = "Virgo";
        } else if (m == 9) {
            if (d < 23)
                monthStr = "Virgo";
            else
                monthStr = "Libra";
        } else if (m == 10) {
            if (d < 23)
                monthStr = "Libra";
            else
                monthStr = "Scorpio";
        } else if (m == 11) {
            if (d < 22)
                monthStr = "Scorpio";
            else
                monthStr = "Sagittarius";
        } else if (m == 12) {
            if (d < 22)
                monthStr = "Sagittarius";
            else
                monthStr ="Capricorn";
        } else
            monthStr = "Unknown";
        return monthStr;
    }

    private String NumerologyAlgorithm(String year, String month, String day) {
        int yr = Integer.parseInt(year);
        int m = getMonthInteger(month);
        int d = Integer.parseInt(day);
        int numValue = 0;
        int tempNumValue = 0;
        int tempYear = yr;
        int tempMonth = m;
        int tempDay = d;
        int count = 4;
        while(count > 0) {
            numValue += tempYear % 10;
            tempYear /= 10;
            count--;
        }
        if(yr < 9) {
            count = 2;
            while(count > 0) {
                numValue += tempMonth % 10;
                tempMonth /= 10;
                count--;
            }
        } else
            numValue += tempMonth;

        if(d < 9) {
            count = 2;
            while(count > 0) {
                numValue += tempDay % 10;
                tempDay /= 10;
                count--;
            }
        } else
            numValue += tempDay;
        tempNumValue = numValue;
        if(tempNumValue > 9) {
            count = 2;
            numValue = 0;
            while(count > 0) {
                numValue += tempNumValue % 10;
                tempNumValue /= 10;
                count--;
            }
        }
        else
            numValue = numValue;
        tempNumValue = numValue;
        if(tempNumValue > 9) {
            count = 2;
            numValue = 0;
            while(count > 0) {
                numValue += tempNumValue % 10;
                tempNumValue /= 10;
                count--;
            }
        }
        else
            numValue = numValue;
        String value = String.valueOf(numValue);
        return value;
    }
}