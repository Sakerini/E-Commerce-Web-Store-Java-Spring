package com.sakeriniwebsite.emusicstore.service.impl;

import com.sakeriniwebsite.emusicstore.dao.CustomerDAO;
import com.sakeriniwebsite.emusicstore.model.*;
import com.sakeriniwebsite.emusicstore.service.AuthorityService;
import com.sakeriniwebsite.emusicstore.service.CartService;
import com.sakeriniwebsite.emusicstore.service.CustomerService;
import com.sakeriniwebsite.emusicstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;
    @Autowired
    private UserService userService;
    @Autowired
    private AuthorityService authorityService;
    @Autowired
    private CartService cartService;

    @Override
    public void addCustomer(Customer customer) {

        User user = new User();
        user.setEnabled(true);
        user.setUsername(customer.getUsername());
        user.setPassword(customer.getPassword());
        user.setCustomerId(customer.getCustomerId());
        userService.addUser(user);

        Authorities authority = new Authorities();
        authority.setUsername(customer.getUsername());
        authority.setAuthority("ROLE_USER");
        authorityService.addAuthority(authority);

        Cart cart = new Cart();
        cart.setCustomer(customer);
        customer.setCart(cart);

        cartService.update(cart);

        //cartService.create(cart); // :|

        customerDAO.save(customer);

    }

    @Override
    public Customer getCustomer(int customerId) {
        Optional<Customer> result = customerDAO.findById(customerId);
        Customer customer = null;
        if (result.isPresent()) {
            customer = result.get();
        } else {
            throw new RuntimeException("NOT FOUND CUSTOMER ID - " + customerId);
        }

        return customer;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerDAO.findAll();
    }

    @Override
    public Customer getCustomerByUsername(String username) {
        return customerDAO.findByUsername(username);
    }
}
