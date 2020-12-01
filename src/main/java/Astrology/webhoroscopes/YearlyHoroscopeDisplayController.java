package Astrology.webhoroscopes;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

@Controller
@RequestMapping("/Horoscope")
public class YearlyHoroscopeDisplayController {

    @GetMapping
    public String resultsPage(Model model) throws IOException {
        return "horoscopes/horoscope-api";
    }

    @GetMapping("/Aquarius")
    public String aquarius() {
        return "horoscopes/aquarius";
    }
    @ModelAttribute
    public void aquariusInfo(Model model) throws IOException  {
        URL url = new URL("http://horoscope-api.herokuapp.com/horoscope/year/aquarius");
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        int responsecode = conn.getResponseCode();
        if(responsecode != 200) throw new RuntimeException("HttpResponseCode: " + responsecode);
        else {
            Scanner sc = new Scanner(url.openStream());
            String aquariusYear = "";
            int count = 0;
            while(count < 2) {
                count++;
                aquariusYear = sc.nextLine();
            }
            aquariusYear = aquariusYear.substring(16, aquariusYear.length()-3);
            aquariusYear = aquariusYear.replace("\', \'", " ");
            aquariusYear = aquariusYear.replace("[\\\"", " ");
            aquariusYear = aquariusYear.replace("\\\"]", " ");
            aquariusYear = aquariusYear.replace("\\u2019", " ");
            sc.close();
            model.addAttribute("aquariusYear", aquariusYear);
        }

        url = new URL("http://horoscope-api.herokuapp.com/horoscope/month/aquarius");
        conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        responsecode = conn.getResponseCode();
        if(responsecode != 200) throw new RuntimeException("HttpResponseCode: " + responsecode);
        else {
            Scanner sc = new Scanner(url.openStream());
            String aquariusMonth = "";
            int count = 0;
            while(count < 2) {
                count++;
                aquariusMonth = sc.nextLine();
            }
            aquariusMonth = aquariusMonth.substring(16, aquariusMonth.length()-3);
            aquariusMonth = aquariusMonth.replace("\', \'", " ");
            aquariusMonth = aquariusMonth.replace("[\\\"", " ");
            aquariusMonth = aquariusMonth.replace("\\\"]", " ");
            aquariusMonth = aquariusMonth.replace("\\u2019", " ");
            sc.close();
            model.addAttribute("aquariusMonth", aquariusMonth);
        }

        url = new URL("http://horoscope-api.herokuapp.com/horoscope/week/aquarius");
        conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        responsecode = conn.getResponseCode();
        if(responsecode != 200) throw new RuntimeException("HttpResponseCode: " + responsecode);
        else {
            Scanner sc = new Scanner(url.openStream());
            String aquariusWeek = "";
            int count = 0;
            while(count < 2) {
                count++;
                aquariusWeek = sc.nextLine();
            }
            aquariusWeek = aquariusWeek.substring(16, aquariusWeek.length()-3);
            aquariusWeek = aquariusWeek.replace("\', \'", " ");
            aquariusWeek = aquariusWeek.replace("[\\\"", " ");
            aquariusWeek = aquariusWeek.replace("\\\"]", " ");
            aquariusWeek = aquariusWeek.replace("\\u2019", " ");
            sc.close();
            model.addAttribute("aquariusWeek", aquariusWeek);
        }

        url = new URL("http://horoscope-api.herokuapp.com/horoscope/today/aquarius");
        conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        responsecode = conn.getResponseCode();
        if(responsecode != 200) throw new RuntimeException("HttpResponseCode: " + responsecode);
        else {
            Scanner sc = new Scanner(url.openStream());
            String aquariusToday = "";
            int count = 0;
            while(count < 3) {
                count++;
                aquariusToday = sc.nextLine();
            }
            aquariusToday = aquariusToday.substring(16, aquariusToday.length()-3);
            aquariusToday = aquariusToday.replace("\', \'", " ");
            aquariusToday = aquariusToday.replace("[\\\"", " ");
            aquariusToday = aquariusToday.replace("\\\"]", " ");
            aquariusToday = aquariusToday.replace("\\u2019", " ");
            sc.close();
            model.addAttribute("aquariusToday", aquariusToday);
        }
    }

