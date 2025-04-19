package com.rideease.repository;

import com.rideease.model.Ride;
import com.rideease.model.User;
import com.rideease.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RideRepository extends JpaRepository<Ride, Long> {
    List<Ride> findByUserId(Long userId);
    List<Ride> findByUserIdAndStatus(Long userId, Ride.RideStatus status);
    List<Ride> findByDriverIdAndStatus(Long driverId, Ride.RideStatus status);
    List<Ride> findByDriverId(Long driverId);
} 