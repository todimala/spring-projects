package com.github.todimala.controller;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.todimala.entity.ResourceType;
import com.github.todimala.entity.ResourceTypeRepository;
import com.github.todimala.utilities.ResouceTypeResource;

@RestController
@RequestMapping("/resourceType")
public class ResourceTypeController {

	private final ResourceTypeRepository resourceTypeRepo;
	final static Logger LOGGER = Logger.getLogger(ResourceController.class);
	
	@Autowired
	ResourceTypeController(ResourceTypeRepository resourceTypeRepo) {
		this.resourceTypeRepo = resourceTypeRepo;
	}
	
	@RequestMapping(path="/list", method = RequestMethod.GET)
	public List<ResourceType> listAll() {
		LOGGER.info("List all ResouceTypes ");
		return this.resourceTypeRepo.findAll();
	}
	
	@RequestMapping(path = "/{resourceTypeId}", method = RequestMethod.GET)
	public ResouceTypeResource findById(@PathVariable Long resourceTypeId) {
		LOGGER.info("Find Resource Type by Id: " + resourceTypeId);
		ResourceType resType = this.resourceTypeRepo.findOne(resourceTypeId);
		return new ResouceTypeResource(resType);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResouceTypeResource addResourceType(@RequestBody ResourceType resourceType) {
		LOGGER.info("Adding Resource Type: " + resourceType.toString());
		return new ResouceTypeResource(this.resourceTypeRepo.save(resourceType));
	}
}
