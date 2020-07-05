package com.sakeriniwebsite.emusicstore.service;

import com.sakeriniwebsite.emusicstore.model.Cart;


public interface CartService {
    Cart getCartById(int cartId);
    void update(Cart cart);
}
