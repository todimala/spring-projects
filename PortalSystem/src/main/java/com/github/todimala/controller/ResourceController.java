package com.github.todimala.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.todimala.entity.ResourceRepository;
import com.github.todimala.entity.ResourceType;
import com.github.todimala.entity.ResourceTypeRepository;

@RestController
@RequestMapping("/resource")
public class ResourceController {

	private final ResourceRepository resourceRepo;
	final static Logger LOGGER = Logger.getLogger(ResourceController.class);
	
	@Autowired
	ResourceController(ResourceRepository resourceRepo) {
		this.resourceRepo = resourceRepo;
	}
	
}
