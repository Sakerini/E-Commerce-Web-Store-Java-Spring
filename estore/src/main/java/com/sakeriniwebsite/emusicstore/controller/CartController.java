package com.sakeriniwebsite.emusicstore.controller;

import com.sakeriniwebsite.emusicstore.model.Customer;
import com.sakeriniwebsite.emusicstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/customer/cart")
public class CartController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping
    public String getCart(Principal activeUser) {
        Customer customer = customerService.getCustomerByUsername(activeUser.getName());
        int cartId = customer.getCart().getCartId();

        return "redirect:/customer/cart/" + cartId;
    }

    @RequestMapping("/{cartId}")
    public String getCartRedirect(@PathVariable(name = "cartId") int cartId, Model model) {
        model.addAttribute("cartId", cartId);
        return "cart";
    }
}
