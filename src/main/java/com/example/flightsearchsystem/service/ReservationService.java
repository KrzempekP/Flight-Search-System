package com.example.flightsearchsystem.service;

import com.example.flightsearchsystem.model.Reservation;
import com.example.flightsearchsystem.repository.FlightRepository;
import com.example.flightsearchsystem.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private FlightService flightService;

    public List<Reservation> getReservationsByUserId(Long userId) {
        return reservationRepository.findByUserId(userId);
    }

    public Reservation saveReservation(Reservation reservation) {
        flightService.reduceAbailableSeats(reservation.getFlight().getId(), reservation.getNumberOfPassengers());
        return reservationRepository.save(reservation);
    }

}
