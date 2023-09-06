package com.demo.BootApp.DTO;

import com.demo.BootApp.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor(staticName="build")
@NoArgsConstructor
public class UserRequest {
    @NotNull(message = "Name should not be null")
    private String name;

    @Email(message = "Email should be valid")
    private String email;

    @Pattern(regexp = ("^\\d{10}$"), message = "Mobile number should be valid") // it looks at numbers from 0 to 9 and checks if there are 10 of them
    private String mobile;

    private String gender;

    @Min(18)
    @Max(60)
    private int age;

    @NotBlank
    private String Nationality;

}
