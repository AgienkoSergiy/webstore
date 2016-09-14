package com.packt.webstore.validator;


import com.packt.webstore.domain.Product;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProductImageValidator implements Validator {

    long allowedSize = 1024000;

    @Override
    public boolean supports(Class<?> aClass) {
        return Product.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {

        Product product = (Product) target;

        if((product.getProductImage().getSize()>=allowedSize)||
                (product.getProductImage().getSize()==0)) {
            errors.rejectValue("productImage",
                    "com.packt.webstore.validator.ProductImageValidator.message");
        }

    }
}
