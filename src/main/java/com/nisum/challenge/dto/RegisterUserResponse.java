package com.nisum.challenge.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
public class RegisterUserResponse implements Serializable {
    private UUID id;
    private String name;
    private String email;
    private String password;
    private List<UserPhone> phones;
    private Date created;
    private Date modified;
    private Date lastLogin;
    private UUID token;
    private boolean isActive;
}
