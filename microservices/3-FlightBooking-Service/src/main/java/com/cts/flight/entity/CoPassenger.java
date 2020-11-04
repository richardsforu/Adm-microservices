package com.cts.flight.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CoPassenger {
	@Id
	@GeneratedValue
	private long copassengerId;
	private String firstName;
	private String lastName;
	private String gender;

	public CoPassenger(long copassengerId, String firstName, String lastName, String gender) {
		super();
		this.copassengerId = copassengerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
	}

}
