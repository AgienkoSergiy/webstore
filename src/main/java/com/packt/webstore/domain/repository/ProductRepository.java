package com.packt.webstore.domain.repository;

import com.packt.webstore.domain.Product;

import java.util.List;

/**
 * Created by konstr6 on 26.08.2016.
 */
public interface ProductRepository {
    List<Product> getAllProducts();
    Product getProductById(String productID);
}
