package Astrology.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Horoscope")
public class YearlyHoroscopeDisplayController {

    @GetMapping
    public String resultsPage() {
        return "horoscope-api";
    }
}
