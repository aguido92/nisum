package com.nisum.challenge.exception;

import jakarta.validation.ValidationException;

public class EmailDuplicateException extends ValidationException {
    public EmailDuplicateException(String message) {
        super(message);
    }
}
