package com.packt.webstore.validator;


import com.packt.webstore.domain.Customer;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(final PasswordMatches constraintAnnotation) {
        //
    }

    @Override
    public boolean isValid(final Object obj, final ConstraintValidatorContext context) {
        final Customer user = (Customer) obj;
        return user.getPassword().equals(user.getMatchingPassword());
    }

}
