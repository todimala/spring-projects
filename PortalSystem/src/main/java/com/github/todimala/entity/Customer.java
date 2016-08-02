package com.github.todimala.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.hateoas.ResourceSupport;

/*
 * Customer Entity to be stored in the DB
 */
@Entity
@Table(name = "Customer")
public class Customer {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private long customerId;

	private String firstName;
	private String lastName;
	private String customerEmail1;
	private String customerEmail2;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "customer")
	//@JoinColumn(name="ADDRESS_ID")
	private Address customerAddress;
	
	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public Customer() {} // For JPA
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCustomerEmail1() {
		return customerEmail1;
	}
	public void setCustomerEmail1(String customerEmail1) {
		this.customerEmail1 = customerEmail1;
	}
	public String getCustomerEmail2() {
		return customerEmail2;
	}
	public void setCustomerEmail2(String customerEmail2) {
		this.customerEmail2 = customerEmail2;
	}
	public Address getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(Address customerAddress) {
		this.customerAddress = customerAddress;
	}
	public long getCustomerId() {
		return customerId;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", customerEmail1=" + customerEmail1 + ", customerEmail2=" + customerEmail2 + ", customerAddress="
				+ customerAddress + "]";
	}
	
}
