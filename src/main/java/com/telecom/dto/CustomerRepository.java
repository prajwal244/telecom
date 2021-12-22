package com.telecom.dto;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telecom.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
