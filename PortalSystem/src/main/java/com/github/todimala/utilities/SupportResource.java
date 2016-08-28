package com.github.todimala.utilities;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.ResourceSupport;

import com.github.todimala.controller.ResourceController;
import com.github.todimala.entity.Resource;

public class SupportResource extends ResourceSupport {

	private final Resource resource;
	public SupportResource(Resource resource) {
		Long Id = resource.getId();
		this.resource = resource;
		this.add(linkTo(methodOn(ResourceController.class).findById(Id)).withSelfRel());
	}
	
	public Resource getResource() {
		return this.resource;
	}
}
