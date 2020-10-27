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

import com.cts.flight.dao.FareDao;
import com.cts.flight.entity.Fare;

@RestController
@CrossOrigin
@RequestMapping("/api/fare")
public class FareController {

	
	@Autowired
	private FareDao fareDao;
	
	@GetMapping
	public List<Fare> allFkightFares(){
		return fareDao.findAll();
	}
	
	@GetMapping("/{fareId}")
	public Fare getFare(@PathVariable("fareId") int fareId) {
		return fareDao.findById(fareId).orElse(null);
		
	}
	
	@PostMapping
	public Fare addFare(@RequestBody Fare fare) {
		return fareDao.save(fare);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
