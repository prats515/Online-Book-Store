package com.onlinebookstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.onlinebookstore.entity.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer>{
	@Query("SELECT u FROM Customer u WHERE u.email = :email")
    Customer getByEmail(@Param("email") String email);

    Customer findByEmail(String email);

}
