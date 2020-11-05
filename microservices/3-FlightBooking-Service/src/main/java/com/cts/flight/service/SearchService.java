package com.cts.flight.service;

import java.time.LocalDate;
import java.util.List;

import com.cts.flight.entity.Flight;

public interface SearchService {

	List<Flight> searchFlights(SearchQuery searchQuery);

	void updateInventory(String flightNumber, LocalDate flightDate, int new_inventory);

	Flight findByFlightNumberAndDlightDate(String flightNumber, LocalDate flightDate);

	Flight findByFlightId(int id);
	

}