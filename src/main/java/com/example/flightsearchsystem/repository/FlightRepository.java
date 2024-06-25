package com.example.flightsearchsystem.repository;

import com.example.flightsearchsystem.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findByDepartureAndAndAvailableSeatsGreaterThanEqual(String departure, int availableSeats);
}
