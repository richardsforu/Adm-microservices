package com.cts.flight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.flight.entity.Flight;
import com.cts.flight.service.SearchQuery;
import com.cts.flight.service.SearchService;

@RestController
@CrossOrigin
@RequestMapping("/api/search")
public class SearchRestController {
	
	@Autowired
	private SearchService searchService;
	
	@PostMapping("/findFlights")
	public List<Flight> findFlights(@RequestBody SearchQuery searchQuery){
		return searchService.searchFlights(searchQuery);
	}
	
	@GetMapping("/{id}")
	public  Flight findFlight(@PathVariable("id")int id) {
		return searchService.findByFlightId(id);
	}
	

}
