package com.cts.flight.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.flight.entity.Flight;

public interface FlightDao extends JpaRepository<Flight, Integer> {
	List<Flight> findByOriginAndDestinationAndFlightDate(String origin,String destination,LocalDate flightDate);
	public Flight findByFlightNumberAndFlightDate(String flightNumber,LocalDate flightDate);
	
	Flight findByFlightNumber(String flightNumber);

}
