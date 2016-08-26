package com.github.todimala.utilities;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.ResourceSupport;

import com.github.todimala.controller.CustomerController;
import com.github.todimala.entity.Customer;

public class CustomerResource extends ResourceSupport {

	private final Customer customer;
	public CustomerResource(Customer customer) {
		Long custId = customer.getCustomerId();
		this.customer = customer;
		customer.getCustomerAddress();
		this.add(linkTo(methodOn(CustomerController.class).getCustomerByCustomerId(custId)).withSelfRel());
		this.add(linkTo(methodOn(CustomerController.class).getCustomerAddress(custId)).withSelfRel());
		this.add(linkTo(methodOn(CustomerController.class).addCustomerAddress(custId, customer.getCustomerAddress())).withSelfRel());
	}
	
	public Customer getCustomer() {
		return this.customer;
	}
}
