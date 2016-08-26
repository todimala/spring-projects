package com.github.todimala.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/*
 * Customer Entity to be stored in the DB
 */
@Entity
@Table(name = "Customer")
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "customerSeq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "customerSeq", sequenceName = "CUSTOMER_SEQ", allocationSize=1)
	@Column(name = "ID")
	private long customerId;

	@Column (name = "FIRST_NAME")
	private String firstName;
	
	@Column (name = "LAST_NAME")
	private String lastName;

	@Column (name = "CUSTOMER_EMAIL1")
	private String customerEmail1;
	
	@Column (name = "CUSTOMER_EMAIL2")
	private String customerEmail2;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "customer")
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
