package com.personal.userManagement_app.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column
    private String firstName;

    @NotNull
    @Column
    private String lastName;

    @NotNull
    @Column
    private LocalDate dateOfBirth;

    @NotNull
    private String phoneNumber;

    @Email
    @NotNull
    @Column
    private String email;

    public String getDateOfBirth() {
        return dateOfBirth.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

}
