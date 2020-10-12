package tacos.security;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import tacos.User;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class RegistrationForm {

    @NotNull
    @Size(min = 5, message = "Username must have at least 5 characters")
    private String username;

    @NotNull
    @Size(min =6, message = "Password must have at least 6 characters")
    private String password;

    @NotNull
    @NotEmpty(message = "Name is required")
    private String fullName;

    @NotNull
    @NotEmpty(message = "Street is required")
    private String street;

    @NotNull
    @NotEmpty(message = "City is required")
    private String city;

    @NotNull
    @Pattern(regexp ="[A-Z]{2}", message = "State must be 2 characters")
    private String state;

    @NotNull
    @Pattern(regexp = "[0-9]{5}", message = "Zip must be 5 digits")
    private String zip;

    @NotNull
    @Pattern(regexp = "[0-9]{3}-[0-9]{3}-[0-9]{4}", message = "Phone number format: XXX-XXX-XXXX")
    private String phone;

    public User toUser(PasswordEncoder passwordEncoder) {

        return new User(username, passwordEncoder.encode(password), fullName, street, city, state, zip, phone);
    }

}
