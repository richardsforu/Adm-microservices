package com.cts.flight.controller;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.cts.flight.service.BookingService;

@Controller
public class Receiver {
	
	@Autowired
	private BookingService bookingService;
	
	@RabbitListener(queues = "CheckINQ")
	public void processMessage(long bookingId) {
		System.out.println(">>>>> Before Updating <<<<");
		bookingService.updateStatus("CHECKED-IN", bookingId);
		
	}

}
