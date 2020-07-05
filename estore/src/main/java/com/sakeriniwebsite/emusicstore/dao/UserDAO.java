package com.sakeriniwebsite.emusicstore.dao;

import com.sakeriniwebsite.emusicstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Integer> {

    //CRUD METHODS FOR FREE
    User findByUsername(String username);
}
