package com.sakeriniwebsite.emusicstore.dao;

import com.sakeriniwebsite.emusicstore.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartDAO extends JpaRepository<Cart, Integer> {
    //Free Crud Methods
}
