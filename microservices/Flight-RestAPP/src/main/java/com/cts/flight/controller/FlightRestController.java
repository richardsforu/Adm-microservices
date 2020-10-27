package com.cts.flight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.flight.dao.FlightDao;
import com.cts.flight.entity.Flight;

@RestController
@CrossOrigin
@RequestMapping("/api/flights")
public class FlightRestController {
	
	@Autowired
	private FlightDao flightDao;
	
	@GetMapping
	public List<Flight> findAllFlights(){
		return flightDao.findAll();
	}
	

	@PostMapping("/flights/scheduleFlights")
	public List<Flight> saveAllFlights(@RequestBody List<Flight> flights) {
		return flightDao.saveAll(flights);
	}
	
	

}
