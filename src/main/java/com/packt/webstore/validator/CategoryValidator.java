package com.packt.webstore.validator;


import com.packt.webstore.domain.Category;
import com.packt.webstore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryValidator implements ConstraintValidator<CategoryValidated, Category> {

    @Autowired
    private CategoryService categoryService;

    private List<String> allowedCategories;

    public CategoryValidator() {
        allowedCategories=new ArrayList<>();
    }

    @PostConstruct
    private void init(){
        List<Category> categories = categoryService.getAllCategories();
        for(Category category: categories){
            allowedCategories.add(category.getName().toLowerCase());
        }
    }

    @Override
    public void initialize(CategoryValidated constraintAnnotation) {

    }
    @Override
    public boolean isValid(Category value, ConstraintValidatorContext context) {

        return value==null || allowedCategories.contains(value.getName().toLowerCase());
    }

}
