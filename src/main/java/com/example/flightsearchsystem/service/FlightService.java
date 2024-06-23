package com.example.flightsearchsystem.service;

import com.example.flightsearchsystem.model.Flight;
import com.example.flightsearchsystem.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Flight getFlightById(Long id) {
        return flightRepository.findById(id).orElse(null);
    }

    public Flight saveFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public List<Flight> getFlightByDepartureAndNumberOfPassengers(String departure, int numberOfPassengers) {
        return flightRepository.findByDestinationAndAvailableSeatsGreaterThan(departure, numberOfPassengers);
    }
}
