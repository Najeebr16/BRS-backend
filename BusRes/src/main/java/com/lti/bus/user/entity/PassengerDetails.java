package com.lti.bus.user.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class PassengerDetails {
	@Id
	@GeneratedValue
	private int passengerid;
	
	private String fullname;
	
	private String gender;
	
	private int age;
	
	@ManyToOne
	@JoinColumn(name="id")
	    private UserRegistration userreg;

	private int seatNumber;

	

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public UserRegistration getUserreg() {
		return userreg;
	}


	public void setUserreg(UserRegistration userreg) {
		this.userreg = userreg;
	}

	public int getPassengerid() {
		return passengerid;
	}

	public void setPassengerid(int passengerid) {
		this.passengerid = passengerid;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "PassengerDetails [passengerid=" + passengerid + ", fullname=" + fullname + ", gender=" + gender
				+ ", age=" + age + ", userreg=" + userreg + ", seatNumber=" + seatNumber + "]";
	}
	
	
}
