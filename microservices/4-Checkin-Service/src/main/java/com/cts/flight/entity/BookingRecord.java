package com.cts.flight.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BookingRecord {
	
	@Id
	@GeneratedValue
	private long bookingId;
	private String flightNumber;
	private String origin;
	private String destination;
	private double fare;
	private LocalDate flightDate;
	private LocalTime flightTime;
	private String status;
	private LocalDateTime bookingDate;
	
	public BookingRecord() {
		// TODO Auto-generated constructor stub
	}
	
	
	public BookingRecord(String flightNumber, String origin, String destination, double fare, LocalDate flightDate,
			LocalTime flightTime, String status, LocalDateTime bookingDate) {
		super();
		this.flightNumber = flightNumber;
		this.origin = origin;
		this.destination = destination;
		this.fare = fare;
		this.flightDate = flightDate;
		this.flightTime = flightTime;
		this.status = status;
		this.bookingDate = bookingDate;
	}



	public long getBookingId() {
		return bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public LocalDate getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(LocalDate flightDate) {
		this.flightDate = flightDate;
	}

	public LocalTime getFlightTime() {
		return flightTime;
	}

	public void setFlightTime(LocalTime flightTime) {
		this.flightTime = flightTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDateTime bookingDate) {
		this.bookingDate = bookingDate;
	}

}
