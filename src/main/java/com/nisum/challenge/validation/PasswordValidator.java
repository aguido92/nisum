package com.nisum.challenge.validation;

import com.nisum.challenge.exception.RegexpPatternNotValidException;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Value;

public class PasswordValidator implements ConstraintValidator<ValidPassword, String> {
    @Value("${user.password.format.message}")
    private String message;
    @Value("${user.password.format.regexp}")
    private String regexp;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(!value.matches(regexp)) {
            throw new RegexpPatternNotValidException(message);
        }
        return true;
    }
}
