package com.lti.bus.user.entity;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="User_Reg")
public class UserRegistration {
	@Id
	@GeneratedValue
	private int id;
   private String email;
   private String fullname;
	private String gender;
	private String mobile;
	private String address;
	private String dateOfBirth;
	private String password;
	
	@OneToMany(mappedBy="userRegistration")
	private Set<BookingRecords> registration;
	
	@OneToMany(mappedBy="userreg")
	private Set<PassengerDetails> passdetails;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<BookingRecords> getRegistration() {
		return registration;
	}
	public void setRegistration(Set<BookingRecords> registration) {
		this.registration = registration;
	}

	
 
}
