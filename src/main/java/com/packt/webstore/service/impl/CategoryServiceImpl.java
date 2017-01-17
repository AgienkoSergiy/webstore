package com.packt.webstore.service.impl;


import com.packt.webstore.domain.Category;
import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.CategoryRepository;
import com.packt.webstore.service.CategoryService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private static Logger logger = Logger.getLogger("Category_service"); //TODO read about logging

    private CategoryRepository categoryRepository;

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category create(Category category) {

        logger.debug("Adding new category " + category.getName());
        return categoryRepository.create(category);
    }

    @Override
    public Category read(Integer id) {
        logger.debug("Retrieving category with id="+id);
        return categoryRepository.read(id);
    }

    @Override
    public void update(Category category) {
        logger.debug("Updating category "+category.getName());
        categoryRepository.update(category);
    }

    @Override
    public void delete(Integer id) {
        logger.debug("Deleting category with id="+id);
        categoryRepository.delete(id);
    }

    @Override
    public List<Product> getCategoryProducts(Category category) {
        logger.debug("Retrieving products with category="+category.getName());
        return categoryRepository.getCategoryProducts(category);
    }

    @Override
    public List<Category> getAllCategories() {
        logger.debug("Retrieving all categories");
        return categoryRepository.getAllCategories();
    }

    @Override
    public String getNameByKey(String key) {
        logger.debug("Retrieving category name");
        return categoryRepository.getNameByKey(key);
    }
}
