package com.example.flightsearchsystem.controller;

import com.example.flightsearchsystem.model.Reservation;
import com.example.flightsearchsystem.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    public ReservationService reservationService;

    @GetMapping("/{userId}")
    public List<Reservation> getReservations(@PathVariable Long userId) {
        return reservationService.getReservationsByUserId(userId);
    }

    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @PostMapping
    public Reservation addReservation(@RequestBody Reservation reservation) {
        return reservationService.saveReservation(reservation);
    }
}
