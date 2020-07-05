package com.sakeriniwebsite.emusicstore.service.impl;

import com.sakeriniwebsite.emusicstore.dao.CartDAO;
import com.sakeriniwebsite.emusicstore.dao.CartItemDAO;
import com.sakeriniwebsite.emusicstore.model.Cart;
import com.sakeriniwebsite.emusicstore.model.CartItem;
import com.sakeriniwebsite.emusicstore.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemServiceImpl implements CartItemService {
    @Autowired
    private CartItemDAO cartItemDao;


    @Override
    public void addCartItem(CartItem cartItem) {
        cartItemDao.save(cartItem);
    }

    @Override
    public void removeCartItem(CartItem cartItem) {
        cartItemDao.delete(cartItem);
    }

    @Override
    public void removeAllCartItems(Cart cart) {
        List<CartItem> cartItems = cart.getCartItems();
        for (CartItem cartItem: cartItems) {
            cartItemDao.delete(cartItem);
        }
    }

    @Override
    public CartItem getCartItemByProductId(int productId) {
        return cartItemDao.findByProductProductId(productId);
    }
}
