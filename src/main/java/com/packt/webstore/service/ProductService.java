package com.packt.webstore.service;

import com.packt.webstore.domain.Product;

import java.util.List;
import java.util.Map;
import java.util.Set;


public interface ProductService {
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(String category);
    Set<Product> getProductsByFilter(Map<String,
            List<String>> filterParams);
    Product getProductById(String productId);
    Set<Product> getProductByPriceFilter(Map<String, List<String>> priceRange);
    Set<Product> getProductByManufacturer(String manufacturer);
    void addProduct(Product product);
}
