package com.example.flightsearchsystem;

import com.example.flightsearchsystem.model.Flight;
import com.example.flightsearchsystem.repository.FlightRepository;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class FlightRepositoryTest {

    @Autowired
    private FlightRepository flightRepository;

    @Test
    public void testFindByDestinationAndAvailableSeatsGreaterThan(){

        Flight flight =  new Flight();
        flight.setDeparture("TEST1");
        flight.setAvailableSeats(10);
        flightRepository.save(flight);

        List<Flight> flightList = flightRepository.findByDepartureAndAndAvailableSeatsGreaterThanEqual("TEST1", 5);

        assertEquals(1, flightList.size());
        assertEquals("TEST1", flightList.get(0).getDeparture());
        assertEquals(10, flightList.get(0).getAvailableSeats());
    }
}
