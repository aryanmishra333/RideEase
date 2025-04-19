package com.rideease.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;

public class UserTypeDeserializer extends JsonDeserializer<User.UserType> {
    @Override
    public User.UserType deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String value = p.getValueAsString();
        if (value == null) {
            return null;
        }
        
        // Normalize the input value
        value = value.trim().toUpperCase();
        
        // Try to match the enum value
        for (User.UserType type : User.UserType.values()) {
            if (type.name().equals(value)) {
                return type;
            }
        }
        
        // If no match found, throw an exception with helpful message
        StringBuilder validValues = new StringBuilder();
        for (User.UserType type : User.UserType.values()) {
            if (validValues.length() > 0) {
                validValues.append(", ");
            }
            validValues.append(type.name().toLowerCase());
        }
        
        throw new IllegalArgumentException(
            "Invalid user type: '" + value.toLowerCase() + "'. " +
            "Valid values are: " + validValues.toString()
        );
    }
} 