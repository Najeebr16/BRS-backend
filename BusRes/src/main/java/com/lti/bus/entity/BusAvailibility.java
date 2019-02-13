package com.lti.bus.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Bus_Records")
public class BusAvailibility {
	@Id
	private int bus_id;
	private String busname;
	private String source;
	private String destination;
	private double Tfare;
	
	@OneToMany(mappedBy="busAvaibility")
	private Set<BookingRecords> busrecord;
	

	public Set<BookingRecords> getBusrecord() {
		return busrecord;
	}
	public void setBusrecord(Set<BookingRecords> busrecord) {
		this.busrecord = busrecord;
	}
	public int getBus_id() {
		return bus_id;
	}
	public void setBus_id(int bus_id) {
		this.bus_id = bus_id;
	}
	public String getBusname() {
		return busname;
	}
	public void setBusname(String busname) {
		this.busname = busname;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public double getTfare() {
		return Tfare;
	}
	public void setTfare(double tfare) {
		Tfare = tfare;
	}
	
	
}
