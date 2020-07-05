package com.sakeriniwebsite.emusicstore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class CartItem implements Serializable {

    private static final long serialVersionUID = 7816737322951097678L;
    @Id
    @GeneratedValue
    private int cartItemId;

    @ManyToOne
    @JoinColumn(name = "cartId")
    @JsonIgnore
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    private int quantity;
    private double totalPrice;



    /*
    public CartItem(Product product) {
        this.product = product;
        this.quantity = 1;
        this.totalPrice = product.getProductPrice();
    }

     */
}
