package com.rideease.model;

import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String email;
    
    @Column(nullable = false)
    private String password;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false, unique = true)
    private String phoneNumber;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    @JsonDeserialize(using = UserTypeDeserializer.class)
    private UserType userType;
    
    @Column(nullable = false)
    private LocalDateTime createdAt;
    
    @Column(nullable = false)
    private boolean isActive;
    
    // Driver-specific fields
    private String licenseNumber;
    private String vehicleType;
    private String vehicleNumber;
    private String vehicleModel;
    private Integer yearOfExperience;
    
    public enum UserType {
        REGULAR, PREMIUM, ADMIN, DRIVER
    }
} 