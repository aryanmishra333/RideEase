package com.rideease.service;

import com.rideease.model.User;
import java.util.List;

public interface UserService {
    User registerUser(User user);
    User updateUser(User user);
    void deleteUser(Long userId);
    User getUserById(Long userId);
    User getUserByEmail(String email);
    List<User> getAllUsers();
    User authenticateUser(String email, String password);
} 