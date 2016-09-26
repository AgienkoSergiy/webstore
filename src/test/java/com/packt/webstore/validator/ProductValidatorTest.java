package com.packt.webstore.validator;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;
import com.packt.webstore.domain.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("test-DispatcherServlet-context.xml")
@WebAppConfiguration
public class ProductValidatorTest {

    @Autowired
    private ProductValidator productValidator;

    @Test
    public void product_without_UnitPrice_should_be_invalid() {
        //Arrange
        Product product = new Product();
        BindException bindException = new BindException(product, " product");

        //Act
        ValidationUtils.invokeValidator(productValidator, product, bindException);

        List errors = bindException.getAllErrors();

        for(Object error: errors){
            System.out.println((ObjectError)error);
        }


        //Assert
        Assert.assertEquals(4, bindException.getErrorCount());

    }

    @Test
    public void product_with_existing_productId_invalid() {
        //Arrange
        Product product = new Product("P1234","iPhone 5s", new BigDecimal(500));
        product.setCategory("Tablet");

        BindException bindException = new BindException(product, " product");

        //Act
        ValidationUtils.invokeValidator(productValidator, product, bindException);

        List errors = bindException.getAllErrors();

        for(Object error: errors){
            System.out.println((ObjectError)error);
        }
        //Assert
        Assert.assertEquals(2, bindException.getErrorCount());
    }

    @Test
    public void a_valid_product_should_not_get_any_error_during_validation() {
        //Arrange
        Product product = new Product("P9876","iPhone 5s", new BigDecimal(500));
        product.setCategory("Tablet");

        BindException bindException = new BindException(product, " product");

        //Act
        ValidationUtils.invokeValidator(productValidator, product, bindException);

        List errors = bindException.getAllErrors();

        for(Object error: errors){
            System.out.println((ObjectError)error);
        }
        //Assert
        Assert.assertEquals(1, bindException.getErrorCount());
    }

}
