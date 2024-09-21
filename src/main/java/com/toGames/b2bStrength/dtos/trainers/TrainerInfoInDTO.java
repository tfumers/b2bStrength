package com.toGames.b2bStrength.dtos.trainers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TrainerInfoInDTO {

    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String passTest;

    private String nationality;
    @NotBlank
    private String username;

    private String firstname;

    private String lastname;

    private String birthDate;

    private int dni;

    private String phone;

    private char sex;

    private String icon;

    private String avatar;

    private String description;

}
