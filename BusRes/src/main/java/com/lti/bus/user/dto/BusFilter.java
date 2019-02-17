package com.lti.bus.user.dto;

public class BusFilter {
	private String source;
	private String destination;
	private String type;
	private String timerange;
	
public BusFilter() {
	// TODO Auto-generated constructor stub
}
	public BusFilter(String source, String destination, String type, String timerange) {
		super();
		this.source = source;
		this.destination = destination;
		this.type = type;
		this.timerange = timerange;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTimerange() {
		return timerange;
	}

	public void setTimerange(String timerange) {
		this.timerange = timerange;
	}

	
	
}
