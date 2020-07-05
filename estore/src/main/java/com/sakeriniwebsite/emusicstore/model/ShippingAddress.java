package com.sakeriniwebsite.emusicstore.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Data
@Entity
public class ShippingAddress implements Serializable {

    private static final long serialVersionUID = 5511787088066529622L;

    @Id
    @GeneratedValue
    private int shippingAddressId;

    private String streetName;
    private String apartmentNumber;
    private String city;
    private String state;
    private String country;
    private String zipCode;

    @OneToOne
    private Customer customer;

}
