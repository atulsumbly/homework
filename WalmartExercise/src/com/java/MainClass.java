package com.java;
import java.util.Optional;
import java.util.Scanner;

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
					//minLevel=s.nextInt();
					minLevel=null;
					minLevel=(Optional.of(minLevel)== null ? 1 : minLevel);
					System.out.println("Enter the max level for capacity");
					maxLevel=s.nextInt();
					maxLevel=(Optional.of(maxLevel)== null ? 4 : maxLevel);
					for(i=minLevel;i<=maxLevel;i++){
					System.out.println("Available Seat in "+c.levelName(Optional.of(i))+" "+c.numSeatsAvailable(Optional.of(i)));	
					}
					run=true;
					break;
					
					
				case 2:
					int numSeats;
					String customerEmail;
					System.out.println("Hold seats");
					System.out.println("Enter number of seats to hold");
					numSeats=s.nextInt();
					System.out.println("Enter the min level");
					minLevel=s.nextInt();;
					System.out.println("Enter the Max Level");
					maxLevel=s.nextInt();
					System.out.println("Enter the email");
					customerEmail=s.next();
					sHold = c.findAndHoldSeats(numSeats, Optional.of(minLevel),Optional.of(maxLevel), customerEmail);
					System.out.println(sHold.toString());
					System.out.println(c.numSeatsAvailable(Optional.of(minLevel)));
					run=true;
					break;
					
				case 3:
					System.out.println("Reserve Seats");
					System.out.println(c.reserveSeats(sHold.getSeatHoldId(), sHold.getCustomerEmail()));
					
				default:
						System.out.println("Invalid input, try again");
						run=true;
						break;
				}
			}catch(Exception e){
				System.out.println("enter numeric Option ");
				run=true;
			}
		}
			
				
	}
}


