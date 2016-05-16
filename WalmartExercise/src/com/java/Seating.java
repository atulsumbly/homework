package com.java;

public class Seating {
	private String levelName;
	private Double price;
	private int rows;
	private int seats;
	
	public String getLevelName() {
		return levelName;
	}
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}

	public Seating(String levelname,Double p,int row,int seat){
		this.levelName=levelname;
		this.price=p;
		this.rows=row;
		this.seats=seat;
	}
}