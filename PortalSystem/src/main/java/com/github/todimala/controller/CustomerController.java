package com.github.todimala.controller;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.todimala.entity.Address;
import com.github.todimala.entity.AddressRepository;
import com.github.todimala.entity.Customer;
import com.github.todimala.entity.CustomerRepository;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	private final CustomerRepository customerRepository;
	private final AddressRepository addressRepository;
	final static Logger LOGGER = Logger.getLogger(CustomerController.class);

	@Autowired
	CustomerController(CustomerRepository customerRepository, AddressRepository addressRepository) {
		this.customerRepository = customerRepository;
		this.addressRepository = addressRepository;
	}
	
	@RequestMapping(path="/lastname/{lastName}", method = RequestMethod.GET)
	public List<Customer> getCustomerByLastName(@PathVariable String lastName) {
		LOGGER.info(String.format("getCustomerByLastName: Input: lastName=%s", lastName));
		return this.customerRepository.findByLastName(lastName);
	}
	@RequestMapping(path="/email", method = RequestMethod.GET)
	public Customer getCustomerByEmail(@RequestParam(value="email") String customerEmail1) {
		LOGGER.info("Find customer by email: " + customerEmail1);
		Optional<Customer> cust = this.customerRepository.findByCustomerEmail1(customerEmail1);
		if (cust.isPresent()) 
			return cust.get();
		return null;
	}
	@RequestMapping(path="/email/{customerEmail1}", method = RequestMethod.GET)
	public Customer getCustomerByEmailPathVariable(@PathVariable String customerEmail1) {
		LOGGER.info("Find customer by email: " + customerEmail1);
		Optional<Customer> cust = this.customerRepository.findByCustomerEmail1(customerEmail1);
		if (cust.isPresent()) 
			return cust.get();
		return null;
	}
	@RequestMapping(path="/{lastName}/{firstName}", method = RequestMethod.GET)
	public List<Customer> getCustomerByName(@PathVariable String lastName, @PathVariable String firstName) {
		LOGGER.info(String.format("getCustomerByName: Input: firstName = %s, lastName=%s", firstName, lastName));
		return this.customerRepository.findByLastNameAndFirstName(firstName, lastName);
	}
	@RequestMapping(path="/{custId}", method = RequestMethod.GET)
	public Customer getCustomerByCustomerId(@PathVariable Long custId) {
		LOGGER.info("Find customer by Id: " + custId);
		return this.customerRepository.findOne(custId);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Customer addCustomer(@RequestBody Customer customer) {
		LOGGER.info("Adding Customer: " + customer.toString());
		return this.customerRepository.save(customer);
	}
	
	@RequestMapping(path="/address", method = RequestMethod.POST)
	public Address addCustomerAddress(@RequestBody Address address) {
		LOGGER.info("Adding Customer Address: " + address.toString());
		return this.addressRepository.save(address);
	}
}
