package com.sakeriniwebsite.emusicstore.service.impl;

import com.sakeriniwebsite.emusicstore.dao.CartDAO;
import com.sakeriniwebsite.emusicstore.model.Cart;
import com.sakeriniwebsite.emusicstore.service.CartService;
import com.sakeriniwebsite.emusicstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

import java.util.Optional;

@Service(value = "cartService")
public class CartServiceImpl implements CartService {
    @Autowired
    private CartDAO cartDAO;

    @Autowired
    OrderService orderService;
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
        int cartId = cart.getCartId();
        double grandTotal = orderService.getCustomerOrderGrandTotal(cartId);
        cart.setGrandTotal(grandTotal);
        cartDAO.save(cart);
    }

    @Override
    public Cart validate(int cartId) throws IOException {
        Optional<Cart> result = cartDAO.findById(cartId);
        Cart cart = null;
        if (result.isPresent()) {
            cart = result.get();
        } else {
            throw new RuntimeException("NOT FOUND CART ID - " + cartId);
        }

        update(cart);
        return cart;
    }
}
