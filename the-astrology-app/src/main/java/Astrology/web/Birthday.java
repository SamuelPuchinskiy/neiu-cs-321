package Astrology.web;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class Birthday {

    @NotNull(message = "You must choose a month")
    private String birthYearUser;

    @NotNull(message = "You must choose a month")
    private String birthMonthUser;

    @NotNull(message = "You must choose a Day")
    private String birthDayUser;

   /* @NotBlank(message = "Name is required")
    private String name;
*/

}
