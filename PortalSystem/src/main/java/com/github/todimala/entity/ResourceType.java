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
	@Column (name = "ID")
	private Long Id;
	
	@Column (name = "TYPE_NAME")
	private String name;
	
	@Column (name = "TYPE_DESCRIPTION")
	private String description;
	
	public ResourceType() {} //For JPA
}
