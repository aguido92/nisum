package com.nisum.challenge.exception;

import jakarta.validation.ValidationException;

public class RegexpPatternNotValidException extends ValidationException {
    public RegexpPatternNotValidException(String message) {
        super(message);
    }
}
