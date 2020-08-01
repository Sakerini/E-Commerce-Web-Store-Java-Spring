package com.sakeriniwebsite.emusicstore.service;

import com.sakeriniwebsite.emusicstore.model.Customer;

import java.util.List;

public interface CustomerService {
    public void addCustomer(Customer customer);

    Customer getCustomer(int customerId);

    List<Customer> getAllCustomers();

    Customer getCustomerByUsername(String username);
}
