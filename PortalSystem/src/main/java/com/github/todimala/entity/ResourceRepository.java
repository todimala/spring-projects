package com.github.todimala.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "resource", path = "resource")
public interface ResourceRepository extends JpaRepository<Resource, Long>{

	
}
