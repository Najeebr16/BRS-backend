package com.lti.bus.user.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="booking_details")
public class BookingRecords {
	
	@Id
	@GeneratedValue
	private int bookId; 
	
@ManyToOne
@JoinColumn(name="id")
	private UserRegistration userRegistration;

@ManyToOne
@JoinColumn(name="bus_id")
    private BusAvailibility busAvaibility;
 	
//	private String mail=busRegistration.getEmail();
	
	@Temporal(TemporalType.DATE)
	private Date dateOfBooking;
	
	private int NumberOfSeats;
	
	private Double TotalPrice;


		public UserRegistration getUserRegistration() {
		return userRegistration;
	}
	
	public void setUserRegistration(UserRegistration userRegistration) {
		this.userRegistration = userRegistration;
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

public void setTotalPrice(Double totalPrice) {
	TotalPrice = totalPrice;
}

	

}
