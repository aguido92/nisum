package com.nisum.challenge.dto;

import com.nisum.challenge.validation.ValidEmail;
import com.nisum.challenge.validation.ValidPassword;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class RegisterUserRequest implements Serializable {
    private String name;

    @ValidEmail
    private String email;

    @ValidPassword
    private String password;

    private List<UserPhone> phones;
}
