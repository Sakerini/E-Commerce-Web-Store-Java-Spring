package com.sakeriniwebsite.emusicstore.service;

import com.sakeriniwebsite.emusicstore.model.Cart;
import com.sakeriniwebsite.emusicstore.model.CartItem;

public interface CartItemService {
    void addCartItem(CartItem cartItem);
    void removeCartItem(CartItem cartItem);
    void removeAllCartItems(Cart cart);
    CartItem getCartItemByProductId(int productId);
}
