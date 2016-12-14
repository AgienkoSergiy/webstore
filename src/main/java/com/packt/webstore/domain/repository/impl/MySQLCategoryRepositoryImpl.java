package com.packt.webstore.domain.repository.impl;


import com.packt.webstore.domain.Category;
import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.CategoryRepository;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class MySQLCategoryRepositoryImpl implements CategoryRepository {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public Category create(Category category) {
        Session session = sessionFactory.getCurrentSession();
        session.save(category);
        return category;
    }

    @Override
    public Category read(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return (Category)session.get(Category.class,id);
    }

    @Override
    public void update(Category category) {
        Category existingCategory = read(category.getId());
        Session session = sessionFactory.getCurrentSession();
        existingCategory.setName(category.getName());
        session.save(existingCategory);
    }

    @Override
    public void delete(Integer id) {
        Category category = read(id);
        Session session = sessionFactory.getCurrentSession();
        session.delete(category);
    }

    @Override
    public List<Product> getCategoryProducts(Category category) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Product where category = :categoryName");
        query.setParameter("categoryName", category.getName());
        List<Product> queryList = query.list();
        if (query.list().isEmpty()){
            return null;
        }
        return queryList;
    }

    @Override
    public List<Category> getAllCategories() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Category");
        return query.list();
    }
}
