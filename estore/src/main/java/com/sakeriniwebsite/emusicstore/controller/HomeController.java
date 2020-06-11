package com.sakeriniwebsite.emusicstore.controller;

import com.sakeriniwebsite.emusicstore.dao.ProductDAO;
import com.sakeriniwebsite.emusicstore.model.Product;
import com.sakeriniwebsite.emusicstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    @RequestMapping("/productlist")
    public String getProducts(Model model) {
        List<Product> products = productService.getAllProduct();
        model.addAttribute("products", products);

        return "productList";
    }

    @RequestMapping("/productlist/viewproduct/{productId}")
    public String viewProduct(@PathVariable String productId, Model model) throws IOException {
        Product product = productService.getProductById(productId);
        model.addAttribute(product);
        return "viewProduct";
    }
}
