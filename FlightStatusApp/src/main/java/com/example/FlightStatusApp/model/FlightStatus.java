package com.example.FlightStatusApp.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "flight_status")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FlightStatus {
    @Id
    private String id;
    private String flightNumber;
    private String status;

    // Getters and Setters
}

