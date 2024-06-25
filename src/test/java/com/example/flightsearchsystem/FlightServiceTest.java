package com.example.flightsearchsystem;

import com.example.flightsearchsystem.model.Flight;
import com.example.flightsearchsystem.repository.FlightRepository;
import com.example.flightsearchsystem.service.FlightService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FlightServiceTest {

    @Mock
    private FlightRepository flightRepository;

    @InjectMocks
    private FlightService flightService;

    private Flight flight1;
    private Flight flight2;

    @BeforeEach
    public void setUp() {

        MockitoAnnotations.openMocks(this);
        flight1 = new Flight();
        flight1.setId(1L);
        flight1.setDeparture("KRK");
        flight1.setAvailableSeats(10);
        flight1.setPassengersCapacity(20);

        flight2 = new Flight();
        flight2.setId(2L);
        flight2.setDeparture("KRK");
        flight2.setAvailableSeats(30);
        flight2.setPassengersCapacity(20);
    }

    @Test
    public void testGetAllFlights() {
        when(flightRepository.findAll()).thenReturn(Arrays.asList(flight1, flight2));

        List<Flight> allFlights = flightService.getAllFlights();

        assertEquals(2, allFlights.size());
        verify(flightRepository, times(1)).findAll();
    }

    @Test
    public void testGetFlightById() {
        when(flightRepository.findById(1L)).thenReturn(Optional.of(flight1));

        Flight flight = flightService.getFlightById(1L);

        assertEquals(flight1, flight);
        verify(flightRepository, times(1)).findById(1L);
    }

    @Test
    public void testSaveFlight(){
        when(flightRepository.save(flight1)).thenReturn(flight1);

        assertEquals(flight1, flightService.saveFlight(flight1));
        verify(flightRepository, times(1)).save(flight1);
    }

    @Test
    public void testGetFlightByDepartureAndAvailableSeats(){
        when(flightRepository.findByDepartureAndAndAvailableSeatsGreaterThanEqual("KRK", 5)).thenReturn(Arrays.asList(flight1, flight2));

        List<Flight> choosenFlights = flightService.getFlightByDepartureAndAvailableSeats("KRK", 5);
        assertEquals(2, choosenFlights.size());
        verify(flightRepository, times(1)).findByDepartureAndAndAvailableSeatsGreaterThanEqual("KRK", 5);
    }
}
