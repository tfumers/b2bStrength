package com.toGames.b2bStrength.dtos.clients;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterClientDTO {

    @NotBlank @Email
    private String email;
    @NotBlank
    private String passTest;

    private String nationality;
    @NotBlank
    private String username;

    @NotBlank
    private String firstname;

    @NotBlank
    private String lastname;

    private String birthDate;

    private String dni;

    private String phone;

    private String sex;

    private String icon;

    private String avatar;

}
