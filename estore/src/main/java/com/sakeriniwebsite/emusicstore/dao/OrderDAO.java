package com.sakeriniwebsite.emusicstore.dao;

import com.sakeriniwebsite.emusicstore.model.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDAO  extends JpaRepository<CustomerOrder, Integer> {
    //FREE CRUD
}
