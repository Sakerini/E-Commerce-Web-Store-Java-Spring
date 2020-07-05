package com.sakeriniwebsite.emusicstore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Entity
public class Cart implements Serializable {

    private static final long serialVersionUID = -3694014779027354584L;

    @Id
    @GeneratedValue
    private int cartId;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CartItem> cartItems;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customerId")
    @JsonIgnore
    private Customer customer;

    private double grandTotal;
}
