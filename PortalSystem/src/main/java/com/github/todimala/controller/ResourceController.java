package com.github.todimala.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.todimala.entity.Address;
import com.github.todimala.entity.Customer;
import com.github.todimala.entity.Resource;
import com.github.todimala.entity.ResourceRepository;
import com.github.todimala.utilities.SupportResource;

@RestController
@RequestMapping("/resource")
public class ResourceController {

	private final ResourceRepository resourceRepo;
	final static Logger LOGGER = Logger.getLogger(ResourceController.class);
	
	@Autowired
	ResourceController(ResourceRepository resourceRepo) {
		this.resourceRepo = resourceRepo;
	}
	
	@RequestMapping(path="/list", method = RequestMethod.GET)
	public List<Resource> listAll() {
		LOGGER.info("List all Resouce ");
		return this.resourceRepo.findAll();
	}
	
	@RequestMapping(path = "/{resourceId}", method = RequestMethod.GET)
	public SupportResource findById(@PathVariable Long resourceId) {
		LOGGER.info("Find Resource by Id: " + resourceId);
		Resource res = this.resourceRepo.findOne(resourceId);
		return new SupportResource(res);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public SupportResource addResource(@RequestBody Resource resource) {
		LOGGER.info("Adding Resource : " + resource.toString());
		return new SupportResource(this.resourceRepo.save(resource));
	}
}
