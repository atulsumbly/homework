package com.java;

import java.util.*;
public class SeatSelection{
	public void initialArray(){
	int[] orchestra=new int[25];
	int[] main=new int[20];
	int[] balcony1=new int[15];
	int[] balcony2=new int[15];
	
	for(int i=0;i<orchestra.length;i++){
		orchestra[i]=50;
	}
	System.out.println("total seats in orchestra");
	for(int i=0;i<main.length;i++){
		main[i]=100;
	}
	for(int i=0;i<balcony1.length;i++){
		balcony1[i]=100;
	}
	for(int i=0;i<balcony2.length;i++){
		balcony2[i]=100;
	}
	
	Scanner s=new Scanner(System.in);
	System.out.println("give seats to book");
	int seat=s.nextInt();
	
}
	}