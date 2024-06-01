package com.personal.userManagement_app.model.dto;

import com.personal.userManagement_app.utils.validation.annotation.ValidDate;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateDTO {
    @NotNull
    @Positive
    private Long id;
    @Size(min = 2, max = 20, message = "First name length must be between 2 and 20 characters long")
    @NotNull
    private String firstName;
    @NotNull
    @Size(min = 2, max = 20, message = "Last name length must be between 2 and 20 characters long")
    private String lastName;
    @Email(message = "Enter a valid email address")
    @NotNull
    @NotEmpty(message = "Email can not be empty")
    private String email;

    @NotNull
    @NotEmpty(message = "Phone number can not be empty")
    private String phoneNumber;
    @NotNull
    @ValidDate
    @NotEmpty(message = "Date of birth can not be empty")
    private String dateOfBirth;


}
