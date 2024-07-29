package com.example.FlightStatusApp.controller;
import com.example.FlightStatusApp.model.FlightStatus;
import com.example.FlightStatusApp.service.FlightStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class FlightStatusController {

    @Autowired
    private FlightStatusService service;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/status/{flightNumber}")
    public Optional<FlightStatus> getFlightStatus(@PathVariable String flightNumber) {
        return service.getFlightStatus(flightNumber);
    }

    @PostMapping("/status")
    public FlightStatus updateFlightStatus(@RequestBody FlightStatus flightStatus) {
        return service.updateFlightStatus(flightStatus);
    }

    @MessageMapping("/updateStatus")
    @SendTo("/topic/status")
    public FlightStatus broadcastStatus(FlightStatus flightStatus) {
        return service.updateFlightStatus(flightStatus);
    }
}
