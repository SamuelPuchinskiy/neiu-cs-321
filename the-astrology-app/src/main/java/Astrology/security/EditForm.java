package Astrology.security;

import Astrology.User;
import Astrology.data.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class EditForm {

    @NotNull
    @Size(min = 5, max = 50, message = "Email must have at least 5 to 50 characters (Case Sensitive)")
    private String email;

    @NotNull
    @NotEmpty(message = "Name is required (Case Sensitive)")
    private String fullname;

    @NotNull
    @Pattern(regexp = "[0-9]{3}-[0-9]{3}-[0-9]{4}", message = "Phone number format: XXX-XXX-XXXX (Case Sensitive)")
    private String cell;

    @NotNull
    @Pattern(regexp = "[0-9]{2}/[0-9]{2}/[0-9]{4}", message = "Birthday format: MM/DD/YYYY (Case Sensitive)")
    private String userBirthday;


}
