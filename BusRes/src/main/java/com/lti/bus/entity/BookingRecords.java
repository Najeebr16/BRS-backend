package com.lti.bus.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="booking_details")
public class BookingRecords {
	
	@Id
	@GeneratedValue
	private int bookId; 
	
@ManyToOne
@JoinColumn(name="id")
	private BusRegistration busRegistration;

@ManyToOne
@JoinColumn(name="bus_id")
    private BusAvailibility busAvaibility;
 	
//	private String mail=busRegistration.getEmail();
	
	private Date dateOfBooking;
	
	private int NumberOfSeats;
	
	private Double TotalPrice;


		public BusRegistration getBusRegistration() {
		return busRegistration;
	}
	
	public void setBusRegistration(BusRegistration busRegistration) {
		this.busRegistration = busRegistration;
	}
	
	public BusAvailibility getBusAvaibility() {
		return busAvaibility;
	}
	
	public void setBusAvaibility(BusAvailibility busAvaibility) {
		this.busAvaibility = busAvaibility;
	}

	
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}


	public Date getDateOfBooking() {
		return dateOfBooking;
	}

	public void setDateOfBooking(Date dateOfBooking) {
		this.dateOfBooking = dateOfBooking;
	}

	public int getNumberOfSeats() {
		return NumberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		NumberOfSeats = numberOfSeats;
	}

  public Double getTotalPrice() {
		return TotalPrice;
	}

	public void setTotalPrice(int numberOfseats) {
		TotalPrice = numberOfseats * busAvaibility.getTfare();
	}

}
