package com.cts.flight.service;

import com.cts.flight.entity.CheckIn;

public interface CheckinService {

	CheckIn checkIn(long bookingId);

	CheckIn getCheckInInfo(long bookingId);

}