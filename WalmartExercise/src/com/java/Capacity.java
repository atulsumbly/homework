package com.java;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;

public class Capacity {
	private HashMap<Integer, Seating> seat;
	SeatsManager sManager;

	public Capacity() {
		seat = new HashMap<Integer, Seating>();
		seat.put(1, new Seating("Orchestra ", 100.00, 25, 50));
		seat.put(2, new Seating("Main ", 75.00, 20, 100));
		seat.put(3, new Seating("Balcony 1 ", 50.00, 15, 100));
		seat.put(4, new Seating("Balcony 2 ", 40.00, 15, 100));
		sManager = new SeatsManager(seat);
	}

	public int numSeatsAvailable(Optional<Integer> venueLevel) {
		sManager.refreshHoldSeats();
		int vLevel = 0;
		if (venueLevel != null) {
			vLevel = venueLevel.get();
		}
		return sManager.getNumSeatsAvailable(vLevel);
	}
	
	public String levelName(Optional<Integer> venueLevel){
		return seat.get(venueLevel.get()).getLevelName();
		
	}

	public SeatHold findAndHoldSeats(int numSeats, Optional<Integer> minLevel, Optional<Integer> maxLevel,String customerEmail) {
		int startLevel = minLevel.get() == null ? 1 : minLevel.get();
		int endLevel = maxLevel.get() == null ? 4 : maxLevel.get();
		for (int i = startLevel; i <= endLevel; i++) {
			sManager.refreshHoldSeats();
			int n = sManager.getNumSeatsAvailable(i);
			
			if (n <= numSeats)
				continue;
			
			SeatHold sHold = sManager.holdSeats(customerEmail, i, numSeats);
			return sHold;
		}
		return null;
	}

	public String reserveSeats(int seatHoldId, String customerEmail) {
		int ret = sManager.reserveSeats(seatHoldId, customerEmail);
		String rCode=seatHoldId+""+customerEmail;
		return ret == -1 ? "Error" : ("Tickets booked successfully\n"+"unique ID for booking is "+rCode);
	}

	public void display() {
		System.out.println("Venue Capacity:");

		Iterator<Map.Entry<Integer, Seating>> iterator = seat.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<Integer, Seating> entry = iterator.next();
			System.out.println("LevelID = " + entry.getKey() + ", LevelName = " + entry.getValue().getLevelName()
					+ ", Price = " + entry.getValue().getPrice() + ", Rows = " + entry.getValue().getRows()
					+ ", Seats = " + entry.getValue().getSeats());
		}
	}
}
