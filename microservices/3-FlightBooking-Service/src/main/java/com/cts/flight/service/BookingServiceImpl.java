package com.cts.flight.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cts.flight.controller.Sender;
import com.cts.flight.dao.BookingRecordDao;
import com.cts.flight.dao.PassengerDao;
import com.cts.flight.entity.BookingRecord;
import com.cts.flight.entity.Fare;
import com.cts.flight.entity.Flight;
import com.cts.flight.entity.Passenger;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private Sender sender;

	@Autowired
	private PassengerDao passengerDao;
	@Autowired
	private BookingRecordDao bookingRecordDao;

	@Autowired
	private RestTemplate restTemplate;

	private static final String FAREURL = "http://localhost:8081/api/fare";
	private static final String FINDFLIGHTURL = "http://localhost:8082/api/search";

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Override
	public Passenger bookFlight(Passenger passenger, long id, int numberofPassengers) {

		Fare fare = null;
		Flight flight = null;
		try {

			fare = restTemplate.getForObject(FAREURL + "/" + id, Fare.class);
			flight = restTemplate.getForObject(FINDFLIGHTURL + "/" + id, Flight.class);

			System.out.println(">>>>> FARE <<<<<<");
			System.out.println(fare.getFare());
			
			System.out.println(">>>> FLIGHT-NUMBER <<<<<");
			System.out.println(flight.getFlightNumber());
			
			
			if (flight.getInventory().getCount() < numberofPassengers) {
				System.out.println(">>>> No Seats Available <<<<");
			}

			if (flight != null) {

				BookingRecord bookingRecord = new BookingRecord(flight.getFlightNumber(), flight.getOrigin(),
						flight.getDestination(), flight.getFare().getFare(), flight.getFlightDate(),
						flight.getFlightTime(), "CONFIRMED", LocalDateTime.now());

				bookingRecord.setFare(fare.getFare() * numberofPassengers);
				passenger.setBookingRecord(bookingRecord);

				if (passenger.getCoPassengers().size() == numberofPassengers - 1) {
					passengerDao.save(passenger);
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		// SEND NEW INVENTORY DETAILS TO SEARCXH MICRO SERVICE VIA RABBITMQ TO UPDATE
		// INTO DB

		Map<String, Object> bookingDetails = new HashMap<>();
		bookingDetails.put("FLIGHT_NUMBER", flight.getFlightNumber());
		bookingDetails.put("FLIGHT_DATE", flight.getFlightDate());
		bookingDetails.put("NEW_INVENTORY", numberofPassengers);

		sender.send(bookingDetails);

		return passenger;

	}

	
	
	public void updateStatus(String status,long bookingId) {
		BookingRecord bookingRecord=bookingRecordDao.findByBookingId(bookingId);
		if(bookingRecord!=null) {
		System.out.println(">>>> Updating status from "+bookingRecord.getStatus()+" to "+status +" <<<<");
		bookingRecord.setStatus(status);
		bookingRecordDao.save(bookingRecord);
		}
		
	}
	
	
	@Override
	public BookingRecord getBookingInfo(long bookingId) {
		return bookingRecordDao.findByBookingId(bookingId);
	}

}
