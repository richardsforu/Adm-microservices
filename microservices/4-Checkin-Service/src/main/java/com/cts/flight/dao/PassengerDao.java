package com.cts.flight.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.flight.entity.BookingRecord;
import com.cts.flight.entity.Passenger;

public interface PassengerDao extends JpaRepository<Passenger, Long>{

	Passenger findByBookingRecord(BookingRecord bookingRecord);
	
}
