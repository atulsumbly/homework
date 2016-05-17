package com.java;

import java.util.Date;

public class SeatHold {
	private Integer seatHoldId;
	private String customerEmail;
	private Integer venueId;
	private Integer numSeats;
	private Date date;
	
	public SeatHold(){
	}
	
	public SeatHold(int seatID, String email, int venueID,int numSeats, Date date){
		this.seatHoldId=seatID;
		this.customerEmail=email;
		this.venueId=venueID;
		this.numSeats=numSeats;
		this.date=date;
	}
	public Integer getSeatHoldId() {
		return seatHoldId;
	}
	public void setSeatHoldId(Integer seatHoldId) {
		this.seatHoldId = seatHoldId;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public Integer getVenueId() {
		return venueId;
	}
	public void setVenueId(Integer venueId) {
		this.venueId = venueId;
	}
	public Integer getNumSeats() {
		return numSeats;
	}
	public void setNumSeats(Integer numSeats) {
		this.numSeats = numSeats;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public String toString(){
		return String.format("\nSeatHoldId - " + getSeatHoldId() + 
				"\nCustomer Email - " + getCustomerEmail() + 
				"\nVenue Id - " + getVenueId() + 
				"\nNum Seats - " + getNumSeats() + 
				"\nDate - " + getDate() + "\n");
	}
}
