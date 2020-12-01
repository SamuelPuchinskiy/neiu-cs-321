package Astrology.security;

import Astrology.User;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class SignUpForm {

    @NotNull
    @Size(min = 5, max = 50, message = "Username must have at least 5 to 50 characters (Case Sensitive)")

    private String username;
    @NotNull
    @Size(min = 8, max = 25, message = "Password must have at least 8 to 25 characters (Case Sensitive)")
    private String password;

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

    public User toUser(PasswordEncoder passwordEncoder) {
        return new User(username, passwordEncoder.encode(password), email, fullname, cell, userBirthday);
    }

    public static User updateUser(User updateUser, PasswordEncoder passwordEncoder, SignUpForm editForm) {
        updateUser.setUsername(editForm.getUsername());
        updateUser.setPassword(passwordEncoder.encode(editForm.getPassword()));
        updateUser.setEmail(editForm.getEmail());
        updateUser.setFullname(editForm.getFullname());
        updateUser.setCell(editForm.getCell());
        updateUser.setUserBirthday(editForm.getUserBirthday());

        return updateUser;
    }
}