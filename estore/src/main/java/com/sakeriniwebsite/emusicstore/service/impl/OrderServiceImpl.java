package com.sakeriniwebsite.emusicstore.service.impl;

import com.sakeriniwebsite.emusicstore.dao.OrderDAO;
import com.sakeriniwebsite.emusicstore.model.CustomerOrder;
import com.sakeriniwebsite.emusicstore.service.CartService;
import com.sakeriniwebsite.emusicstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private CartService cartService;

    @Override
    public void addOrder(CustomerOrder order) {
        orderDAO.save(order);
    }

    @Override
    public double getCustomerOrderGrandTotal(int cartId) {
        return cartService.getCartById(cartId).getGrandTotal();
    }
}
