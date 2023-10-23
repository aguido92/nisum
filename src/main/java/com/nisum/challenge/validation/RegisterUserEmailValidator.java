package com.nisum.challenge.validation;

import com.nisum.challenge.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RegisterUserEmailValidator implements ConstraintValidator<ValidEmail, String> {
    @Autowired
    UserRepository userRepository;
    private List<ConstraintValidator<ValidEmail, String>> validators;

    @Value("${user.email.format.message}")
    private String emailFormatMessage;
    @Value("${user.email.regexp}")
    private String emailRegexp;

    @Value("${user.email.unique.message}")
    private String emailUniqueMessage;

    @Override
    public void initialize(ValidEmail constraintAnnotation) {
        validators = new ArrayList<>();
        validators.add(new EmailRegexpPatternValidator(emailFormatMessage, emailRegexp));
        validators.add(new UniqueEmailValidator(userRepository, emailUniqueMessage));
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean isValid = true;
        for (ConstraintValidator<ValidEmail, String> validator : validators) {
            isValid &= validator.isValid(value, context);
        }
        return isValid;
    }
}

