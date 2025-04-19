# RideEase - Ride Booking System

A comprehensive ride booking system built with Spring Boot and PostgreSQL.

## Features

### User Management
- User registration and authentication
- User profile management
- Role-based access control (Regular, Premium, Admin)

### Driver Management
- Driver registration and verification
- Vehicle information management
- Driver availability tracking
- Driver rating system

### Ride Management
- Ride booking
- Real-time ride tracking
- Fare calculation
- Ride status updates
- Payment processing

## Technical Stack

- **Backend**: Spring Boot 3.2.3
- **Database**: PostgreSQL
- **Security**: Spring Security
- **API Documentation**: Swagger/OpenAPI
- **Build Tool**: Maven

## Design Patterns Used

1. **Factory Pattern**: Used for creating different types of users
2. **Command Pattern**: Used for handling payment methods and booking operations
3. **Builder Pattern**: Used for creating complex driver and vehicle objects
4. **Observer Pattern**: Used for real-time ride tracking and notifications

## Design Principles Applied

1. **Single Responsibility Principle**: Each class has a single responsibility
2. **Open-Closed Principle**: Extending payment methods without modifying existing code
3. **Interface Segregation Principle**: Separating driver and vehicle interfaces
4. **Dependency Inversion Principle**: Decoupling navigation services from core tracking

## Project Structure

```
src/main/java/com/rideease/
├── config/           # Configuration classes
├── controller/       # REST controllers
├── model/           # Entity classes
├── repository/      # JPA repositories
├── service/         # Service interfaces
└── service/impl/    # Service implementations
```

## API Endpoints

### User Endpoints
- `POST /api/users/register` - Register a new user
- `POST /api/users/authenticate` - Authenticate user
- `GET /api/users/{userId}` - Get user by ID
- `PUT /api/users/{userId}` - Update user
- `DELETE /api/users/{userId}` - Delete user

### Driver Endpoints
- `POST /api/drivers/register` - Register a new driver
- `GET /api/drivers/available` - Get available drivers
- `PUT /api/drivers/{driverId}/availability` - Update driver availability
- `PUT /api/drivers/{driverId}/rating` - Update driver rating

### Ride Endpoints
- `POST /api/rides/book` - Book a new ride
- `GET /api/rides/{rideId}` - Get ride details
- `PUT /api/rides/{rideId}/status` - Update ride status
- `POST /api/rides/{rideId}/cancel` - Cancel a ride
- `POST /api/rides/{rideId}/start` - Start a ride
- `POST /api/rides/{rideId}/complete` - Complete a ride

## Setup and Installation

1. Clone the repository
2. Create a PostgreSQL database named `rideease`
3. Update database credentials in `application.properties`
4. Run the application using Maven:
   ```bash
   mvn spring-boot:run
   ```

## Team Members and Responsibilities

1. **Team Member 1**
   - Major Feature: User Registration & Authentication System
   - Minor Feature: User Profile Management
   - Design Pattern: Factory Pattern
   - Design Principle: Single Responsibility Principle

2. **Team Member 2**
   - Major Feature: Ride Booking & Payment System
   - Minor Feature: Booking History & Receipts
   - Design Pattern: Command Pattern
   - Design Principle: Open-Closed Principle

3. **Team Member 3**
   - Major Feature: Driver Management & Vehicle Registration
   - Minor Feature: Driver Rating & Review System
   - Design Pattern: Builder Pattern
   - Design Principle: Interface Segregation Principle

4. **Team Member 4**
   - Major Feature: Ride Tracking & Navigation
   - Minor Feature: Fare Calculation & Promotions
   - Design Pattern: Observer Pattern
   - Design Principle: Dependency Inversion Principle 