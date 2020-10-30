package com.cts.flight.service;

import java.time.LocalDate;

import com.cts.flight.entity.Fare;
import com.cts.flight.entity.Flight;

public interface FareService {

	Flight getFare(String flightNumber, LocalDate flightDate);

	Fare getFareByFlightId(int id);

}