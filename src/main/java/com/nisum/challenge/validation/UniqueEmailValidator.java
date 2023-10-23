package com.nisum.challenge.validation;

import com.nisum.challenge.repository.UserRepository;
import com.nisum.challenge.exception.EmailDuplicateException;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class UniqueEmailValidator implements ConstraintValidator<ValidEmail, String> {
    private final UserRepository userRepository;
    private final String message;

    public UniqueEmailValidator(UserRepository userRepository, String emailUniqueMessage) {
        this.userRepository = userRepository;
        this.message = emailUniqueMessage;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (userRepository.findByEmail(value) != null) {
            throw new EmailDuplicateException(message);
        }
        return true;
    }
}
