package com.fifi.tfmanager.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String> {

    private Pattern pattern = Pattern.compile(".*[A-Z]+.*");
    private Matcher matcher;

    @Override
    public void initialize(ValidPassword constraintAnnotation) {
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        matcher = pattern.matcher(password);
        if ( password.length() <= 5 || !matcher.matches() ) {
            return false;
        }
        return true;
    }
}