    @GetMapping("/Pisces")
    public String pisces() {
        return "horoscopes/pisces";
    }
    @ModelAttribute
    public void piscesInfo(Model model) throws IOException  {
        URL url = new URL("http://horoscope-api.herokuapp.com/horoscope/year/pisces");
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        int responsecode = conn.getResponseCode();
        if(responsecode != 200) throw new RuntimeException("HttpResponseCode: " + responsecode);
        else {
            Scanner sc = new Scanner(url.openStream());
            String piscesYear = "";
            int count = 0;
            while(count < 2) {
                count++;
                piscesYear = sc.nextLine();
            }
            piscesYear = piscesYear.substring(16, piscesYear.length()-3);
            piscesYear = piscesYear.replace("\', \'", " ");
            piscesYear = piscesYear.replace("[\\\"", " ");
            piscesYear = piscesYear.replace("\\\"]", " ");
            piscesYear = piscesYear.replace("\\u2019", " ");
            sc.close();
            model.addAttribute("piscesYear", piscesYear);
        }

        url = new URL("http://horoscope-api.herokuapp.com/horoscope/month/pisces");
        conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        responsecode = conn.getResponseCode();
        if(responsecode != 200) throw new RuntimeException("HttpResponseCode: " + responsecode);
        else {
            Scanner sc = new Scanner(url.openStream());
            String piscesMonth = "";
            int count = 0;
            while(count < 2) {
                count++;
                piscesMonth = sc.nextLine();
            }
            piscesMonth = piscesMonth.substring(16, piscesMonth.length()-3);
            piscesMonth = piscesMonth.replace("\', \'", " ");
            piscesMonth = piscesMonth.replace("[\\\"", " ");
            piscesMonth = piscesMonth.replace("\\\"]", " ");
            piscesMonth = piscesMonth.replace("\\u2019", " ");
            sc.close();
            model.addAttribute("piscesMonth", piscesMonth);
        }

        url = new URL("http://horoscope-api.herokuapp.com/horoscope/week/pisces");
        conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        responsecode = conn.getResponseCode();
        if(responsecode != 200) throw new RuntimeException("HttpResponseCode: " + responsecode);
        else {
            Scanner sc = new Scanner(url.openStream());
            String piscesWeek = "";
            int count = 0;
            while(count < 2) {
                count++;
                piscesWeek = sc.nextLine();
            }
            piscesWeek = piscesWeek.substring(16, piscesWeek.length()-3);
            piscesWeek = piscesWeek.replace("\', \'", " ");
            piscesWeek = piscesWeek.replace("[\\\"", " ");
            piscesWeek = piscesWeek.replace("\\\"]", " ");
            piscesWeek = piscesWeek.replace("\\u2019", " ");
            sc.close();
            model.addAttribute("piscesWeek", piscesWeek);
        }

        url = new URL("http://horoscope-api.herokuapp.com/horoscope/today/pisces");
        conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        responsecode = conn.getResponseCode();
        if(responsecode != 200) throw new RuntimeException("HttpResponseCode: " + responsecode);
        else {
            Scanner sc = new Scanner(url.openStream());
            String piscesToday = "";
            int count = 0;
            while(count < 3) {
                count++;
                piscesToday = sc.nextLine();
            }
            piscesToday = piscesToday.substring(16, piscesToday.length()-3);
            piscesToday = piscesToday.replace("\', \'", " ");
            piscesToday = piscesToday.replace("[\\\"", " ");
            piscesToday = piscesToday.replace("\\\"]", " ");
            piscesToday = piscesToday.replace("\\u2019", " ");
            sc.close();
            model.addAttribute("piscesToday", piscesToday);
        }
    }

    @GetMapping("/Aries")
    public String aries() {
        return "horoscopes/aries";
    }
    @ModelAttribute
    public void ariesInfo(Model model) throws IOException  {
        URL url = new URL("http://horoscope-api.herokuapp.com/horoscope/year/aries");
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        int responsecode = conn.getResponseCode();
        if(responsecode != 200) throw new RuntimeException("HttpResponseCode: " + responsecode);
        else {
            Scanner sc = new Scanner(url.openStream());
            String ariesYear = "";
            int count = 0;
            while(count < 2) {
                count++;
                ariesYear = sc.nextLine();
            }
            ariesYear = ariesYear.substring(16, ariesYear.length()-3);
            ariesYear = ariesYear.replace("\', \'", " ");
            ariesYear = ariesYear.replace("[\\\"", " ");
            ariesYear = ariesYear.replace("\\\"]", " ");
            ariesYear = ariesYear.replace("\\u2019", " ");
            sc.close();
            model.addAttribute("ariesYear", ariesYear);
        }

        url = new URL("http://horoscope-api.herokuapp.com/horoscope/month/aries");
        conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        responsecode = conn.getResponseCode();
        if(responsecode != 200) throw new RuntimeException("HttpResponseCode: " + responsecode);
        else {
            Scanner sc = new Scanner(url.openStream());
            String ariesMonth = "";
            int count = 0;
            while(count < 2) {
                count++;
                ariesMonth = sc.nextLine();
            }
            ariesMonth = ariesMonth.substring(16, ariesMonth.length()-3);
            ariesMonth = ariesMonth.replace("\', \'", " ");
            ariesMonth = ariesMonth.replace("[\\\"", " ");
            ariesMonth = ariesMonth.replace("\\\"]", " ");
            ariesMonth = ariesMonth.replace("\\u2019", " ");
            sc.close();
            model.addAttribute("ariesMonth", ariesMonth);
        }

        url = new URL("http://horoscope-api.herokuapp.com/horoscope/week/aries");
        conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        responsecode = conn.getResponseCode();
        if(responsecode != 200) throw new RuntimeException("HttpResponseCode: " + responsecode);
        else {
            Scanner sc = new Scanner(url.openStream());
            String ariesWeek = "";
            int count = 0;
            while(count < 2) {
                count++;
                ariesWeek = sc.nextLine();
            }
            ariesWeek = ariesWeek.substring(16, ariesWeek.length()-3);
            ariesWeek = ariesWeek.replace("\', \'", " ");
            ariesWeek = ariesWeek.replace("[\\\"", " ");
            ariesWeek = ariesWeek.replace("\\\"]", " ");
            ariesWeek = ariesWeek.replace("\\u2019", " ");
            sc.close();
            model.addAttribute("ariesWeek", ariesWeek);
        }

        url = new URL("http://horoscope-api.herokuapp.com/horoscope/today/aries");
        conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        responsecode = conn.getResponseCode();
        if(responsecode != 200) throw new RuntimeException("HttpResponseCode: " + responsecode);
        else {
            Scanner sc = new Scanner(url.openStream());
            String ariesToday = "";
            int count = 0;
            while(count < 3) {
                count++;
                ariesToday = sc.nextLine();
            }
            ariesToday = ariesToday.substring(16, ariesToday.length()-3);
            ariesToday = ariesToday.replace("\', \'", " ");
            ariesToday = ariesToday.replace("[\\\"", " ");
            ariesToday = ariesToday.replace("\\\"]", " ");
            ariesToday = ariesToday.replace("\\u2019", " ");
            sc.close();
            model.addAttribute("ariesToday", ariesToday);
        }
    }

