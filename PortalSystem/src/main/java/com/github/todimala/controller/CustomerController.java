package com.github.todimala.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.todimala.entity.Customer;
import com.github.todimala.entity.CustomerRepository;

@RestController
@RequestMapping("/Customer")
public class CustomerController {

	private final CustomerRepository customerRepository;

	@Autowired
	CustomerController(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	@RequestMapping(path="/{lastName}/{firstName}", method = RequestMethod.GET)
	public List<Customer> getCustomerByName(@PathVariable String lastName, @PathVariable String firstName) {
		System.out.println(String.format("getCustomerByName: Input: firstName = %s, lastName=%s", firstName, lastName));
		return this.customerRepository.findByLastNameAndFirstName(firstName, lastName);
	}
	@RequestMapping(path="/{lastName}", method = RequestMethod.GET)
	public List<Customer> getCustomerByLastName(@PathVariable String lastName) {
		System.out.println(String.format("getCustomerByLastName: Input: lastName=%s", lastName));
		return this.customerRepository.findByLastName(lastName);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Customer addCustomer(@RequestBody Customer customer) {
		return this.customerRepository.save(new Customer(customer.getFirstName(), customer.getLastName()));
	}
}
