package com.example.Flight.Search.System.controller;

import com.example.Flight.Search.System.model.Reservation;
import com.example.Flight.Search.System.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    public ReservationService reservationService;

    @GetMapping("users/{userId}")
    public List<Reservation> getReservations(@PathVariable Long userId) {
        return reservationService.getReservationsByUserId(userId);
    }

    @PostMapping
    public Reservation addReservation(@RequestBody Reservation reservation) {
        return reservationService.saveReservation(reservation);
    }
}