    @GetMapping("/Taurus")
    public String taurus() {
        return "horoscopes/taurus";
    }
    @ModelAttribute
    public void taurusInfo(Model model) throws IOException  {
        URL url = new URL("http://horoscope-api.herokuapp.com/horoscope/year/taurus");
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        int responsecode = conn.getResponseCode();
        if(responsecode != 200) throw new RuntimeException("HttpResponseCode: " + responsecode);
        else {
            Scanner sc = new Scanner(url.openStream());
            String taurusYear = "";
            int count = 0;
            while(count < 2) {
                count++;
                taurusYear = sc.nextLine();
            }
            taurusYear = taurusYear.substring(16, taurusYear.length()-3);
            taurusYear = taurusYear.replace("\', \'", " ");
            taurusYear = taurusYear.replace("[\\\"", " ");
            taurusYear = taurusYear.replace("\\\"]", " ");
            taurusYear = taurusYear.replace("\\u2019", " ");
            sc.close();
            model.addAttribute("taurusYear", taurusYear);
        }

        url = new URL("http://horoscope-api.herokuapp.com/horoscope/month/taurus");
        conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        responsecode = conn.getResponseCode();
        if(responsecode != 200) throw new RuntimeException("HttpResponseCode: " + responsecode);
        else {
            Scanner sc = new Scanner(url.openStream());
            String taurusMonth = "";
            int count = 0;
            while(count < 2) {
                count++;
                taurusMonth = sc.nextLine();
            }
            taurusMonth = taurusMonth.substring(16, taurusMonth.length()-3);
            taurusMonth = taurusMonth.replace("\', \'", " ");
            taurusMonth = taurusMonth.replace("[\\\"", " ");
            taurusMonth = taurusMonth.replace("\\\"]", " ");
            taurusMonth = taurusMonth.replace("\\u2019", " ");
            sc.close();
            model.addAttribute("taurusMonth", taurusMonth);
        }

        url = new URL("http://horoscope-api.herokuapp.com/horoscope/week/taurus");
        conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        responsecode = conn.getResponseCode();
        if(responsecode != 200) throw new RuntimeException("HttpResponseCode: " + responsecode);
        else {
            Scanner sc = new Scanner(url.openStream());
            String taurusWeek = "";
            int count = 0;
            while(count < 2) {
                count++;
                taurusWeek = sc.nextLine();
            }
            taurusWeek = taurusWeek.substring(16, taurusWeek.length()-3);
            taurusWeek = taurusWeek.replace("\', \'", " ");
            taurusWeek = taurusWeek.replace("[\\\"", " ");
            taurusWeek = taurusWeek.replace("\\\"]", " ");
            taurusWeek = taurusWeek.replace("\\u2019", " ");
            sc.close();
            model.addAttribute("taurusWeek", taurusWeek);
        }

        url = new URL("http://horoscope-api.herokuapp.com/horoscope/today/taurus");
        conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        responsecode = conn.getResponseCode();
        if(responsecode != 200) throw new RuntimeException("HttpResponseCode: " + responsecode);
        else {
            Scanner sc = new Scanner(url.openStream());
            String taurusToday = "";
            int count = 0;
            while(count < 3) {
                count++;
                taurusToday = sc.nextLine();
            }
            taurusToday = taurusToday.substring(16, taurusToday.length()-3);
            taurusToday = taurusToday.replace("\', \'", " ");
            taurusToday = taurusToday.replace("[\\\"", " ");
            taurusToday = taurusToday.replace("\\\"]", " ");
            taurusToday = taurusToday.replace("\\u2019", " ");
            sc.close();
            model.addAttribute("taurusToday", taurusToday);
        }
    }

