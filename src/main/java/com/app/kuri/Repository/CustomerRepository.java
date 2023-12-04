package com.app.kuri.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.kuri.Model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByEmail(String email);

    @Query("SELECT c FROM Customer c LEFT JOIN FETCH c.authorities WHERE c.customer_id = :customerId")
    Optional<Customer> findByIdWithAuthorities(@Param("customerId") Long customerId);

}
