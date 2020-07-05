package com.sakeriniwebsite.emusicstore.dao;

import com.sakeriniwebsite.emusicstore.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDAO extends JpaRepository<Customer, Integer> {
    // CRUD METHODS FREE
    Customer findByUsername(String username);
}
