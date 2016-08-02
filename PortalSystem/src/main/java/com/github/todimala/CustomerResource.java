package com.github.todimala;

import com.github.todimala.controller.CustomerController;
import com.github.todimala.entity.Address;
import com.github.todimala.entity.Customer;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.hateoas.ResourceSupport;

public class CustomerResource extends ResourceSupport {

	private final Customer customer;
	private final Address address;
	
	public CustomerResource(Customer customer) {
		Long custId = customer.getCustomerId();
		this.customer = customer;
		this.address = customer.getCustomerAddress();
		this.add(linkTo(methodOn(CustomerController.class).getCustomerByCustomerId(custId)).withSelfRel());
		this.add(linkTo(methodOn(CustomerController.class).getCustomerAddress(custId)).withSelfRel());
		this.add(linkTo(methodOn(CustomerController.class).addCustomerAddress(custId, customer.getCustomerAddress())).withSelfRel());
	}
	
	public Customer getCustomer() {
		return this.customer;
	}
}
