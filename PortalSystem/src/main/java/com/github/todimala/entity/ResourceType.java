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
@Table(name = "ResourceType")
public class ResourceType implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "resourceTypeSeq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "resourceTypeSeq", sequenceName = "RESOURCE_TYPE_SEQ", allocationSize=1)
	@Column (name = "RES_TYPE_ID")
	private long resTypeId;
	
	@Column (name = "TYPE_NAME")
	private String name;
	
	@Column (name = "TYPE_DESCRIPTION")
	private String description;
	
	public ResourceType() {} //For JPA

	public ResourceType(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public Long getId() {
		return resTypeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ResourceType [resTypeId=" + resTypeId + ", name=" + name + ", description=" + description + "]";
	}
}