    @GetMapping("/Gemini")
    public String gemini() {
        return "horoscopes/gemini";
    }
    @ModelAttribute
    public void geminiInfo(Model model) throws IOException  {
        URL url = new URL("http://horoscope-api.herokuapp.com/horoscope/year/gemini");
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        int responsecode = conn.getResponseCode();
        if(responsecode != 200) throw new RuntimeException("HttpResponseCode: " + responsecode);
        else {
            Scanner sc = new Scanner(url.openStream());
            String geminiYear = "";
            int count = 0;
            while(count < 2) {
                count++;
                geminiYear = sc.nextLine();
            }
            geminiYear = geminiYear.substring(16, geminiYear.length()-3);
            geminiYear = geminiYear.replace("\', \'", " ");
            geminiYear = geminiYear.replace("[\\\"", " ");
            geminiYear = geminiYear.replace("\\\"]", " ");
            geminiYear = geminiYear.replace("\\u2019", " ");
            sc.close();
            model.addAttribute("geminiYear", geminiYear);
        }

        url = new URL("http://horoscope-api.herokuapp.com/horoscope/month/gemini");
        conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        responsecode = conn.getResponseCode();
        if(responsecode != 200) throw new RuntimeException("HttpResponseCode: " + responsecode);
        else {
            Scanner sc = new Scanner(url.openStream());
            String geminiMonth = "";
            int count = 0;
            while(count < 2) {
                count++;
                geminiMonth = sc.nextLine();
            }
            geminiMonth = geminiMonth.substring(16, geminiMonth.length()-3);
            geminiMonth = geminiMonth.replace("\', \'", " ");
            geminiMonth = geminiMonth.replace("[\\\"", " ");
            geminiMonth = geminiMonth.replace("\\\"]", " ");
            geminiMonth = geminiMonth.replace("\\u2019", " ");
            sc.close();
            model.addAttribute("geminiMonth", geminiMonth);
        }

        url = new URL("http://horoscope-api.herokuapp.com/horoscope/week/gemini");
        conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        responsecode = conn.getResponseCode();
        if(responsecode != 200) throw new RuntimeException("HttpResponseCode: " + responsecode);
        else {
            Scanner sc = new Scanner(url.openStream());
            String geminiWeek = "";
            int count = 0;
            while(count < 2) {
                count++;
                geminiWeek = sc.nextLine();
            }
            geminiWeek = geminiWeek.substring(16, geminiWeek.length()-3);
            geminiWeek = geminiWeek.replace("\', \'", " ");
            geminiWeek = geminiWeek.replace("[\\\"", " ");
            geminiWeek = geminiWeek.replace("\\\"]", " ");
            geminiWeek = geminiWeek.replace("\\u2019", " ");

            sc.close();
            model.addAttribute("geminiWeek", geminiWeek);
        }

        url = new URL("http://horoscope-api.herokuapp.com/horoscope/today/gemini");
        conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        responsecode = conn.getResponseCode();
        if(responsecode != 200) throw new RuntimeException("HttpResponseCode: " + responsecode);
        else {
            Scanner sc = new Scanner(url.openStream());
            String geminiToday = "";
            int count = 0;
            while(count < 3) {
                count++;
                geminiToday = sc.nextLine();
            }
            geminiToday = geminiToday.substring(16, geminiToday.length()-3);
            geminiToday = geminiToday.replace("\', \'", " ");
            geminiToday = geminiToday.replace("[\\\"", " ");
            geminiToday = geminiToday.replace("\\\"]", " ");
            geminiToday = geminiToday.replace("\\u2019", " ");
            sc.close();
            model.addAttribute("geminiToday", geminiToday);
        }
    }

    @GetMapping("/Cancer")
    public String cancer() {
        return "horoscopes/cancer";
    }
    @ModelAttribute
    public void cancerInfo(Model model) throws IOException  {
        URL url = new URL("http://horoscope-api.herokuapp.com/horoscope/year/cancer");
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        int responsecode = conn.getResponseCode();
        if(responsecode != 200) throw new RuntimeException("HttpResponseCode: " + responsecode);
        else {
            Scanner sc = new Scanner(url.openStream());
            String cancerYear = "";
            int count = 0;
            while(count < 2) {
                count++;
                cancerYear = sc.nextLine();
            }
            cancerYear = cancerYear.substring(16, cancerYear.length()-3);
            cancerYear = cancerYear.replace("\', \'", " ");
            cancerYear = cancerYear.replace("[\\\"", " ");
            cancerYear = cancerYear.replace("\\\"]", " ");
            cancerYear = cancerYear.replace("\\u2019", " ");
            sc.close();
            model.addAttribute("cancerYear", cancerYear);
        }

        url = new URL("http://horoscope-api.herokuapp.com/horoscope/month/cancer");
        conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        responsecode = conn.getResponseCode();
        if(responsecode != 200) throw new RuntimeException("HttpResponseCode: " + responsecode);
        else {
            Scanner sc = new Scanner(url.openStream());
            String cancerMonth = "";
            int count = 0;
            while(count < 2) {
                count++;
                cancerMonth = sc.nextLine();
            }
            cancerMonth = cancerMonth.substring(16, cancerMonth.length()-3);
            cancerMonth = cancerMonth.replace("\', \'", " ");
            cancerMonth = cancerMonth.replace("[\\\"", " ");
            cancerMonth = cancerMonth.replace("\\\"]", " ");
            cancerMonth = cancerMonth.replace("\\u2019", " ");
            sc.close();
            model.addAttribute("cancerMonth", cancerMonth);
        }

        url = new URL("http://horoscope-api.herokuapp.com/horoscope/week/cancer");
        conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        responsecode = conn.getResponseCode();
        if(responsecode != 200) throw new RuntimeException("HttpResponseCode: " + responsecode);
        else {
            Scanner sc = new Scanner(url.openStream());
            String cancerWeek = "";
            int count = 0;
            while(count < 2) {
                count++;
                cancerWeek = sc.nextLine();
            }
            cancerWeek = cancerWeek.substring(16, cancerWeek.length()-3);
            cancerWeek = cancerWeek.replace("\', \'", " ");
            cancerWeek = cancerWeek.replace("[\\\"", " ");
            cancerWeek = cancerWeek.replace("\\\"]", " ");
            cancerWeek = cancerWeek.replace("\\u2019", " ");

            sc.close();
            model.addAttribute("cancerWeek", cancerWeek);
        }

        url = new URL("http://horoscope-api.herokuapp.com/horoscope/today/cancer");
        conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        responsecode = conn.getResponseCode();
        if(responsecode != 200) throw new RuntimeException("HttpResponseCode: " + responsecode);
        else {
            Scanner sc = new Scanner(url.openStream());
            String cancerToday = "";
            int count = 0;
            while(count < 3) {
                count++;
                cancerToday = sc.nextLine();
            }
            cancerToday = cancerToday.substring(16, cancerToday.length()-3);
            cancerToday = cancerToday.replace("\', \'", " ");
            cancerToday = cancerToday.replace("[\\\"", " ");
            cancerToday = cancerToday.replace("\\\"]", " ");
            cancerToday = cancerToday.replace("\\u2019", " ");
            sc.close();
            model.addAttribute("cancerToday", cancerToday);
        }
    }

