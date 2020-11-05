package com.cts.flight.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.flight.dao.PassengerDao;
import com.cts.flight.entity.BookingRecord;
import com.cts.flight.entity.Passenger;

@Service
public class PassengerServiceImpl implements PassengerService {
	
	@Autowired
	private PassengerDao passengerDao;
	
	@Override
	public Passenger findByBookingRecord(BookingRecord bookingRecord) {
		return passengerDao.findByBookingRecord(bookingRecord);
	}

}
