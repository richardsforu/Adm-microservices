package com.cts.flight.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.flight.dao.FlightDao;
import com.cts.flight.entity.Fare;
import com.cts.flight.entity.Flight;

@Service
public class FareServiceImpl implements FareService {

	@Autowired
	private FlightDao flightDao;

	@Override
	public Flight getFare(String flightNumber, LocalDate flightDate) {
		return flightDao.findByFlightNumberAndFlightDate(flightNumber, flightDate);
	}

	@Override
	public Fare getFareByFlightId(int id) {
		Flight flight = flightDao.findById(id).orElse(null);

		if (flight != null) {
			return flight.getFare();
		}

		return null;

	}

}
