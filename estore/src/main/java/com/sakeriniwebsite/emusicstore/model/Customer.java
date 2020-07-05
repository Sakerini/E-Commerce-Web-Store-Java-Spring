package com.sakeriniwebsite.emusicstore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@Entity
public class Customer implements Serializable {

    private static final long serialVersionUID = -3710918128695872526L;

    @Id
    @GeneratedValue
    private int customerId;

    @NotEmpty(message = "Customer name must not be null!!!")
    private String customerName;

    @NotEmpty(message = "Customer's email must not be null!!!")
    private String customerEmail;

    private String customerPhone;

    @NotEmpty(message = "Customer username must not be null !!!")
    private String username;

    @NotEmpty(message = "Customer password must not be null !!!")
    private String password;

    private boolean enabled;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "billingAddressId")
    private BillingAddress billingAddress;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shippingAddressId")
    private ShippingAddress shippingAddress;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cartId")
    @JsonIgnore
    private Cart cart;
}
