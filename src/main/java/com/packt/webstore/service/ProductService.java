package com.packt.webstore.service;

import com.packt.webstore.domain.Product;

import java.util.List;
import java.util.Map;
import java.util.Set;


public interface ProductService {
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(String category);
    List<Product> getProductsByFilter(Map<String,
            List<String>> filterParams);
    Product getProductById(Integer productId);
    List<Product> getProductByPriceFilter(Map<String, List<String>> priceRange);
    List<Product> getProductByManufacturer(String manufacturer);
    void addProduct(Product product);
    Map<String,Product> getBestSellers();
}
