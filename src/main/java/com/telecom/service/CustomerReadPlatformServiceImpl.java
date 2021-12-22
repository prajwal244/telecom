package com.telecom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.telecom.dto.CustomerRepository;
import com.telecom.dto.SimRepository;
import com.telecom.model.Customer;

@Service
public class CustomerReadPlatformServiceImpl implements CustomerReadPlateformService {

	
	 private final CustomerRepository customerRepository;
	    private final SimRepository simRepository;
	    
	    @Autowired
	    public CustomerReadPlatformServiceImpl(CustomerRepository customerRepository, SimRepository simRepository) {
	        this.customerRepository = customerRepository;
	        this.simRepository = simRepository;
	    }
	 // this function will return all CUSTOMERS from the database
	@Override
	public List<Customer> getAllCustomer() {
		
		 return  this.customerRepository.findAll();
	}
	  // this function will return CUSTOMERS by given id
	@Override
	public Customer getCustomerById(long id) {
		
		return this.customerRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Customer Not Found"));
	}

}
