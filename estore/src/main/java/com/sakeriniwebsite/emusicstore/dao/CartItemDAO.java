package com.sakeriniwebsite.emusicstore.dao;

import com.sakeriniwebsite.emusicstore.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemDAO extends JpaRepository<CartItem, Integer> {
    //CRUD FREE
    CartItem findByProductProductId(int productId);
}
