package com.rideease.service;

import com.rideease.model.Driver;
import com.rideease.model.User;
import java.util.List;

public interface DriverService {
    Driver saveDriver(Driver driver);
    Driver getDriverById(Long id);
    List<Driver> getAllDrivers();
    Driver updateDriver(Driver driver);
    void deleteDriver(Long id);
    List<Driver> getAvailableDrivers();
    Driver updateDriverAvailability(Long id, boolean isAvailable);
    Driver updateDriverRating(Long id, double rating);
    void updateDriverLocation(Long driverId, String location);
    Driver getDriverByUser(User user);
    List<Driver> getVerifiedDrivers();
} 