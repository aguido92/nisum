package com.nisum.challenge.validation;

import com.nisum.challenge.exception.RegexpPatternNotValidException;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailRegexpPatternValidator implements ConstraintValidator<ValidEmail, String> {
    private final String message;
    private final String regexp;

    public EmailRegexpPatternValidator(String emailFormatMessage, String emailRegexp) {
        this.message = emailFormatMessage;
        this.regexp = emailRegexp;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(!value.matches(regexp)) {
            throw new RegexpPatternNotValidException(message);
        }
        return true;
    }
}
