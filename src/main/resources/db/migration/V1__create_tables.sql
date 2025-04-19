CREATE TABLE IF NOT EXISTS users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    phone_number VARCHAR(20) NOT NULL UNIQUE,
    user_type VARCHAR(20) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    is_active BOOLEAN NOT NULL,
    license_number VARCHAR(50),
    vehicle_type VARCHAR(50),
    vehicle_number VARCHAR(20),
    vehicle_model VARCHAR(100),
    year_of_experience INT
); 