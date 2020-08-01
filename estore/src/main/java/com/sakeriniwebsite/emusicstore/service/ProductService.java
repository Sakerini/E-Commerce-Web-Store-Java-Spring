package com.sakeriniwebsite.emusicstore.service;

import com.sakeriniwebsite.emusicstore.model.Product;

import java.util.List;

public interface ProductService {
    void addProduct(Product product);

    Product getProductById(int id);

    List<Product> getAllProduct();

    void deleteProduct(int id);

    void editProduct(Product product);
}
