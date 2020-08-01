package com.sakeriniwebsite.emusicstore.service;

import com.sakeriniwebsite.emusicstore.model.Cart;
import org.springframework.stereotype.Service;

import java.io.IOException;

public interface CartService {
    Cart getCartById(int cartId);

    void update(Cart cart);

    Cart createCart();

    Cart validate(int cartId) throws IOException;
}
