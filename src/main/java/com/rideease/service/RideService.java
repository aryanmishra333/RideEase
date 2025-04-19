package com.rideease.service;

import com.rideease.model.Ride;
import com.rideease.model.User;
import com.rideease.model.Driver;
import java.util.List;

public interface RideService {
    Ride bookRide(Ride ride);
    Ride updateRideStatus(Long rideId, Ride.RideStatus status);
    Ride getRideById(Long rideId);
    List<Ride> getUserRides(Long userId);
    List<Ride> getDriverRides(Long driverId);
    Ride cancelRide(Long rideId);
    Ride startRide(Long rideId);
    Ride completeRide(Long rideId);
    double calculateFare(Double distance, Driver driver);
} 