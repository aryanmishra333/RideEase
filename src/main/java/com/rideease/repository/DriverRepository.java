package com.rideease.repository;

import com.rideease.model.Driver;
import com.rideease.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
    boolean existsByLicenseNumber(String licenseNumber);
    List<Driver> findByAvailable(boolean available);
    Optional<Driver> findByUser(User user);
    Optional<Driver> findByLicenseNumber(String licenseNumber);
    List<Driver> findByIsVerified(boolean isVerified);
} 