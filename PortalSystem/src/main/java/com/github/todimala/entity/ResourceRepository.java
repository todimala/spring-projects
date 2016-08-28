package com.github.todimala.entity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "resource", path = "resource")
public interface ResourceRepository extends JpaRepository<Resource, Long>{

	@Query ("select r from Resource r where r.name = :name")
	Optional<Resource> findByName(@Param("name") String name);  
	
	@Query ("select r from Resource r where r.id = :Id")
	Optional<Resource> findById(@Param("Id") Long Id);
	
}
