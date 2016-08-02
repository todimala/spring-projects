package com.github.todimala.entity;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "customer", path = "customer")
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	List<Customer> findByLastName(String lastName);

	@Query("select c from Customer c where c.firstName = :firstName and c.lastName = :lastName")
	List<Customer> findByLastNameAndFirstName(@Param("firstName") String firstName, @Param("lastName") String lastName);
	
	@Query("select c from Customer c where c.customerEmail1 = :customerEmail1")
	Optional<Customer> findByCustomerEmail1(@Param("customerEmail1") String customerEmail1);
}
