package com.packt.webstore.interceptor;

import com.packt.webstore.domain.Customer;
import com.packt.webstore.service.CategoryService;
import com.packt.webstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CommonInfoInterceptor extends HandlerInterceptorAdapter { //adds common information which is used at most pages

    private CategoryService categoryService;

    private CustomerService customerService;


    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
        if (modelAndView != null) {
            modelAndView.getModelMap().
                    addAttribute("categories",
                            categoryService.getAllCategories());
            Customer customer = customerService.getCurrentCustomer();
            if(customer!=null) {
                modelAndView.getModelMap().
                        addAttribute("currentUserName",
                                customer.getName());
            }
        }
    }
}
