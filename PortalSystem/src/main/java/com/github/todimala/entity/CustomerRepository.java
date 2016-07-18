package com.github.todimala.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
	List<Customer> findByLastName(String lastName);

	@Query("select c from Customer c where c.firstName = :firstName and c.lastName = :lastName")
	List<Customer> findByLastNameAndFirstName(@Param("firstName") String firstName, @Param("lastName") String lastName);
}
