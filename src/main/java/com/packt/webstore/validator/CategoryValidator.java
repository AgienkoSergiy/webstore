package com.packt.webstore.validator;


import com.packt.webstore.domain.Category;
import com.packt.webstore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryValidator implements ConstraintValidator<CategoryValidated, String> {

    private CategoryService categoryService;

    private List<String> allowedCategories;

    @Autowired
    public void setProductService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public void initialize(CategoryValidated constraintAnnotation) {
        List<Category> categories = categoryService.getAllCategories();
        allowedCategories=new ArrayList<>();
        for(Category category: categories){
            allowedCategories.add(category.getName().toLowerCase());
        }
    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        return value.isEmpty() || allowedCategories.contains(value.toLowerCase());
    }
}