    @GetMapping("/Leo")
    public String leo() {
        return "horoscopes/leo";
    }
    @ModelAttribute
    public void leoInfo(Model model) throws IOException  {
        URL url = new URL("http://horoscope-api.herokuapp.com/horoscope/year/leo");
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        int responsecode = conn.getResponseCode();
        if(responsecode != 200) throw new RuntimeException("HttpResponseCode: " + responsecode);
        else {
            Scanner sc = new Scanner(url.openStream());
            String leoYear = "";
            int count = 0;
            while(count < 2) {
                count++;
                leoYear = sc.nextLine();
            }
            leoYear = leoYear.substring(16, leoYear.length()-3);
            leoYear = leoYear.replace("\', \'", " ");
            leoYear = leoYear.replace("[\\\"", " ");
            leoYear = leoYear.replace("\\\"]", " ");
            leoYear = leoYear.replace("\\u2019", " ");
            sc.close();
            model.addAttribute("leoYear", leoYear);
        }

        url = new URL("http://horoscope-api.herokuapp.com/horoscope/month/leo");
        conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        responsecode = conn.getResponseCode();
        if(responsecode != 200) throw new RuntimeException("HttpResponseCode: " + responsecode);
        else {
            Scanner sc = new Scanner(url.openStream());
            String leoMonth = "";
            int count = 0;
            while(count < 2) {
                count++;
                leoMonth = sc.nextLine();
            }
            leoMonth = leoMonth.substring(16, leoMonth.length()-3);
            leoMonth = leoMonth.replace("\', \'", " ");
            leoMonth = leoMonth.replace("[\\\"", " ");
            leoMonth = leoMonth.replace("\\\"]", " ");
            leoMonth = leoMonth.replace("\\u2019", " ");
            sc.close();
            model.addAttribute("leoMonth", leoMonth);
        }

        url = new URL("http://horoscope-api.herokuapp.com/horoscope/week/leo");
        conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        responsecode = conn.getResponseCode();
        if(responsecode != 200) throw new RuntimeException("HttpResponseCode: " + responsecode);
        else {
            Scanner sc = new Scanner(url.openStream());
            String leoWeek = "";
            int count = 0;
            while(count < 2) {
                count++;
                leoWeek = sc.nextLine();
            }
            leoWeek = leoWeek.substring(16, leoWeek.length()-3);
            leoWeek = leoWeek.replace("\', \'", " ");
            leoWeek = leoWeek.replace("[\\\"", " ");
            leoWeek = leoWeek.replace("\\\"]", " ");
            leoWeek = leoWeek.replace("\\u2019", " ");

            sc.close();
            model.addAttribute("leoWeek", leoWeek);
        }

        url = new URL("http://horoscope-api.herokuapp.com/horoscope/today/leo");
        conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        responsecode = conn.getResponseCode();
        if(responsecode != 200) throw new RuntimeException("HttpResponseCode: " + responsecode);
        else {
            Scanner sc = new Scanner(url.openStream());
            String leoToday = "";
            int count = 0;
            while(count < 3) {
                count++;
                leoToday = sc.nextLine();
            }
            leoToday = leoToday.substring(16, leoToday.length()-3);
            leoToday = leoToday.replace("\', \'", " ");
            leoToday = leoToday.replace("[\\\"", " ");
            leoToday = leoToday.replace("\\\"]", " ");
            leoToday = leoToday.replace("\\u2019", " ");
            sc.close();
            model.addAttribute("leoToday", leoToday);
        }
    }

    @GetMapping("/Virgo")
    public String virgo() {
        return "horoscopes/virgo";
    }
    @ModelAttribute
    public void virgoInfo(Model model) throws IOException  {
        URL url = new URL("http://horoscope-api.herokuapp.com/horoscope/year/virgo");
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        int responsecode = conn.getResponseCode();
        if(responsecode != 200) throw new RuntimeException("HttpResponseCode: " + responsecode);
        else {
            Scanner sc = new Scanner(url.openStream());
            String virgoYear = "";
            int count = 0;
            while(count < 2) {
                count++;
                virgoYear = sc.nextLine();
            }
            virgoYear = virgoYear.substring(16, virgoYear.length()-3);
            virgoYear = virgoYear.replace("\', \'", " ");
            virgoYear = virgoYear.replace("[\\\"", " ");
            virgoYear = virgoYear.replace("\\\"]", " ");
            virgoYear = virgoYear.replace("\\u2019", " ");
            sc.close();
            model.addAttribute("virgoYear", virgoYear);
        }

        url = new URL("http://horoscope-api.herokuapp.com/horoscope/month/virgo");
        conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        responsecode = conn.getResponseCode();
        if(responsecode != 200) throw new RuntimeException("HttpResponseCode: " + responsecode);
        else {
            Scanner sc = new Scanner(url.openStream());
            String virgoMonth = "";
            int count = 0;
            while(count < 2) {
                count++;
                virgoMonth = sc.nextLine();
            }
            virgoMonth = virgoMonth.substring(16, virgoMonth.length()-3);
            virgoMonth = virgoMonth.replace("\', \'", " ");
            virgoMonth = virgoMonth.replace("[\\\"", " ");
            virgoMonth = virgoMonth.replace("\\\"]", " ");
            virgoMonth = virgoMonth.replace("\\u2019", " ");
            sc.close();
            model.addAttribute("virgoMonth", virgoMonth);
        }

        url = new URL("http://horoscope-api.herokuapp.com/horoscope/week/virgo");
        conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        responsecode = conn.getResponseCode();
        if(responsecode != 200) throw new RuntimeException("HttpResponseCode: " + responsecode);
        else {
            Scanner sc = new Scanner(url.openStream());
            String virgoWeek = "";
            int count = 0;
            while(count < 2) {
                count++;
                virgoWeek = sc.nextLine();
            }
            virgoWeek = virgoWeek.substring(16, virgoWeek.length()-3);
            virgoWeek = virgoWeek.replace("\', \'", " ");
            virgoWeek = virgoWeek.replace("[\\\"", " ");
            virgoWeek = virgoWeek.replace("\\\"]", " ");
            virgoWeek = virgoWeek.replace("\\u2019", " ");

            sc.close();
            model.addAttribute("virgoWeek", virgoWeek);
        }

        url = new URL("http://horoscope-api.herokuapp.com/horoscope/today/virgo");
        conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        responsecode = conn.getResponseCode();
        if(responsecode != 200) throw new RuntimeException("HttpResponseCode: " + responsecode);
        else {
            Scanner sc = new Scanner(url.openStream());
            String virgoToday = "";
            int count = 0;
            while(count < 3) {
                count++;
                virgoToday = sc.nextLine();
            }
            virgoToday = virgoToday.substring(16, virgoToday.length()-3);
            virgoToday = virgoToday.replace("\', \'", " ");
            virgoToday = virgoToday.replace("[\\\"", " ");
            virgoToday = virgoToday.replace("\\\"]", " ");
            virgoToday = virgoToday.replace("\\u2019", " ");
            sc.close();
            model.addAttribute("virgoToday", virgoToday);
        }
    }

