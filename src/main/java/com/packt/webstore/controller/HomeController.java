package com.packt.webstore.controller;

import com.packt.webstore.domain.Category;
import com.packt.webstore.domain.Product;
import com.packt.webstore.service.CategoryService;
import com.packt.webstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Controller
public class HomeController {

    private CategoryService categoryService;
    private ProductService productService;

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }


    @RequestMapping("/")
    public String welcome(Model model){

        model.addAttribute("bestsellers", getBestsellers());
        return "home";
    }

    @Cacheable(value = "bestsellersCache") //TODO not works(yet)
    public Map<String,Product> getBestsellers(){
        System.out.println("get bestsellers+++++++++++++++++++++++++++");
        List<Product> products;
        Product product;
        List<Category> categories = categoryService.getAllCategories();
        Map<String,Product> bestsellers=new HashMap<>();
        Random randomizer = new Random(); //TODO temporary random filling bestsellers
        for(Category category:categories){
            products = productService.getProductsByCategory(category.getRestKey());
            product = products.get(randomizer.nextInt(products.size()));
            bestsellers.put(category.getName(),product);
        }
        return bestsellers;
    }

}
