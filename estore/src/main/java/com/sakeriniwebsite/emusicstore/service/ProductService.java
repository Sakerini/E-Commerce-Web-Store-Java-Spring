package com.sakeriniwebsite.emusicstore.service;

import com.sakeriniwebsite.emusicstore.model.Product;

import java.util.List;

public interface ProductService {
    public void addProduct(Product product);
    Product getProductById(String id);
    List<Product> getAllProduct();
    void deleteProduct(String id);
}
