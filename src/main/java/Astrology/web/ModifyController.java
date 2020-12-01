package Astrology.web;

import Astrology.*;
import Astrology.data.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/modify")
public class ModifyController {

    private BirthdayRepository birthdayRepo;
    private DayRepository dayRepo;
    private MonthRepository monthRepo;
    private YearRepository yearRepo;
    private BirthdayProperty birthdayProperty;
    private UserRepository userRepo;

    @Autowired
    public ModifyController(BirthdayRepository birthdayRepo, DayRepository dayRepo, MonthRepository monthRepo, YearRepository yearRepo, UserRepository userRepo, BirthdayProperty birthdayProperty) {
        this.birthdayRepo = birthdayRepo;
        this.dayRepo = dayRepo;
        this.monthRepo = monthRepo;
        this.yearRepo = yearRepo;
        this.userRepo = userRepo;
        this.birthdayProperty = birthdayProperty;
    }


    @GetMapping("/{birthdayId}")
    public String editBirthday(@PathVariable("birthdayId") Long id, Model model) {

        Birthday bday = birthdayRepo.findById(id);

        String userYear = bday.getBirthYearUser();
        String userMonth = bday.getBirthMonthUser();
        String userDay = bday.getBirthDayUser();

        model.addAttribute("userYear", userYear);
        model.addAttribute("userMonth", userMonth);
        model.addAttribute("userDay", userDay);

        model.addAttribute("bday", bday);

        return "edit-birthday";
    }

    @PostMapping("/edits/{birthdayId}")
    public String processEditBirthday(@PathVariable("birthdayId") Long id, @Valid @ModelAttribute("birthdayUser") Birthday birthdayUser, Errors errors) {
        if (errors.hasFieldErrors()) {
            return "edit-birthday";
        }

        Birthday newbday = birthdayRepo.findById(id);

        newbday.setBirthYearUser(birthdayUser.getBirthYearUser());
        newbday.setBirthMonthUser(birthdayUser.getBirthMonthUser());
        newbday.setBirthDayUser(birthdayUser.getBirthDayUser());

        newbday.setYearZodiac(YearAlgorithm(newbday.getBirthYearUser()));
        newbday.setMonthZodiac(MonthAlgorithm(newbday.getBirthMonthUser(), newbday.getBirthDayUser()));
        newbday.setNumerology(NumerologyAlgorithm(newbday.getBirthYearUser(), newbday.getBirthMonthUser(), newbday.getBirthDayUser()));

        Birthday savedBirthday = birthdayRepo.save(newbday);
        log.info("Processing..." + newbday);
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

    @PostMapping("/delete/{birthdayId}")
    public String deleteBirthday(@PathVariable("birthdayId") long id, Model model) {
        Birthday date = birthdayRepo.findById(id);
        birthdayRepo.delete(date);
        return "redirect:/Submit/Results";
    }
}