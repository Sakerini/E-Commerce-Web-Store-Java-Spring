package com.sakeriniwebsite.emusicstore.dao;

import com.sakeriniwebsite.emusicstore.model.Cart;
// I dont use this just in case i forget
public interface CartDAO {
    Cart create(Cart cart);
    Cart read(int cartId);
    void update(int cartId, Cart cart);
    void delete(int cartId);
}
