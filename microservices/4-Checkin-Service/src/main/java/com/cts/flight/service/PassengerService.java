package com.cts.flight.service;

import com.cts.flight.entity.BookingRecord;
import com.cts.flight.entity.Passenger;

public interface PassengerService {

	Passenger findByBookingRecord(BookingRecord bookingRecord);

}