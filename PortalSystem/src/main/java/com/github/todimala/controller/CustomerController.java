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
import com.github.todimala.entity.ResourceType;
import com.github.todimala.utilities.CustomerResource;

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
	
	
	@RequestMapping(path="/list", method = RequestMethod.GET)
	public List<Customer> listAll() {
		LOGGER.info("List all Customers");
		return this.customerRepository.findAll();
	}
	
	@RequestMapping(path="/lastname/{lastName}", method = RequestMethod.GET)
	public List<Customer> getCustomerByLastName(@PathVariable String lastName) {
		LOGGER.info(String.format("getCustomerByLastName: Input: lastName=%s", lastName));
		return this.customerRepository.findByLastName(lastName);
	}
	@RequestMapping(path="/email", method = RequestMethod.GET)
	public CustomerResource getCustomerByEmail(@RequestParam(value="email") String customerEmail1) {
		LOGGER.info("Find customer by email: " + customerEmail1);
		Optional<Customer> cust = this.customerRepository.findByCustomerEmail1(customerEmail1);
		if (cust.isPresent()) 
			return new CustomerResource(cust.get());
		return null;
	}
	@RequestMapping(path="/email/{customerEmail1}", method = RequestMethod.GET)
	public CustomerResource getCustomerByEmailPathVariable(@PathVariable String customerEmail1) {
		LOGGER.info("Find customer by email: " + customerEmail1);
		Optional<Customer> cust = this.customerRepository.findByCustomerEmail1(customerEmail1);
		if (cust.isPresent()) 
			return new CustomerResource(cust.get());
		return null;
	}
	@RequestMapping(path="/{lastName}/{firstName}", method = RequestMethod.GET)
	public List<Customer> getCustomerByName(@PathVariable String lastName, @PathVariable String firstName) {
		LOGGER.info(String.format("getCustomerByName: Input: firstName = %s, lastName=%s", firstName, lastName));
		return this.customerRepository.findByLastNameAndFirstName(firstName, lastName);
	}
	@RequestMapping(path="/{custId}", method = RequestMethod.GET)
	public CustomerResource getCustomerByCustomerId(@PathVariable Long custId) {
		LOGGER.info("Find customer by Id: " + custId);
		Customer cust = this.customerRepository.findOne(custId);
		return new CustomerResource(cust);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public CustomerResource addCustomer(@RequestBody Customer customer) {
		LOGGER.info("Adding Customer: " + customer.toString());
		return new CustomerResource(this.customerRepository.save(customer));
	}
	
	@RequestMapping(path="/{custId}/address", method = RequestMethod.POST)
	public Address addCustomerAddress(@PathVariable Long custId, @RequestBody Address address) {
		LOGGER.info(String.format("Customer Id %s: Adding Address %s",  custId, address.toString()));
		Customer cust = this.customerRepository.findOne(custId);
		address.setCustomer(cust);
		return this.addressRepository.save(address);
	}
	
	@RequestMapping(path="/{custId}/address", method = RequestMethod.GET)
	public Address getCustomerAddress(@PathVariable Long custId) {
		LOGGER.info(String.format("Customer Id %s: Fetching Address",  custId));
		Customer cust = this.customerRepository.findOne(custId);
		return cust.getCustomerAddress();
	}
	
}
