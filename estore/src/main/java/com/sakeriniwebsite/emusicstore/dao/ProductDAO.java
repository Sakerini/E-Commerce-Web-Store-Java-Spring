package com.sakeriniwebsite.emusicstore.dao;

import com.sakeriniwebsite.emusicstore.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDAO extends JpaRepository<Product, String> {
    //CRUD METHODS FOR FREE
}
