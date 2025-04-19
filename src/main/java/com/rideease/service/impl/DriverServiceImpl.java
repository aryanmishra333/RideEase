package com.rideease.service.impl;

import com.rideease.model.Driver;
import com.rideease.model.User;
import com.rideease.repository.DriverRepository;
import com.rideease.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepository driverRepository;

    @Override
    public Driver saveDriver(Driver driver) {
        if (driver.getLicenseNumber() != null && 
            driverRepository.existsByLicenseNumber(driver.getLicenseNumber())) {
            throw new RuntimeException("License number already exists");
        }
        
        driver.setRegistrationDate(LocalDateTime.now());
        driver.setAvailable(true);
        driver.setRating(0.0);
        return driverRepository.save(driver);
    }

    @Override
    public Driver getDriverById(Long id) {
        return driverRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Driver not found"));
    }

    @Override
    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    @Override
    public Driver updateDriver(Driver driver) {
        Driver existingDriver = getDriverById(driver.getId());
        
        if (!existingDriver.getLicenseNumber().equals(driver.getLicenseNumber()) && 
            driverRepository.existsByLicenseNumber(driver.getLicenseNumber())) {
            throw new RuntimeException("License number already exists");
        }
        
        return driverRepository.save(driver);
    }

    @Override
    public void deleteDriver(Long id) {
        driverRepository.deleteById(id);
    }

    @Override
    public List<Driver> getAvailableDrivers() {
        return driverRepository.findByAvailable(true);
    }

    @Override
    public Driver updateDriverAvailability(Long id, boolean isAvailable) {
        Driver driver = getDriverById(id);
        driver.setAvailable(isAvailable);
        return driverRepository.save(driver);
    }

    @Override
    public Driver updateDriverRating(Long id, double rating) {
        Driver driver = getDriverById(id);
        driver.setRating(rating);
        return driverRepository.save(driver);
    }

    @Override
    public void updateDriverLocation(Long driverId, String location) {
        Driver driver = getDriverById(driverId);
        driver.setCurrentLocation(location);
        driverRepository.save(driver);
    }

    @Override
    public Driver getDriverByUser(User user) {
        return driverRepository.findByUser(user)
            .orElseThrow(() -> new RuntimeException("Driver not found"));
    }

    @Override
    public List<Driver> getVerifiedDrivers() {
        return driverRepository.findByIsVerified(true);
    }
} 