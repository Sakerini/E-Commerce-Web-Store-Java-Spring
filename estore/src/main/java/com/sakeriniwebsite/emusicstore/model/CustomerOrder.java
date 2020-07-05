package com.sakeriniwebsite.emusicstore.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class CustomerOrder implements Serializable {

    private static final long serialVersionUID = 6298925393071823687L;

    @Id
    @GeneratedValue
    private int customerOrderId;

    @OneToOne
    @JoinColumn(name = "cartId")
    private Cart car;

    @OneToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "billingAddressId")
    private BillingAddress billingAddress;


    @OneToOne
    @JoinColumn(name = "shippingAddressId")
    private ShippingAddress shippingAddress;

}
