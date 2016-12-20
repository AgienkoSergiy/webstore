package com.packt.webstore.service;


import com.packt.webstore.domain.Category;
import com.packt.webstore.domain.Product;

import java.util.List;

public interface CategoryService {

    Category create(Category category);
    Category read(Integer id);
    void update(Category category);
    void delete(Integer id);
    List<Product> getCategoryProducts(Category category);
    List<Category> getAllCategories();
    String getNameByKey(String key);
}
