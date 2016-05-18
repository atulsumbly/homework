package com.java;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class MainClass {
	public static void main(String[] args) {
			
		Capacity c=new Capacity();
		SeatHold sHold=null;
		c.display();
		System.out.println("Welcome to ticket system \n Press 1 for venue capacity \n press 2 to hold seats \n press 3 to reserve \n 0 to exit");
		boolean run=true;
		Integer minLevel;
		Integer maxLevel;
		
		while (run){
			try{
				Scanner s=new Scanner(System.in);
				int options=s.nextInt();
				switch (options){
				case 0:
					System.out.println("program exits");
					run=false;
					break;
					
				case 1:
					int i;
					System.out.println("Enter the min level for capacity");
					minLevel=s.nextInt();
					minLevel=(Optional.of(minLevel)== null ? 1 : minLevel);
					System.out.println("Enter the max level for capacity");
					maxLevel=s.nextInt();
					maxLevel=(Optional.of(maxLevel)== null ? 4 : maxLevel);
					for(i=minLevel;i<=maxLevel;i++){
					System.out.println("Available Seat in "+c.levelName(Optional.of(i))+" "+c.numSeatsAvailable(Optional.of(i))+"\n");	
					}
					run=true;
					System.out.println(" Press 1 for venue capacity \n press 2 to hold seats \n press 3 to reserve \n 0 to exit");
					break;
						
						
				case 2:
					int numSeats;
					String customerEmail;
					System.out.println("Search and Hold seats");
					System.out.println("Enter number of seats to hold");
					numSeats=s.nextInt();
					System.out.println("Enter the min level");
					minLevel=s.nextInt();;
					System.out.println("Enter the Max Level");
					maxLevel=s.nextInt();
					System.out.println("Enter the email");
					customerEmail=s.next();
					sHold = c.findAndHoldSeats(numSeats, Optional.of(minLevel),Optional.of(maxLevel), customerEmail);
					if (sHold==null){
						System.out.println("desired seats not available");
					}else
						System.out.println(sHold.toString());
					for(minLevel=minLevel;minLevel<=maxLevel;minLevel++){
					System.out.println("Available Seat in "+c.levelName(Optional.of(minLevel))+" "+c.numSeatsAvailable(Optional.of(minLevel)));
					}
					run=true;
					System.out.println("\nPress 1 for venue capacity \n press 2 to hold seats \n press 3 to reserve \n 0 to exit");
					break;
						
				case 3:
					System.out.println("Reserve hold Seats");
					System.out.println(c.reserveSeats(sHold.getSeatHoldId(), sHold.getCustomerEmail()));
					System.out.println("Ticket is booked by cust email: "+sHold.getCustomerEmail());
					System.out.println("Available Seat in "+c.levelName(Optional.of(sHold.getVenueId()))+" "+c.numSeatsAvailable(Optional.of(sHold.getVenueId())));
					run=true;
					System.out.println("Press 1 for venue capacity \n press 2 to hold seats \n press 3 to reserve \n 0 to exit");
					break;
				
				default:
						System.out.println("Invalid input, try again");
						run=true;
						System.out.println("\nPress 1 for venue capacity \n press 2 to hold seats \n press 3 to reserve \n 0 to exit");
						break;
				}
			}
			catch ( Exception exc) {
				System.out.println("invalid option");	
				System.out.println("Press 1 for venue capacity \n press 2 to hold seats \n press 3 to reserve \n 0 to exit");
				run=true;
			}
			
		}
	}
}


