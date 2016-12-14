package com.packt.webstore.validator;


import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryValidator implements ConstraintValidator<Category, String> {

    List<String> allowedCategories;

    public CategoryValidator(){
        allowedCategories = new ArrayList<>();
        allowedCategories.add("smart phone");
        allowedCategories.add("laptop");
        allowedCategories.add("tablet");
    }

    public void initialize(Category constraintAnnotation) {

    }
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if(!value.isEmpty())
            return allowedCategories.contains(value.toLowerCase());
        return true;
    }
}
