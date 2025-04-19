package com.rideease.service.impl;

import com.rideease.model.User;
import com.rideease.model.Driver;
import com.rideease.repository.UserRepository;
import com.rideease.service.UserService;
import com.rideease.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private DriverService driverService;

    @Override
    public User registerUser(User user) {
        // Validate required fields
        if (user.getEmail() == null || user.getEmail().trim().isEmpty()) {
            throw new RuntimeException("Email is required");
        }
        if (user.getPassword() == null || user.getPassword().trim().isEmpty()) {
            throw new RuntimeException("Password is required");
        }
        if (user.getName() == null || user.getName().trim().isEmpty()) {
            throw new RuntimeException("Name is required");
        }
        if (user.getPhoneNumber() == null || user.getPhoneNumber().trim().isEmpty()) {
            throw new RuntimeException("Phone number is required");
        }
        if (user.getUserType() == null) {
            throw new RuntimeException("User type is required");
        }
        
        // Convert userType to uppercase
        try {
            user.setUserType(User.UserType.valueOf(user.getUserType().name().toUpperCase()));
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid user type");
        }
        
        // Validate driver-specific fields if user is a driver
        if (user.getUserType() == User.UserType.DRIVER) {
            if (user.getLicenseNumber() == null || user.getLicenseNumber().trim().isEmpty()) {
                throw new RuntimeException("License number is required for drivers");
            }
            if (user.getVehicleType() == null || user.getVehicleType().trim().isEmpty()) {
                throw new RuntimeException("Vehicle type is required for drivers");
            }
            if (user.getVehicleNumber() == null || user.getVehicleNumber().trim().isEmpty()) {
                throw new RuntimeException("Vehicle number is required for drivers");
            }
        }
        
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Email already registered");
        }
        
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCreatedAt(LocalDateTime.now());
        user.setActive(true);
        
        User savedUser = userRepository.save(user);
        
        // If user is a driver, create a driver record
        if (user.getUserType() == User.UserType.DRIVER) {
            Driver driver = new Driver();
            driver.setUser(savedUser);
            driver.setLicenseNumber(user.getLicenseNumber());
            driver.setVehicleType(user.getVehicleType());
            driver.setVehicleNumber(user.getVehicleNumber());
            driver.setVehicleModel(user.getVehicleModel());
            driver.setYearOfExperience(user.getYearOfExperience());
            driver.setRegistrationDate(LocalDateTime.now());
            driver.setAvailable(true);
            driver.setRating(0.0);
            driverService.saveDriver(driver);
        }
        
        return savedUser;
    }

    @Override
    public User updateUser(User user) {
        User existingUser = userRepository.findById(user.getId())
            .orElseThrow(() -> new RuntimeException("User not found"));
        
        if (!existingUser.getEmail().equals(user.getEmail()) && 
            userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        
        if (!existingUser.getPhoneNumber().equals(user.getPhoneNumber()) && 
            userRepository.existsByPhoneNumber(user.getPhoneNumber())) {
            throw new RuntimeException("Phone number already exists");
        }
        
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));
        user.setActive(false);
        userRepository.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User authenticateUser(String email, String password) {
        User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("Invalid email or password"));
        
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }
        
        return user;
    }
} 