package com.rideease.controller;

import com.rideease.model.Ride;
import com.rideease.model.User;
import com.rideease.model.Driver;
import com.rideease.service.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/rides")
public class RideController {

    @Autowired
    private RideService rideService;

    @PostMapping("/book")
    public ResponseEntity<Ride> bookRide(@RequestBody Ride ride) {
        return ResponseEntity.ok(rideService.bookRide(ride));
    }

    @PutMapping("/{rideId}/status")
    public ResponseEntity<Ride> updateRideStatus(
            @PathVariable Long rideId,
            @RequestParam Ride.RideStatus status) {
        return ResponseEntity.ok(rideService.updateRideStatus(rideId, status));
    }

    @GetMapping("/{rideId}")
    public ResponseEntity<Ride> getRideById(@PathVariable Long rideId) {
        return ResponseEntity.ok(rideService.getRideById(rideId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Ride>> getUserRides(@PathVariable Long userId) {
        return ResponseEntity.ok(rideService.getUserRides(userId));
    }

    @GetMapping("/driver/{driverId}")
    public ResponseEntity<List<Ride>> getDriverRides(@PathVariable Long driverId) {
        return ResponseEntity.ok(rideService.getDriverRides(driverId));
    }

    @PostMapping("/{rideId}/cancel")
    public ResponseEntity<Void> cancelRide(@PathVariable Long rideId) {
        rideService.cancelRide(rideId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{rideId}/start")
    public ResponseEntity<Ride> startRide(@PathVariable Long rideId) {
        return ResponseEntity.ok(rideService.startRide(rideId));
    }

    @PostMapping("/{rideId}/complete")
    public ResponseEntity<Ride> completeRide(@PathVariable Long rideId) {
        return ResponseEntity.ok(rideService.completeRide(rideId));
    }
} 