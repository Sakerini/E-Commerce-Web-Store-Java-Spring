package com.sakeriniwebsite.emusicstore.service;

import com.sakeriniwebsite.emusicstore.model.CustomerOrder;

public interface OrderService {

    void addOrder(CustomerOrder order);

    double getCustomerOrderGrandTotal(int cartId);
}
