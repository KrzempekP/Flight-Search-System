package com.example.flightsearchsystem.controller;


import com.example.flightsearchsystem.model.Flight;
import com.example.flightsearchsystem.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }

    @GetMapping("/{id}")
    public Flight getFlightById(@PathVariable Long id) {
        return flightService.getFlightById(id);
    }

    @GetMapping("/{departure}/{numberOfPassengers}")
    public List<Flight> getFlightByDepartureAndNumberOfPassengers(@PathVariable String departure, @PathVariable Integer numberOfPassengers) {
        return flightService.getFlightByDepartureAndAvailableSeats(departure, numberOfPassengers);
    }

    @PostMapping
    public Flight addFlight(@RequestBody Flight flight) {
        return flightService.saveFlight(flight);
    }
}
