package com.sakeriniwebsite.emusicstore.service.impl;

import com.sakeriniwebsite.emusicstore.dao.UserDAO;
import com.sakeriniwebsite.emusicstore.model.User;
import com.sakeriniwebsite.emusicstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public void addUser(User user) {
        userDAO.save(user);
    }

    @Override
    public void deleteUser(int userId) {
        userDAO.deleteById(userId);
    }

    @Override
    public User getUserById(int userId) {
        Optional<User> result = userDAO.findById(userId);
        User user = null;
        if (result.isPresent()) {
            user = result.get();
        } else {
            throw new RuntimeException("NOT FOUND USER ID - " + userId);
        }

        return user;
    }

    @Override
    public List<User> getAllUser() {
        return userDAO.findAll();
    }

    @Override
    public User getUserByUsername(String username) {
        return userDAO.findByUsername(username);
    }
}
