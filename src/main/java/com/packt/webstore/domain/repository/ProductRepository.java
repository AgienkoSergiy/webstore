package com.packt.webstore.domain.repository;

import com.packt.webstore.domain.Product;

import java.util.List;
import java.util.Map;
import java.util.Set;


public interface ProductRepository {
    List<Product> getAllProducts();
    Product getProductById(Integer productID);
    List<Product> getProductsByCategory(String category);
    List<Product> getProductsByFilter(Map<String, List<String>> filterParams);
    List<Product> getProductsByManufacturer(String manufacturer);
    List<Product> getProductsByPriceFilter(Map<String, List<String>> priceRange);
    void addProduct(Product product);
}
