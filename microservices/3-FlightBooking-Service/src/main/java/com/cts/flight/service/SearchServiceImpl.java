package com.cts.flight.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.flight.dao.BookingRecordDao;
import com.cts.flight.dao.FlightDao;
import com.cts.flight.entity.BookingRecord;
import com.cts.flight.entity.Flight;
import com.cts.flight.entity.Inventory;

@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	private FlightDao flightDao;
	@Autowired
	private BookingRecordDao bookingRecordDao;

	@Override
	public List<Flight> searchFlights(SearchQuery searchQuery) {
		List<Flight> flights = flightDao.findByOriginAndDestinationAndFlightDate(searchQuery.getOrigin(),
				searchQuery.getDestination(), searchQuery.getFlightDate());

		Stream<Flight> searchResults = flights.stream()
				.filter(flight -> flight.getInventory().getCount() >= searchQuery.getNumberofPassengers());

		return searchResults.collect(Collectors.toList());
	}

	@Override
	public void updateInventory(String flightNumber, LocalDate flightDate, int new_inventory) {

		Flight flight = flightDao.findByFlightNumberAndFlightDate(flightNumber, flightDate);
		if (flight != null) {
			Inventory inv = flight.getInventory();

			inv.setCount(inv.getCount() - new_inventory);
			flightDao.save(flight);

		} else {
			throw new RuntimeException(">>>> Failed ");
		}

	}
	
	
	

	@Override
	public Flight findByFlightNumberAndDlightDate(String flightNumber, LocalDate flightDate) {
		return flightDao.findByFlightNumberAndFlightDate(flightNumber, flightDate);
	}

	@Override
	public Flight findByFlightId(int id) {
		return flightDao.findById(id).orElse(null);
	}

}