    @GetMapping("/Libra")
    public String libra() {
        return "horoscopes/libra";
    }
    @ModelAttribute
    public void libraInfo(Model model) throws IOException  {
        URL url = new URL("http://horoscope-api.herokuapp.com/horoscope/year/libra");
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        int responsecode = conn.getResponseCode();
        if(responsecode != 200) throw new RuntimeException("HttpResponseCode: " + responsecode);
        else {
            Scanner sc = new Scanner(url.openStream());
            String libraYear = "";
            int count = 0;
            while(count < 2) {
                count++;
                libraYear = sc.nextLine();
            }
            libraYear = libraYear.substring(16, libraYear.length()-3);
            libraYear = libraYear.replace("\', \'", " ");
            libraYear = libraYear.replace("[\\\"", " ");
            libraYear = libraYear.replace("\\\"]", " ");
            libraYear = libraYear.replace("\\u2019", " ");
            sc.close();
            model.addAttribute("libraYear", libraYear);
        }

        url = new URL("http://horoscope-api.herokuapp.com/horoscope/month/libra");
        conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        responsecode = conn.getResponseCode();
        if(responsecode != 200) throw new RuntimeException("HttpResponseCode: " + responsecode);
        else {
            Scanner sc = new Scanner(url.openStream());
            String libraMonth = "";
            int count = 0;
            while(count < 2) {
                count++;
                libraMonth = sc.nextLine();
            }
            libraMonth = libraMonth.substring(16, libraMonth.length()-3);
            libraMonth = libraMonth.replace("\', \'", " ");
            libraMonth = libraMonth.replace("[\\\"", " ");
            libraMonth = libraMonth.replace("\\\"]", " ");
            libraMonth = libraMonth.replace("\\u2019", " ");
            sc.close();
            model.addAttribute("libraMonth", libraMonth);
        }

        url = new URL("http://horoscope-api.herokuapp.com/horoscope/week/libra");
        conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        responsecode = conn.getResponseCode();
        if(responsecode != 200) throw new RuntimeException("HttpResponseCode: " + responsecode);
        else {
            Scanner sc = new Scanner(url.openStream());
            String libraWeek = "";
            int count = 0;
            while(count < 2) {
                count++;
                libraWeek = sc.nextLine();
            }
            libraWeek = libraWeek.substring(16, libraWeek.length()-3);
            libraWeek = libraWeek.replace("\', \'", " ");
            libraWeek = libraWeek.replace("[\\\"", " ");
            libraWeek = libraWeek.replace("\\\"]", " ");
            libraWeek = libraWeek.replace("\\u2019", " ");

            sc.close();
            model.addAttribute("libraWeek", libraWeek);
        }

        url = new URL("http://horoscope-api.herokuapp.com/horoscope/today/libra");
        conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        responsecode = conn.getResponseCode();
        if(responsecode != 200) throw new RuntimeException("HttpResponseCode: " + responsecode);
        else {
            Scanner sc = new Scanner(url.openStream());
            String libraToday = "";
            int count = 0;
            while(count < 3) {
                count++;
                libraToday = sc.nextLine();
            }
            libraToday = libraToday.substring(16, libraToday.length()-3);
            libraToday = libraToday.replace("\', \'", " ");
            libraToday = libraToday.replace("[\\\"", " ");
            libraToday = libraToday.replace("\\\"]", " ");
            libraToday = libraToday.replace("\\u2019", " ");
            sc.close();
            model.addAttribute("libraToday", libraToday);
        }
    }

