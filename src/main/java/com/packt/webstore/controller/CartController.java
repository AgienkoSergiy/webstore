package com.packt.webstore.controller;


import javax.servlet.http.HttpServletRequest;

import com.packt.webstore.domain.repository.CartRepository;
import com.packt.webstore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/cart")
public class CartController {

    private CartService cartService;

    @Autowired
    public void setCartRepository(CartService cartService) {
        this.cartService = cartService;
    }

    @RequestMapping
    public String get(HttpServletRequest request) {
        return "redirect:/cart/"+request.getSession(true).getId();
    }

    @RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
    public String getCart(@PathVariable(value = "cartId") String
                                  cartId, Model model) {
        model.addAttribute("cart",cartService.read(cartId)); //TODO this is hotfix, but we`ll make it properly some day, right?
        model.addAttribute("cartId",cartId);
        return "cart";
    }
}