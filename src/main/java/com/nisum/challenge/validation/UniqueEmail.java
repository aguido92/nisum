package com.nisum.challenge.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = UniqueEmailValidator.class)
@Target(FIELD)
@Retention(RUNTIME)
public @interface UniqueEmail {
    String message() default "This email is in use";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
