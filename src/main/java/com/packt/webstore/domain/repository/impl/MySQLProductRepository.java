package com.packt.webstore.domain.repository.impl;


import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

@Repository
public class MySQLProductRepository implements ProductRepository {


    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public List<Product> getAllProducts() {

        Session session = sessionFactory.getCurrentSession();


        Query query = session.createQuery("FROM Product");
        return query.list();
    }

    @Override
    public List<Product> getProductsByCategory(String productCategory) {

        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("from Product where category.restKey = :productType");
        query.setParameter("productType",productCategory);

        return query.list();
    }

    @Override
    public List<Product> getProductsByFilter(Map<String, List<String>> filterParams) { // TODO come to query solution

        Set<String> criteria = filterParams.keySet();
        Set<Product> productsByBrand;
        Set<Product> productsByCategory;
        Set<Product> productsByPrice;
        List<Product> products = new ArrayList<>(getAllProducts());

        if(criteria.contains("brand")){
            productsByBrand = new HashSet<>();
            for(String brandName: filterParams.get("brand")){
                productsByBrand.addAll(getProductsByManufacturer(brandName));
            }
            products.retainAll(productsByBrand);
        }
        if(criteria.contains("category")){
            productsByCategory = new HashSet<>();
            for(String categoryName:filterParams.get("category")){
                productsByCategory.addAll(getProductsByCategory(categoryName));
            }
            products.retainAll(productsByCategory);
        }
        if(criteria.contains("price")){
            productsByPrice = new HashSet<>(getProductsByPriceFilter(filterParams));
            products.retainAll(productsByPrice);
        }

        return  products;
    }

    @Override
    public List<Product> getProductsByManufacturer(String productManufacturer) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("from Product where manufacturer = :brand");
        query.setParameter("brand",productManufacturer);

        return query.list();
    }

    @Override
    public List<Product> getProductsByPriceFilter(Map<String, List<String>> priceRange) {

        BigDecimal lowPrice;
        BigDecimal topPrice;
        if(priceRange.containsKey("low")){
            lowPrice = new BigDecimal(priceRange.get("low").get(0));
        }
        else{
            lowPrice = new BigDecimal(0);
        }
        if(priceRange.containsKey("high")){
            topPrice = new BigDecimal(priceRange.get("high").get(0));
        }
        else{
            topPrice = new BigDecimal(Integer.MAX_VALUE);
        }

        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("from Product where unitPrice>= :low and" +
                " unitPrice<= :top");
        query.setParameter("low",lowPrice);
        query.setParameter("top",topPrice);
        

        return query.list();
    }

    @Override
    public Product getProductById(Integer Id){

        Session session = sessionFactory.getCurrentSession();
        Product product = (Product) session.load(Product.class,Id);
        Hibernate.initialize(product);
        return product;
    }

    @Override
    public void addProduct(Product product) {

        Session session = sessionFactory.getCurrentSession();
        session.save(product);
    }

}
