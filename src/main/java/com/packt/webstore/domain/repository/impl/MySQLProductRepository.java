package com.packt.webstore.domain.repository.impl;


import com.packt.webstore.domain.Category;
import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.cache.annotation.Cacheable;
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
    public List<Product> getProductsByCategory(String restKey) {

        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("from Product where category.restKey = :productType");
        query.setParameter("productType", restKey);

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

        return (Product) session.get(Product.class,Id);
    }

    @Override
    public void addProduct(Product product) {

        Session session = sessionFactory.getCurrentSession();
        session.save(product);
    }

    @Cacheable(value = "bestsellersCache")
    @Override
    public Map<String, Product> getBestSellers() {

        System.out.println("get bestsellers+++++++++++++++++++++++++++");
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Category");
        List<Category> categories = query.list();

        List<Product> products;
        Product product;
        Map<String,Product> bestsellers=new HashMap<>();
        Random randomizer = new Random(); //TODO temporary random filling bestsellers

        for(Category category:categories){
            products = getProductsByCategory(category.getRestKey());
            product = products.get(randomizer.nextInt(products.size()));
            bestsellers.put(category.getName(),product);
        }
        return bestsellers;
    }
}
