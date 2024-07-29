package com.example.FlightStatusApp.repository;

import com.example.FlightStatusApp.model.FlightStatus;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface FlightStatusRepository extends MongoRepository<FlightStatus, String> {
    Optional<FlightStatus> findByFlightNumber(String flightNumber);
}

