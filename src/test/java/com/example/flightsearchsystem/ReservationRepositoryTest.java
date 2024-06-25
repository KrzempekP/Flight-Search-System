package com.example.flightsearchsystem;

import com.example.flightsearchsystem.model.Flight;
import com.example.flightsearchsystem.model.Reservation;
import com.example.flightsearchsystem.model.User;
import com.example.flightsearchsystem.repository.ReservationRepository;
import com.example.flightsearchsystem.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ReservationRepositoryTest {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByUserId(){

        Reservation reservation = new Reservation();
        User johny = new User();
        userRepository.save(johny);
        reservation.setUser(johny);
        reservationRepository.save(reservation);


        List<Reservation> reservationList = reservationRepository.findByUserId(4L);

        assertEquals(1, reservationList.size());
        assertEquals(4, reservationList.get(0).getUser().getId());
    }
}

