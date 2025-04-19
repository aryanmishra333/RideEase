package com.rideease.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "drivers")
@Data
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    @Column(nullable = false, unique = true)
    private String licenseNumber;
    
    @Column(nullable = false)
    private String vehicleType;
    
    @Column(nullable = false, unique = true)
    private String vehicleNumber;
    
    @Column(nullable = false)
    private String vehicleModel;
    
    @Column(nullable = false)
    private Integer yearOfExperience;
    
    @Column(nullable = false)
    private LocalDateTime registrationDate;
    
    @Column(nullable = false)
    private boolean available;
    
    @Column(nullable = false)
    private Double rating;
    
    @Column(nullable = false)
    private boolean isVerified;
    
    @Column
    private String currentLocation;
} 