package com.rideease.service.impl;

import com.rideease.model.Ride;
import com.rideease.model.Driver;
import com.rideease.model.User;
import com.rideease.repository.RideRepository;
import com.rideease.service.RideService;
import com.rideease.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class RideServiceImpl implements RideService {

    @Autowired
    private RideRepository rideRepository;
    
    @Autowired
    private DriverService driverService;

    @Override
    public Ride bookRide(Ride ride) {
        // Calculate fare based on distance and driver's rate
        double fare = calculateFare(ride.getDistance(), ride.getDriver());
        ride.setFare(fare);
        
        ride.setStatus(Ride.RideStatus.REQUESTED);
        ride.setBookingTime(LocalDateTime.now());
        
        return rideRepository.save(ride);
    }

    @Override
    public Ride updateRideStatus(Long rideId, Ride.RideStatus status) {
        Ride ride = getRideById(rideId);
        ride.setStatus(status);
        return rideRepository.save(ride);
    }

    @Override
    public Ride getRideById(Long rideId) {
        return rideRepository.findById(rideId)
            .orElseThrow(() -> new RuntimeException("Ride not found"));
    }

    @Override
    public List<Ride> getUserRides(Long userId) {
        return rideRepository.findByUserId(userId);
    }

    @Override
    public List<Ride> getDriverRides(Long driverId) {
        return rideRepository.findByDriverId(driverId);
    }

    @Override
    public double calculateFare(Double distance, Driver driver) {
        // Basic calculation: $2 per km
        double baseFare = distance * 2.0;
        
        // Add driver's experience bonus (5% extra per year, up to 25%)
        double experienceBonus = Math.min(0.25, driver.getYearOfExperience() * 0.05);
        
        return baseFare * (1 + experienceBonus);
    }

    @Override
    public Ride cancelRide(Long rideId) {
        Ride ride = getRideById(rideId);
        ride.setStatus(Ride.RideStatus.CANCELLED);
        return rideRepository.save(ride);
    }

    @Override
    public Ride startRide(Long rideId) {
        Ride ride = getRideById(rideId);
        ride.setStatus(Ride.RideStatus.STARTED);
        ride.setStartTime(LocalDateTime.now());
        return rideRepository.save(ride);
    }

    @Override
    public Ride completeRide(Long rideId) {
        Ride ride = getRideById(rideId);
        ride.setStatus(Ride.RideStatus.COMPLETED);
        ride.setEndTime(LocalDateTime.now());
        return rideRepository.save(ride);
    }
} 