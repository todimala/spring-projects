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
	
	@Column (name = "RESOURCE_TYPE_ID")
	private Long resourceTypeId;
	
	@Column (name = "RESOURCE_NAME")
	private String name;
	
	public Resource() {} //For JPA

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getResourceTypeId() {
		return resourceTypeId;
	}

	public void setResourceType(Long resourceTypeId) {
		this.resourceTypeId = resourceTypeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Resource [id=" + id + ", resourceTypeId=" + resourceTypeId + ", name=" + name + "]";
	}

}
