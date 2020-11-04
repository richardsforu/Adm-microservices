package com.cts.flight.service;

import com.cts.flight.entity.BookingRecord;
import com.cts.flight.entity.Passenger;

public interface BookingService {

	Passenger bookFlight(Passenger passenger, long id, int numberofPassengers);

	BookingRecord getBookingInfo(long bookingId);

}