package com.packt.webstore.domain.repository;


import com.packt.webstore.domain.Category;
import com.packt.webstore.domain.Product;

import java.util.List;

public interface CategoryRepository {

    Category create(Category category);
    Category read(Integer id);
    void update(Category category);
    void delete(Integer id);
    List<Product> getCategoryProducts(Category category);
    List<Category> getAllCategories();
}
