package com.rideease.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "rides")
@Data
public class Ride {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    @ManyToOne
    @JoinColumn(name = "driver_id", nullable = false)
    private Driver driver;
    
    @Column(nullable = false)
    private String pickupLocation;
    
    @Column(nullable = false)
    private String dropLocation;
    
    @Column(nullable = false)
    private Double distance;
    
    @Column(nullable = false)
    private Double fare;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RideStatus status;
    
    @Column(nullable = false)
    private LocalDateTime bookingTime;
    
    private LocalDateTime startTime;
    
    private LocalDateTime endTime;
    
    @Column
    private String paymentMethod;
    
    @Column
    private boolean isPaid;
    
    public enum RideStatus {
        REQUESTED, ACCEPTED, STARTED, COMPLETED, CANCELLED
    }
} 