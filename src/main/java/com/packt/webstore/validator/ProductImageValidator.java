package com.packt.webstore.validator;


import com.packt.webstore.domain.Product;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProductImageValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Product.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        long allowedSize = 1024000;
        Product product = (Product) target;

        if(product.getProductImage().getSize()>allowedSize||product.getProductImage()==null) {
            errors.rejectValue("productImage",
                    "com.packt.webstore.validator.ProductImageValidator.message");
        }

    }
}
