package com.sakeriniwebsite.emusicstore.service;

import com.sakeriniwebsite.emusicstore.dao.CartDAO;
import com.sakeriniwebsite.emusicstore.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Hashtable;
import java.util.Map;

@Service
public class CartServiceImpl implements CartService {

    private Map<String, Cart> listOfCarts;

    public CartServiceImpl() {
        listOfCarts = new Hashtable<String, Cart>();
    }

    @Override
    public Cart create(Cart cart) {
        if (listOfCarts.keySet().contains(cart.getCartId())) {
            throw new IllegalArgumentException(String.format("Cannot create a cart. A cart with the given id(%)"+
                    " already" + " exists",cart.getCartId()));
        }

        listOfCarts.put(cart.getCartId(),cart);

        return cart;
    }

    @Override
    public Cart read(String cartId) {
        return listOfCarts.get(cartId);
    }

    @Override
    public void update(String cartId, Cart cart) {
        if (!listOfCarts.keySet().contains(cartId)) {
            throw new IllegalArgumentException(String.format("Cannot update a cart. A cart with the given id(%)"+
                    " does not" + " exists",cart.getCartId()));
        }

        listOfCarts.put(cartId, cart);
    }

    @Override
    public void delete(String cartId) {
        if (!listOfCarts.keySet().contains(cartId)) {
            throw new IllegalArgumentException(String.format("Cannot delete a cart. A cart with the given id(%)" +
                    " does not" + " exists", cartId));
        }
        listOfCarts.remove(cartId);
    }
}
