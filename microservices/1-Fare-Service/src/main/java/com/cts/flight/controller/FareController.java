package com.cts.flight.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.flight.dao.FareDao;
import com.cts.flight.dao.FlightDao;
import com.cts.flight.entity.Fare;
import com.cts.flight.entity.Flight;
import com.cts.flight.service.FareService;

@RestController
@CrossOrigin
@RequestMapping("/api/fare")
public class FareController {


	
	@Autowired
	private FareService fs;
	
	@GetMapping("/getFare/{flightNumber}/{flightDate}")
	public Flight getFareByFlightInfo(@PathVariable("flightNumber") String flightNumber,
			@PathVariable("flightDate") @DateTimeFormat(iso = ISO.DATE) LocalDate flightDate) {
		return fs.getFare(flightNumber, flightDate);
	}

	
	@GetMapping("/{fareId}")
	public Fare getFare(@PathVariable("fareId") int fareId) {
		return fs.getFareByFlightId(fareId);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
