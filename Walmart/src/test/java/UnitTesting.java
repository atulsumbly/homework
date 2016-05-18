//package com.unitTest;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Test;

public class UnitTesting {

	@Test
	public void test1() {
		Capacity c=new Capacity();
		
		//fail("Not yet implemented");
		assertEquals(c.numSeatsAvailable(Optional.of(1)), 1250);
		assertEquals(c.numSeatsAvailable(Optional.of(2)), 2000);
		assertEquals(c.numSeatsAvailable(Optional.of(3)), 1500);
		assertEquals(c.numSeatsAvailable(Optional.of(4)), 1500);
	}
	@Test
public void test2() {
		Capacity c=new Capacity();
		Integer check = 100;
		assertEquals( c.findAndHoldSeats(100, Optional.of(1), Optional.of(2), "x").getNumSeats(), check);
		assertEquals( c.findAndHoldSeats(100, Optional.of(2), Optional.of(4), "x").getNumSeats(), check);
		assertEquals( c.findAndHoldSeats(100, Optional.of(1), Optional.of(4), "x").getNumSeats(), check);
		assertEquals( c.findAndHoldSeats(100, Optional.of(1), Optional.of(3), "x").getNumSeats(), check);
	}

	@Test
public void test3() {
		Capacity c=new Capacity();
		SeatHold seatObj = c.findAndHoldSeats(100, Optional.of(1), Optional.of(2), "x");
		String rCode=seatObj.getSeatHoldId()+""+seatObj.getCustomerEmail();
	assertEquals(c.reserveSeats(seatObj.getSeatHoldId(), seatObj.getCustomerEmail()), ("Tickets booked successfully\n"+"unique ID for booking is "+rCode));
}

	@Test
public void test4() {
	
		Capacity c=new Capacity();
			for(int i=1;i<=4;i++){
			SeatHold seatObj = c.findAndHoldSeats(100, Optional.of(i), Optional.of(i), "x");
			int AvailseatCheck=c.numSeatsAvailable(Optional.of(i));
			//System.out.println(AvailseatCheck);
			assertEquals(c.numSeatsAvailable(Optional.of(i)), AvailseatCheck);
}
	}
	@Test
	public void test5(){
		Capacity c=new Capacity();
		
	}

}
