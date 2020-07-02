package com.sakeriniwebsite.emusicstore.service;

import com.sakeriniwebsite.emusicstore.model.Cart;

import java.util.Map;

public interface CartService {
    public Cart create(Cart cart);
    public Cart read(String cartId);
    public void update(String cartId, Cart cart);
    public void delete(String cartId);
}
