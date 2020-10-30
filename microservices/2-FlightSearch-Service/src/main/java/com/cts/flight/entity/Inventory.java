package com.cts.flight.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Inventory {
	@Id
	@GeneratedValue
	private long invId;
	private int count;

	

	public long getInvId() {
		return invId;
	}

	public void setInvId(long invId) {
		this.invId = invId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
