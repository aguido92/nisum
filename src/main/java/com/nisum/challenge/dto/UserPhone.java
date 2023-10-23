package com.nisum.challenge.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserPhone implements Serializable {
    private String number;
    private String cityCode;
    private String countryCode;
}
