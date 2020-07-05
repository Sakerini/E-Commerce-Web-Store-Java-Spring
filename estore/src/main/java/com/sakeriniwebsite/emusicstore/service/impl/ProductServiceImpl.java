package com.sakeriniwebsite.emusicstore.service.impl;

import com.sakeriniwebsite.emusicstore.dao.ProductDAO;
import com.sakeriniwebsite.emusicstore.model.Product;
import com.sakeriniwebsite.emusicstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDAO productDAO;

    @Override
    public void addProduct(Product product) {
        productDAO.save(product);
    }

    @Override
    public Product getProductById(int id) {
        Optional<Product> result = productDAO.findById(id);
        Product product = null;
        if (result.isPresent()) {
            product = result.get();
        } else {
            throw new RuntimeException("NOT FOUND PRODUCT ID - " + id);
        }

        return product;
    }

    @Override
    public List<Product> getAllProduct() {
        return productDAO.findAll();
    }

    @Override
    public void deleteProduct(int id) {
        productDAO.deleteById(id);
    }

    @Override
    public void editProduct(Product product) {
        productDAO.save(product);
    }


}