    @GetMapping("/Scorpio")
    public String scorpio() {
        return "horoscopes/scorpio";
    }
    @ModelAttribute
    public void scorpioInfo(Model model) throws IOException  {
        URL url = new URL("http://horoscope-api.herokuapp.com/horoscope/year/scorpio");
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        int responsecode = conn.getResponseCode();
        if(responsecode != 200) throw new RuntimeException("HttpResponseCode: " + responsecode);
        else {
            Scanner sc = new Scanner(url.openStream());
            String scorpioYear = "";
            int count = 0;
            while(count < 2) {
                count++;
                scorpioYear = sc.nextLine();
            }
            scorpioYear = scorpioYear.substring(16, scorpioYear.length()-3);
            scorpioYear = scorpioYear.replace("\', \'", " ");
            scorpioYear = scorpioYear.replace("[\\\"", " ");
            scorpioYear = scorpioYear.replace("\\\"]", " ");
            scorpioYear = scorpioYear.replace("\\u2019", " ");
            sc.close();
            model.addAttribute("scorpioYear", scorpioYear);
        }

        url = new URL("http://horoscope-api.herokuapp.com/horoscope/month/scorpio");
        conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        responsecode = conn.getResponseCode();
        if(responsecode != 200) throw new RuntimeException("HttpResponseCode: " + responsecode);
        else {
            Scanner sc = new Scanner(url.openStream());
            String scorpioMonth = "";
            int count = 0;
            while(count < 2) {
                count++;
                scorpioMonth = sc.nextLine();
            }
            scorpioMonth = scorpioMonth.substring(16, scorpioMonth.length()-3);
            scorpioMonth = scorpioMonth.replace("\', \'", " ");
            scorpioMonth = scorpioMonth.replace("[\\\"", " ");
            scorpioMonth = scorpioMonth.replace("\\\"]", " ");
            scorpioMonth = scorpioMonth.replace("\\u2019", " ");
            sc.close();
            model.addAttribute("scorpioMonth", scorpioMonth);
        }

        url = new URL("http://horoscope-api.herokuapp.com/horoscope/week/scorpio");
        conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        responsecode = conn.getResponseCode();
        if(responsecode != 200) throw new RuntimeException("HttpResponseCode: " + responsecode);
        else {
            Scanner sc = new Scanner(url.openStream());
            String scorpioWeek = "";
            int count = 0;
            while(count < 2) {
                count++;
                scorpioWeek = sc.nextLine();
            }
            scorpioWeek = scorpioWeek.substring(16, scorpioWeek.length()-3);
            scorpioWeek = scorpioWeek.replace("\', \'", " ");
            scorpioWeek = scorpioWeek.replace("[\\\"", " ");
            scorpioWeek = scorpioWeek.replace("\\\"]", " ");
            scorpioWeek = scorpioWeek.replace("\\u2019", " ");

            sc.close();
            model.addAttribute("scorpioWeek", scorpioWeek);
        }

        url = new URL("http://horoscope-api.herokuapp.com/horoscope/today/scorpio");
        conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        responsecode = conn.getResponseCode();
        if(responsecode != 200) throw new RuntimeException("HttpResponseCode: " + responsecode);
        else {
            Scanner sc = new Scanner(url.openStream());
            String scorpioToday = "";
            int count = 0;
            while(count < 3) {
                count++;
                scorpioToday = sc.nextLine();
            }
            scorpioToday = scorpioToday.substring(16, scorpioToday.length()-3);
            scorpioToday = scorpioToday.replace("\', \'", " ");
            scorpioToday = scorpioToday.replace("[\\\"", " ");
            scorpioToday = scorpioToday.replace("\\\"]", " ");
            scorpioToday = scorpioToday.replace("\\u2019", " ");
            sc.close();
            model.addAttribute("scorpioToday", scorpioToday);
        }
    }

    @GetMapping("/Sagittarius")
    public String sagittarius() {
        return "horoscopes/sagittarius";
    }
    @ModelAttribute
    public void sagittariusInfo(Model model) throws IOException  {
        URL url = new URL("http://horoscope-api.herokuapp.com/horoscope/year/sagittarius");
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        int responsecode = conn.getResponseCode();
        if(responsecode != 200) throw new RuntimeException("HttpResponseCode: " + responsecode);
        else {
            Scanner sc = new Scanner(url.openStream());
            String sagittariusYear = "";
            int count = 0;
            while(count < 2) {
                count++;
                sagittariusYear = sc.nextLine();
            }
            sagittariusYear = sagittariusYear.substring(16, sagittariusYear.length()-3);
            sagittariusYear = sagittariusYear.replace("\', \'", " ");
            sagittariusYear = sagittariusYear.replace("[\\\"", " ");
            sagittariusYear = sagittariusYear.replace("\\\"]", " ");
            sagittariusYear = sagittariusYear.replace("\\u2019", " ");
            sc.close();
            model.addAttribute("sagittariusYear", sagittariusYear);
        }

        url = new URL("http://horoscope-api.herokuapp.com/horoscope/month/sagittarius");
        conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        responsecode = conn.getResponseCode();
        if(responsecode != 200) throw new RuntimeException("HttpResponseCode: " + responsecode);
        else {
            Scanner sc = new Scanner(url.openStream());
            String sagittariusMonth = "";
            int count = 0;
            while(count < 2) {
                count++;
                sagittariusMonth = sc.nextLine();
            }
            sagittariusMonth = sagittariusMonth.substring(16, sagittariusMonth.length()-3);
            sagittariusMonth = sagittariusMonth.replace("\', \'", " ");
            sagittariusMonth = sagittariusMonth.replace("[\\\"", " ");
            sagittariusMonth = sagittariusMonth.replace("\\\"]", " ");
            sagittariusMonth = sagittariusMonth.replace("\\u2019", " ");
            sc.close();
            model.addAttribute("sagittariusMonth", sagittariusMonth);
        }

        url = new URL("http://horoscope-api.herokuapp.com/horoscope/week/sagittarius");
        conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        responsecode = conn.getResponseCode();
        if(responsecode != 200) throw new RuntimeException("HttpResponseCode: " + responsecode);
        else {
            Scanner sc = new Scanner(url.openStream());
            String sagittariusWeek = "";
            int count = 0;
            while(count < 2) {
                count++;
                sagittariusWeek = sc.nextLine();
            }
            sagittariusWeek = sagittariusWeek.substring(16, sagittariusWeek.length()-3);
            sagittariusWeek = sagittariusWeek.replace("\', \'", " ");
            sagittariusWeek = sagittariusWeek.replace("[\\\"", " ");
            sagittariusWeek = sagittariusWeek.replace("\\\"]", " ");
            sagittariusWeek = sagittariusWeek.replace("\\u2019", " ");

            sc.close();
            model.addAttribute("sagittariusWeek", sagittariusWeek);
        }

        url = new URL("http://horoscope-api.herokuapp.com/horoscope/today/sagittarius");
        conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        responsecode = conn.getResponseCode();
        if(responsecode != 200) throw new RuntimeException("HttpResponseCode: " + responsecode);
        else {
            Scanner sc = new Scanner(url.openStream());
            String sagittariusToday = "";
            int count = 0;
            while(count < 3) {
                count++;
                sagittariusToday = sc.nextLine();
            }
            sagittariusToday = sagittariusToday.substring(16, sagittariusToday.length()-3);
            sagittariusToday = sagittariusToday.replace("\', \'", " ");
            sagittariusToday = sagittariusToday.replace("[\\\"", " ");
            sagittariusToday = sagittariusToday.replace("\\\"]", " ");
            sagittariusToday = sagittariusToday.replace("\\u2019", " ");
            sc.close();
            model.addAttribute("sagittariusToday", sagittariusToday);
        }
    }

