package Astrology.web;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "astrology.birthday")
@Data
public class BirthdayProperty {

    private int pageSize;
}
