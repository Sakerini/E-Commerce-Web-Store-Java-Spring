package com.sakeriniwebsite.emusicstore.service.impl;

import com.sakeriniwebsite.emusicstore.dao.CartDAO;
import com.sakeriniwebsite.emusicstore.model.Cart;
import com.sakeriniwebsite.emusicstore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Hashtable;
import java.util.Map;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartDAO cartDAO;

    @Override
    public Cart getCartById(int cartId) {
        Optional<Cart> result = cartDAO.findById(cartId);
        Cart cart = null;
        if (result.isPresent()) {
            cart = result.get();
        } else {
            throw new RuntimeException("NOT FOUND CART ID - " + cartId);
        }

        return cart;
    }

    @Override
    public void update(Cart cart) {
        cartDAO.save(cart);
    }
}
