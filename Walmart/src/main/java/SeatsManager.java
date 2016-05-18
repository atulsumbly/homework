//package com.java;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class SeatsManager {
	private Integer currSeatHoldId;
	private Map<Integer, SeatHold> seatHoldMap;
	private Map<String, SeatHold> seatReserveMap;
	private Map<Integer, Integer> availabilityMap;
	private final Integer TIMEDIFF = 10000;
	
	public SeatsManager(HashMap<Integer, Seating> seat){
		currSeatHoldId = 0;
		seatHoldMap = new HashMap<Integer, SeatHold>();
		seatReserveMap = new HashMap<String, SeatHold>();
		
		availabilityMap = new HashMap<Integer, Integer>();
		Iterator<Entry<Integer, Seating>> iterator = seat.entrySet().iterator();
		while(iterator.hasNext()){
			Map.Entry<Integer, Seating> pair = (Map.Entry<Integer, Seating>) iterator.next();
			availabilityMap.put(pair.getKey(), (pair.getValue().getRows()*pair.getValue().getSeats()));
		}
	}
	
	public int reserveSeats(int seatHoldId, String customerEmail){
		SeatHold sHold = seatHoldMap.get(seatHoldId);
		if(!sHold.getCustomerEmail().equals(customerEmail)) return -1;
		seatReserveMap.put(customerEmail, sHold);
		seatHoldMap.remove(seatHoldId);
		return 0;
	}
	
	public SeatHold holdSeats(String customerEmail, Integer venueId, Integer numSeats){
		SeatHold sHold = new SeatHold();
		sHold.setCustomerEmail(customerEmail);
		sHold.setVenueId(venueId);
		sHold.setNumSeats(numSeats);
		sHold.setSeatHoldId(++currSeatHoldId);
		sHold.setDate(new Date());
		seatHoldMap.put(currSeatHoldId, sHold);
		removeAvailability(venueId, numSeats);
		return sHold;
	}
	
	private void addAvailability(int venueId, int numSeats){
		Integer seatsAvailable = availabilityMap.get(venueId);
		seatsAvailable += numSeats;
		availabilityMap.put(venueId, seatsAvailable);
	}
	
	private void removeAvailability(int venueId, int numSeats){
		Integer seatsAvailable = availabilityMap.get(venueId);
		seatsAvailable -= numSeats;
		availabilityMap.put(venueId, seatsAvailable);
	}
	
	public Integer getNumSeatsAvailable(Integer venueId){
		return availabilityMap.get(venueId);
		
	}
	
	public void refreshHoldSeats(){
		Iterator<Entry<Integer, SeatHold>> iterator = seatHoldMap.entrySet().iterator();
		while(iterator.hasNext()){
			Map.Entry<Integer, SeatHold> pair = (Map.Entry<Integer, SeatHold>) iterator.next();
			//System.out.println((new Date()).getTime()  - pair.getValue().getDate().getTime());
			if((new Date()).getTime()  - pair.getValue().getDate().getTime() >  TIMEDIFF){
				addAvailability(pair.getValue().getVenueId(), pair.getValue().getNumSeats());
				seatHoldMap.remove(pair.getKey());
			}
		}
	}
}
