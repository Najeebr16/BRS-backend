package com.lti.bus.user.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Bus_Records")
public class BusAvailibility {
	
	@Id
	@GeneratedValue
	private int bus_id;
	private String busname;
	private String source;
	private String destination;
	private double Tfare;
	private String day;
	private String time;
	private String type;
	private String timerange;
	
	@OneToMany(mappedBy="busAvaibility")
	private Set<BookingRecords> busrecord;
	
	public String getTimerange() {
		return timerange;
	}
	public void setTimerange(String timerange) {
		this.timerange = timerange;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
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
	@Override
	public String toString() {
		return "BusAvailibility [bus_id=" + bus_id + ", busname=" + busname + ", source=" + source + ", destination="
				+ destination + ", Tfare=" + Tfare + ", day=" + day + ", time=" + time + ", type=" + type
				+ ", timerange=" + timerange + ", busrecord=" + busrecord + "]";
	}	
	
}
