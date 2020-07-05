package com.sakeriniwebsite.emusicstore.controller.admin;

import com.sakeriniwebsite.emusicstore.model.Product;
import com.sakeriniwebsite.emusicstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/admin")
public class AdminProduct {

    @Autowired
    private ProductService productService;

    private Path path;

    @RequestMapping("/product/addProduct")
    public String addProduct(Model model) {
        Product product = new Product();

        product.setProductCategory("Instrument");
        product.setProductCondition("new");
        product.setProductStatus("active");

        model.addAttribute("product", product);

        return "addProduct";
    }

    @RequestMapping(value = "/product/addProduct", method = RequestMethod.POST)
    public String addProductPost(@Valid @ModelAttribute("product") Product product, BindingResult result,
                                 HttpServletRequest request) {
        if (result.hasErrors()) {
            return "addProduct";
        }

        productService.addProduct(product);

        MultipartFile productImage = product.getProductImage();

        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "/resources/static/images/" + product.getProductId() + ".png");

        if (productImage != null && !productImage.isEmpty()) {
            try {
                productImage.transferTo(new File(path.toString()));
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Product Image saving failed", e);
            }
        }
        return "redirect:/admin/productInventory";
    }

    @RequestMapping("/product/editProduct/{id}")
    public String editProduct(@PathVariable("id") int id, Model model) {
        Product product = productService.getProductById(id);

        model.addAttribute("product", product);

        return "editProduct";
    }

    @RequestMapping(value = "/product/editProduct", method = RequestMethod.POST)
    public String editProductPost(@Valid @ModelAttribute("product") Product product, BindingResult result,
                                 HttpServletRequest request) {
        if (result.hasErrors()) {
            return "editProduct";
        }

        MultipartFile productImage = product.getProductImage();

        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "/resources/static/images/" + product.getProductId() + ".png");

        if (productImage != null && !productImage.isEmpty()) {
            try {
                productImage.transferTo(new File(path.toString()));
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Product Image saving failed", e);
            }
        }

        productService.editProduct(product);
        return "redirect:/admin/productInventory";
    }

    @RequestMapping("/product/deleteProduct/{id}")
    public String deleteProduct(@PathVariable(name = "id") int id, Model model, HttpServletRequest request) {
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "/resources/static/images/" + id + ".png");

        if (Files.exists(path)) {
            try {
                Files.delete(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        productService.deleteProduct(id);
        return "redirect:/admin/productInventory";
    }
}
