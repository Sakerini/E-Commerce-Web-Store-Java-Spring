package com.sakeriniwebsite.emusicstore.controller;

import com.sakeriniwebsite.emusicstore.model.BillingAddress;
import com.sakeriniwebsite.emusicstore.model.Cart;
import com.sakeriniwebsite.emusicstore.model.Customer;
import com.sakeriniwebsite.emusicstore.model.ShippingAddress;
import com.sakeriniwebsite.emusicstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/register")
    public String registerCustomer(Model model) {

        Customer customer = new Customer();
        BillingAddress billingAddress = new BillingAddress();
        ShippingAddress shippingAddress = new ShippingAddress();
        Cart cart = new Cart();

        customer.setBillingAddress(billingAddress);
        customer.setShippingAddress(shippingAddress);
        customer.setCart(cart);

        model.addAttribute("customer", customer);

        return "registerCustomer";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerCustomerPost(@ModelAttribute("customer") Customer customer, Model model) {

        customer.setEnabled(true);
        customerService.addCustomer(customer);

        return "registerCustomerSuccess";
    }
}
