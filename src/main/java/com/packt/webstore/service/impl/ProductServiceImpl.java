package com.packt.webstore.service.impl;

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;
import com.packt.webstore.service.ProductService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

    protected static Logger logger = Logger.getLogger("Product_service");

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {

        logger.debug("Retrieving all products");
        return productRepository.getAllProducts();
    }

    @Override
    public List<Product> getProductsByCategory(String productCategory) {

        logger.debug("Retrieving products by category");
        return productRepository.getProductsByCategory(productCategory);
    }

    @Override
    public List<Product> getProductsByFilter(Map<String, List<String>> filterParams) {

        logger.debug("Retrieving products by filter");
        return productRepository.getProductsByFilter(filterParams);
    }

    @Override
    public Product getProductById(Integer Id){

        logger.debug("Retrieving product by id");
        return productRepository.getProductById(Id);
    }

    @Override
    public List<Product> getProductByManufacturer(String productManufacturer) {

        logger.debug("Retrieving products by manufacturer");
        return productRepository.getProductsByManufacturer(productManufacturer);
    }

    @Override
    public List<Product> getProductByPriceFilter(Map<String, List<String>> priceRange) {

        logger.debug("Retrieving products by price range");
        return productRepository.getProductsByPriceFilter(priceRange);
    }

    @Override
    public void addProduct(Product product) {

        logger.debug("Adding new product");
        productRepository.addProduct(product);
    }
}
