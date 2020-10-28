package Astrology.web;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//import javax.validation.constraints.Max;
//import javax.validation.constraints.Min;

@Component
@ConfigurationProperties(prefix = "astrology.birthday")
@Data
public class BirthdayProperty {

    //@Min(value = 0, message="no error")
    //@Max(value = 6, message="error")
    private int pageSize;
}
