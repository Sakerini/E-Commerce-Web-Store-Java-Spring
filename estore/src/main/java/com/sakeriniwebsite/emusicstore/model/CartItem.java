package com.sakeriniwebsite.emusicstore.model;

import lombok.Data;

@Data
public class CartItem {
    private Product product;
    private int qunatity;
    private double totalPrica;

    public CartItem(Product product) {
        this.product = product;
        this.qunatity = 1;
        this.totalPrica = product.getProductPrice();
    }
}
