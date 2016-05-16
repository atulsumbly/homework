package com.java;

import java.util.*;

public class Capacity {
	private HashMap<String,Integer> quantities;
	private HashMap<Integer,Seating> seat;

	public Capacity() {
		seat=new HashMap<Integer,Seating>();
		seat.put(1,new Seating("Orchestra ", 100.00, 25, 50));
		seat.put(2,new Seating("Main ", 75.00, 20, 100));
		seat.put(3,new Seating("Balcony 1 ", 50.00, 15, 100));
		seat.put(4,new Seating("Balcony 2 ", 40.00, 15, 100));
		
	}
	public int availableSeatsLevel(int levelName) {
		
		Seating s;
		int rows;
		int seats;
		 
		if (seat.containsKey(levelName)) {
			s=seat.get(levelName);
			rows=s.getRows();
			seats=s.getSeats();
			System.out.println(s.getLevelName());
			return rows*seats;
		}
			else {
				System.out.println("undefined level");
				return 0;
			}
		}

	
//	public Seating get(String levelName) {
//		if (availableSeats(levelName, 1)) {
//			quantities.put(levelName, quantities.get(levelName) - 1);
//			return seat.get(levelName);
//			
//		}
//		else {
//			throw new RuntimeException();
//		}
//	}

	public void display() {
		System.out.println("Venue Capacity:");
		
		Iterator<Map.Entry<Integer, Seating>> iterator = seat.entrySet().iterator();
		  while(iterator.hasNext())
		 {
			  Map.Entry<Integer, Seating> entry = iterator.next();
			  System.out.println("LevelID = " + entry.getKey() 
			  + ", LevelName = " + entry.getValue().getLevelName()
			  + ", Price = " + entry.getValue().getPrice()
			  + ", Rows = " + entry.getValue().getRows()
			  + ", Seats = " + entry.getValue().getSeats());
		}
	}
	
	

}
