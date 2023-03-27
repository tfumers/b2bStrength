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

    private String firstname;

    private String lastname;

    private int dni;

    private int phone;

    private char sex;

    private String icon;

    private String avatar;

}
