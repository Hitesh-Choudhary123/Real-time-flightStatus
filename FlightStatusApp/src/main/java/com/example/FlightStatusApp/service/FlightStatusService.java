package com.example.FlightStatusApp.service;
import com.example.FlightStatusApp.model.FlightStatus;
import com.example.FlightStatusApp.repository.FlightStatusRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FlightStatusService {

    @Autowired
    private FlightStatusRepository repository;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public Optional<FlightStatus> getFlightStatus(String flightNumber) {
        return repository.findByFlightNumber(flightNumber);
    }

    public FlightStatus updateFlightStatus(FlightStatus flightStatus) {
        FlightStatus updatedStatus = repository.save(flightStatus);
        rabbitTemplate.convertAndSend("flightStatusExchange", "status.update", updatedStatus);
        return updatedStatus;
    }
}
