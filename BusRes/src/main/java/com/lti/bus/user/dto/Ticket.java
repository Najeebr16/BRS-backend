package com.lti.bus.user.dto;

public class Ticket {
	
	private int busid;
	private int userid;
	private  int seats;
	private double price;
	public Ticket(int busid, int userid, int seats, double price) {
		super();
		this.busid = busid;
		this.userid = userid;
		this.seats = seats;
		this.price = price;
	}
	public Ticket() {
		super();
	}
	public int getBusid() {
		return busid;
	}
	public void setBusid(int busid) {
		this.busid = busid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	

}
