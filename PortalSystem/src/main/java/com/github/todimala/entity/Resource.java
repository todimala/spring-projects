package com.github.todimala.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name = "Resource")
public class Resource implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "resourceSeq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "resourceSeq", sequenceName = "RESOURCE_SEQ", allocationSize=1)
	@Column(name = "ID")
	private Long id;
	
	@Column (name = "RESOURCE_TYPE")
	private ResourceType resourceType;
	
	public Resource() {} //For JPA

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ResourceType getResourceType() {
		return resourceType;
	}

	public void setResourceType(ResourceType resourceType) {
		this.resourceType = resourceType;
	}

}
