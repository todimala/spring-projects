package com.github.todimala.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Address")
public class Address {
	
	@Id
	@GeneratedValue
	@Column(name = "ADDRESS_ID")
	private long addressId;
	
	@JsonIgnore
	@OneToOne 
	@JoinColumn(name="CUSTOMER_ID", referencedColumnName = "ID")
	private Customer customer;
	private String streetAddress1;
	private String streetAddress2;
	private String city;
	private String country;
	private String state;
	
	public Address() {
	}

	public long getAddressId() {
		return addressId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getStreetAddress1() {
		return streetAddress1;
	}
	public void setStreetAddress1(String streetAddress1) {
		this.streetAddress1 = streetAddress1;
	}
	public String getStreetAddress2() {
		return streetAddress2;
	}
	public void setStreetAddress2(String streetAddress2) {
		this.streetAddress2 = streetAddress2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void getCustomerId() {
		this.customer.getCustomerId();
	}
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", customer=" + customer + ", streetAddress1=" + streetAddress1
				+ ", streetAddress2=" + streetAddress2 + ", city=" + city + ", country=" + country + ", state=" + state
				+ "]";
	}

}
