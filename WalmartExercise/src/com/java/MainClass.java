package com.java;
import java.util.*;

public class MainClass {

	public static void main(String[] args) {
		int levelID;
		System.out.println("Welcome to ticket system \n Press 1 for venue capacity \n 0 to exit");
		boolean run=true;
		while (run)
		{
		Scanner s=new Scanner(System.in);
		int options=s.nextInt();
		
			switch (options){
			case 0:
				System.out.println("program exits");
				run=false;
				break;
			case 1:
				Capacity c=new Capacity();
				c.display();
				System.out.println("Enter the levelID to find available seat in a level\n 1-Orchestra\n 2-Main\n 3-Balcony 1\n 4-Balcony 2");
				boolean seatFind=true;
				while(seatFind==true){
				int i=s.nextInt();
				System.out.println(c.availableSeatsLevel(i));
				System.out.println("Do you want to check seat availability for another level (Y/N)");
				char cont=s.next().charAt(0);
				if(cont=='Y' ||cont=='y'){
					seatFind=true;
				}
				else if (cont=='N'||cont=='n'){
					seatFind=false;
				}else
				{System.out.println("invalid option");}
				}
				run=true;
				break;
				
			case 2:
				
				
			default:
					System.out.println("Invalid input, try again");
					run=true;
					break;
			}
			
		}
	}

}