    @GetMapping("/Capricorn")
    public String capricorn() {
        return "horoscopes/capricorn";
    }
    @ModelAttribute
    public void capricornInfo(Model model) throws IOException  {
        URL url = new URL("http://horoscope-api.herokuapp.com/horoscope/year/capricorn");
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        int responsecode = conn.getResponseCode();
        if(responsecode != 200) throw new RuntimeException("HttpResponseCode: " + responsecode);
        else {
            Scanner sc = new Scanner(url.openStream());
            String capricornYear = "";
            int count = 0;
            while(count < 2) {
                count++;
                capricornYear = sc.nextLine();
            }
            capricornYear = capricornYear.substring(16, capricornYear.length()-3);
            capricornYear = capricornYear.replace("\', \'", " ");
            capricornYear = capricornYear.replace("[\\\"", " ");
            capricornYear = capricornYear.replace("\\\"]", " ");
            capricornYear = capricornYear.replace("\\u2019", " ");
            sc.close();
            model.addAttribute("capricornYear", capricornYear);
        }

        url = new URL("http://horoscope-api.herokuapp.com/horoscope/month/capricorn");
        conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        responsecode = conn.getResponseCode();
        if(responsecode != 200) throw new RuntimeException("HttpResponseCode: " + responsecode);
        else {
            Scanner sc = new Scanner(url.openStream());
            String capricornMonth = "";
            int count = 0;
            while(count < 2) {
                count++;
                capricornMonth = sc.nextLine();
            }
            capricornMonth = capricornMonth.substring(16, capricornMonth.length()-3);
            capricornMonth = capricornMonth.replace("\', \'", " ");
            capricornMonth = capricornMonth.replace("[\\\"", " ");
            capricornMonth = capricornMonth.replace("\\\"]", " ");
            capricornMonth = capricornMonth.replace("\\u2019", " ");
            sc.close();
            model.addAttribute("capricornMonth", capricornMonth);
        }

        url = new URL("http://horoscope-api.herokuapp.com/horoscope/week/capricorn");
        conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        responsecode = conn.getResponseCode();
        if(responsecode != 200) throw new RuntimeException("HttpResponseCode: " + responsecode);
        else {
            Scanner sc = new Scanner(url.openStream());
            String capricornWeek = "";
            int count = 0;
            while(count < 2) {
                count++;
                capricornWeek = sc.nextLine();
            }
            capricornWeek = capricornWeek.substring(16, capricornWeek.length()-3);
            capricornWeek = capricornWeek.replace("\', \'", " ");
            capricornWeek = capricornWeek.replace("[\\\"", " ");
            capricornWeek = capricornWeek.replace("\\\"]", " ");
            capricornWeek = capricornWeek.replace("\\u2019", " ");

            sc.close();
            model.addAttribute("capricornWeek", capricornWeek);
        }

        url = new URL("http://horoscope-api.herokuapp.com/horoscope/today/capricorn");
        conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        responsecode = conn.getResponseCode();
        if(responsecode != 200) throw new RuntimeException("HttpResponseCode: " + responsecode);
        else {
            Scanner sc = new Scanner(url.openStream());
            String capricornToday = "";
            int count = 0;
            while(count < 3) {
                count++;
                capricornToday = sc.nextLine();
            }
            capricornToday = capricornToday.substring(16, capricornToday.length()-3);
            capricornToday = capricornToday.replace("\', \'", " ");
            capricornToday = capricornToday.replace("[\\\"", " ");
            capricornToday = capricornToday.replace("\\\"]", " ");
            capricornToday = capricornToday.replace("\\u2019", " ");
            sc.close();
            model.addAttribute("capricornToday", capricornToday);
        }
    }
}