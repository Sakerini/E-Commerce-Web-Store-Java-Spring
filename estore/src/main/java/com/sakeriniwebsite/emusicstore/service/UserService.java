package com.sakeriniwebsite.emusicstore.service;


import com.sakeriniwebsite.emusicstore.model.User;

import java.util.List;

public interface UserService {
    public void addUser(User user);

    public void deleteUser(int userId);

    public User getUserById(int userId);

    public List<User> getAllUser();

    public User getUserByUsername(String username);
}
