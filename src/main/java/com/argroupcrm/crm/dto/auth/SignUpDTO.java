package com.argroupcrm.crm.dto.auth;

import lombok.Data;


import javax.validation.constraints.*;

/**
 * Created by ogbozoyan at 16.01.2023
 * github.com/ogbozoyan
 */
@Data
public class SignUpDTO {
    @NotBlank
    @Size(min = 3, max = 20)
    @Pattern(regexp = "^[a-zA-Z0-9]+$")
    private String login;
    @NotBlank
    private String name;
    @NotBlank
    @Size(min = 8)
    @Pattern(regexp = "^[a-zA-Z0-9[!@#$%^&*]]+$")
    private String password;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String phone;
    @Override
    public String toString() {
        return "SignUpDTO{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}