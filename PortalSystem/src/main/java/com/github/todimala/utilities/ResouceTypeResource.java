package com.github.todimala.utilities;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import org.springframework.hateoas.ResourceSupport;

import com.github.todimala.controller.ResourceTypeController;
import com.github.todimala.entity.ResourceType;

public class ResouceTypeResource extends ResourceSupport {

	private final ResourceType resourceType;
	public ResouceTypeResource(ResourceType resourceType) {
		Long Id = resourceType.getId();
		this.resourceType = resourceType;
		this.add(linkTo(methodOn(ResourceTypeController.class).findById(Id)).withSelfRel());
	}
	
	public ResourceType getResourceType() {
		return this.resourceType;
	}
}
