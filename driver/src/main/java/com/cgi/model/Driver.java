package com.cgi.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Driver {

	
	@Id
	private int driverId;
	private String firstName;
	private long telephonenumber;
	private String address;
	private String city;
	private String enginesize;
	private String quoteamount;
	
	
	
	public Driver() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Driver(int driverId, String firstName, long telephonenumber, String address, String city, String enginesize,
			String quoteamount) {
		super();
		this.driverId = driverId;
		this.firstName = firstName;
		this.telephonenumber = telephonenumber;
		this.address = address;
		this.city = city;
		this.enginesize = enginesize;
		this.quoteamount = quoteamount;
	}
	public int getDriverId() {
		return driverId;
	}
	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public long getTelephonenumber() {
		return telephonenumber;
	}
	public void setTelephonenumber(long telephonenumber) {
		this.telephonenumber = telephonenumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEnginesize() {
		return enginesize;
	}
	public void setEnginesize(String enginesize) {
		this.enginesize = enginesize;
	}
	public String getQuoteamount() {
		return quoteamount;
	}
	public void setQuoteamount(String quoteamount) {
		this.quoteamount = quoteamount;
	}
	@Override
	public String toString() {
		return "Driver [driverId=" + driverId + ", firstName=" + firstName + ", telephonenumber=" + telephonenumber
				+ ", address=" + address + ", city=" + city + ", enginesize=" + enginesize + ", quoteamount="
				+ quoteamount + "]";
	}
	
	
}
