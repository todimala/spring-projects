package com.github.todimala.entity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "resourceType", path = "resourceType")
public interface ResourceTypeRepository extends JpaRepository<ResourceType, Long> {
	
	@Query ("select r from ResourceType r where r.name = :name")
	Optional<ResourceType> findByName(@Param("name") String name);  
	
	@Query ("select r from ResourceType r where r.resTypeId = :Id")
	Optional<ResourceType> findById(@Param("Id") Long Id);
}
