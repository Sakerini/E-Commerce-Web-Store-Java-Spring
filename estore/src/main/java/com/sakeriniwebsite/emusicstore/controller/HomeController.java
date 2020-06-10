package com.sakeriniwebsite.emusicstore.controller;

import com.sakeriniwebsite.emusicstore.dao.ProductDAO;
import com.sakeriniwebsite.emusicstore.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

@Controller
public class HomeController {

    private ProductDAO productDAO = new ProductDAO();

    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    @RequestMapping("/productlist")
    public String getProducts(Model model) {
        List<Product> products = productDAO.getProductList();
        model.addAttribute("products", products);

        return "productList";
    }

    @RequestMapping("/productlist/viewproduct/{productId}")
    public String viewProduct(@PathVariable String productId, Model model) throws IOException {
        Product product = productDAO.getProductById(productId);
        model.addAttribute(product);
        return "viewProduct";
    }
}
