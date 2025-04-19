package com.rideease.controller;

import com.rideease.model.Driver;
import com.rideease.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @PostMapping
    public ResponseEntity<Driver> registerDriver(@RequestBody Driver driver) {
        return ResponseEntity.ok(driverService.saveDriver(driver));
    }

    @PutMapping("/{driverId}")
    public ResponseEntity<Driver> updateDriver(@PathVariable Long driverId, @RequestBody Driver driver) {
        driver.setId(driverId);
        return ResponseEntity.ok(driverService.updateDriver(driver));
    }

    @DeleteMapping("/{driverId}")
    public ResponseEntity<Void> deleteDriver(@PathVariable Long driverId) {
        driverService.deleteDriver(driverId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{driverId}")
    public ResponseEntity<Driver> getDriverById(@PathVariable Long driverId) {
        return ResponseEntity.ok(driverService.getDriverById(driverId));
    }

    @GetMapping
    public ResponseEntity<List<Driver>> getAllDrivers() {
        return ResponseEntity.ok(driverService.getAllDrivers());
    }

    @GetMapping("/available")
    public ResponseEntity<List<Driver>> getAvailableDrivers() {
        return ResponseEntity.ok(driverService.getAvailableDrivers());
    }

    @PutMapping("/{driverId}/availability")
    public ResponseEntity<Driver> updateDriverAvailability(
            @PathVariable Long driverId,
            @RequestParam boolean isAvailable) {
        return ResponseEntity.ok(driverService.updateDriverAvailability(driverId, isAvailable));
    }

    @PutMapping("/{driverId}/location")
    public ResponseEntity<Void> updateDriverLocation(
            @PathVariable Long driverId,
            @RequestParam String location) {
        driverService.updateDriverLocation(driverId, location);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{driverId}/rating")
    public ResponseEntity<Driver> updateDriverRating(
            @PathVariable Long driverId,
            @RequestParam double rating) {
        return ResponseEntity.ok(driverService.updateDriverRating(driverId, rating));
    }
} 