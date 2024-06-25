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
        if(flight.getAvailableSeats() <= flight.getPassengersCapacity()){
            return flightRepository.save(flight);
        }
        else{
            throw new IllegalArgumentException("More available seats then maximum capacity");
        }
    }

    public List<Flight> getFlightByDepartureAndAvailableSeats(String departure, int numberOfPassengers) {
        return flightRepository.findByDepartureAndAndAvailableSeatsGreaterThanEqual(departure, numberOfPassengers);
    }

    public void reduceAvailableSeats(Long flightId, int numberOfPassengers) {
        Flight flight = flightRepository.findById(flightId).orElse(null);
        if (flight != null) {
            if (flight.getAvailableSeats() >= numberOfPassengers) {
                flight.setAvailableSeats(flight.getAvailableSeats() - numberOfPassengers);
                flightRepository.save(flight);
            } else {
                throw new IllegalArgumentException("Number of abailable seats exceeds number of passengers");
            }
        } else {
            throw new IllegalArgumentException("Flight not found");
        }

    }
}
