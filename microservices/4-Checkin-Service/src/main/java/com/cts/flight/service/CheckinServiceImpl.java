package com.cts.flight.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cts.flight.controller.Sender;
import com.cts.flight.dao.CheckinDao;
import com.cts.flight.entity.BookingRecord;
import com.cts.flight.entity.CheckIn;
import com.cts.flight.entity.Passenger;

@Service
public class CheckinServiceImpl implements CheckinService {

	@Autowired
	private CheckinDao checkinDao;

	@Autowired
	private Sender sender;

	@Autowired
	private PassengerService passengerService;

	@Autowired
	private RestTemplate restTemplate;

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	private static final String BOOKINURL = "http://localhost:8083/api/book";

	@Override
	public CheckIn checkIn(long bookingId) {

		CheckIn checkinObj = null;

		BookingRecord bookingRecord = restTemplate.getForObject(BOOKINURL + "/" + bookingId, BookingRecord.class);

		if (bookingRecord != null) {
			Passenger passenger = passengerService.findByBookingRecord(bookingRecord);
			if (passenger != null) {
				checkinObj = new CheckIn();
				checkinObj.setBookingId(bookingId);
				checkinObj.setCheckinTime(LocalDateTime.now());
				checkinObj.setFlightNumber(passenger.getBookingRecord().getFlightNumber());
				checkinObj.setPassenger(passenger);
				checkinObj.setSeatNumber("B3");

				checkinDao.save(checkinObj);

				// Send bookingId to Booking-Service Microservice
				// change status from confirmed to CHECKED-IN

				sender.send(bookingId);
			}
			return checkinObj;
		}

		return null;
	}

	@Override
	public CheckIn getCheckInInfo(long bookingId) {

		CheckIn checkIn = checkinDao.findByBookingId(bookingId);
		if (checkIn == null) {
			return null;
		}

		return checkinDao.findByBookingId(bookingId);

	}

}
