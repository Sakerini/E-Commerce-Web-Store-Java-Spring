package com.sakeriniwebsite.emusicstore.model;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Cart {
    private String cartId;
    private Map<String, CartItem> cartItems;
    private double grandTotal;

    public Cart() {
        cartItems = new HashMap<String, CartItem>();
        grandTotal = 0;
    }
    public Cart(String cartId, Map<String, CartItem> cartItems, double grandTotal) {
        this.cartId = cartId;
        this.cartItems = cartItems;
        this.grandTotal = grandTotal;
    }

    public Cart(String cartId) {
        this();
        this.cartId = cartId;
    }

    public void addCartItem(CartItem item) {
        int productId = item.getProduct().getProductId();

        if(cartItems.containsKey(Integer.toString(productId))) {
            CartItem existingCartItem = cartItems.get(Integer.toString(productId));
            existingCartItem.setQuantity(existingCartItem.getQuantity() + item.getQuantity());
            existingCartItem.setTotalPrice(existingCartItem.getTotalPrice() + item.getTotalPrice());
            cartItems.put(Integer.toString(productId), existingCartItem);
        } else {
            cartItems.put(Integer.toString(productId), item);
        }

        updateGrandTotal();
    }

    public void removeCartItem(CartItem item) {
        int productId = item.getProduct().getProductId();
        cartItems.remove(Integer.toString(productId));
        updateGrandTotal();
    }

    public void updateGrandTotal() {
        grandTotal = 0;
        for (CartItem item : cartItems.values()) {
            grandTotal = grandTotal + item.getTotalPrice();
        }
    }
}
