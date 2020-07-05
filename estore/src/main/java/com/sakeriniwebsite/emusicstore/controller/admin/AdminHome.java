package com.sakeriniwebsite.emusicstore.controller.admin;

import com.sakeriniwebsite.emusicstore.model.Product;
import com.sakeriniwebsite.emusicstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminHome {

    @Autowired
    private ProductService productService;

    @RequestMapping
    public String adminPage() {
        return "admin";
    }

    @RequestMapping("/productInventory")
    public String productInvenotry(Model model) {
        List<Product> products = productService.getAllProduct();
        model.addAttribute("products", products);

        return "productInventory";
    }

    @RequestMapping("/customer")
    public String customerManagement(Model model) {
        //TODO ADD
        return "customerManagement";
    }
}
