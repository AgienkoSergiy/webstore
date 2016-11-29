package com.packt.webstore.domain.repository.impl;

import java.math.BigDecimal;
import java.util.*;

import com.packt.webstore.exception.ProductNotFoundException;
import com.packt.webstore.domain.Product;

@Deprecated
public class InMemoryProductRepository {

    private List<Product> listOfProducts = new ArrayList<>();

    public InMemoryProductRepository() {
        Product iphone = new Product(1,"iPhone 5s", new
                BigDecimal(500));
        iphone.setDescription("Apple iPhone 5s smartphone with 4.00-inch" +
                " 640x1136 display and 8-megapixel rear camera");
        iphone.setCategory("Smart Phone");
        iphone.setManufacturer("Apple");
        iphone.setUnitsInStock(1000);

        Product laptop_dell = new Product(2,"Dell Inspiron", new
                BigDecimal(700));
        laptop_dell.setDescription("Dell Inspiron 14-inch Laptop(Black)" +
                " with 3rd Generation Intel Core processors");
        laptop_dell.setCategory("Laptop");
        laptop_dell.setManufacturer("Dell");
        laptop_dell.setUnitsInStock(1000);

        Product tablet_Nexus = new Product(3,"Nexus 7", new
                BigDecimal(300));
        tablet_Nexus.setDescription("Google Nexus 7 is the lightest 7 inch" +
                " tablet With a quad-core Qualcomm Snapdragon™ S4 Pro processor");
        tablet_Nexus.setCategory("Tablet");
        tablet_Nexus.setManufacturer("Google");
        tablet_Nexus.setUnitsInStock(1000);

        listOfProducts.add(iphone);
        listOfProducts.add(laptop_dell);
        listOfProducts.add(tablet_Nexus);
    }


    public List<Product> getAllProducts() {
        return listOfProducts;
    }


    public List<Product> getProductsByCategory(String category) {
        List<Product> productsByCategory = new ArrayList<>();

        for (Product product :
                listOfProducts) {
            if (category.equalsIgnoreCase(product.getCategory())){
                productsByCategory.add(product);
            }
        }
        return productsByCategory;
    }

    public List<Product> getProductsByPriceFilter(Map<String, List<String>> priceRange) {
        Set<Product> productSet = new HashSet<>();

        ArrayList productsByPriceFilter = new ArrayList();
        BigDecimal lowPrice = new BigDecimal(priceRange.get("low").get(0));
        BigDecimal highPrice = new BigDecimal(priceRange.get("high").get(0));

        for (Product product :
                listOfProducts) {
            if(product.getUnitPrice().compareTo(lowPrice)>=0&&
                    product.getUnitPrice().compareTo(highPrice)<=0){
                productSet.add(product);
            }
        }
        productsByPriceFilter.addAll(productSet);
        return productsByPriceFilter;
    }

    public Product getProductById(Integer productId) {
        Product productById = null;

        for(Product product : listOfProducts) {
            if(product!=null && product.getProductId()!=null && product.
                    getProductId().equals(productId)){
                productById = product;
                break;
            }
        }

        if(productById == null){
            throw new ProductNotFoundException(productId);
        }

        return productById;
    }

    public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
        Set<Product> productsByBrand = new HashSet<>();
        Set<Product> productsByCategory = new HashSet<>();
        
        Set<String> criterias = filterParams.keySet();
        
        if(criterias.contains("brand")){
            for (String brandName: filterParams.get("brand")) {
                for (Product product :
                        listOfProducts) {
                    if (brandName.equalsIgnoreCase(product.getManufacturer())){
                        productsByBrand.add(product);
                    }
                }
            }
        }
        
        if(criterias.contains("category")){
            for (String category :
                    filterParams.get("category")) {
                productsByCategory.addAll(this.getProductsByCategory(category));
            }
        }
        productsByCategory.retainAll(productsByBrand);

        return productsByCategory;
    }

    public Set<Product> getProductsByManufacturer(String manufacturer) {
        Set<Product> productsByManufacturer = new HashSet<>();

        for (Product product :
                listOfProducts) {
            if (manufacturer.equalsIgnoreCase(product.getManufacturer())){
                productsByManufacturer.add(product);
            }
        }
        return productsByManufacturer;
    }

    public void addProduct(Product product) {
        listOfProducts.add(product);
    }
}