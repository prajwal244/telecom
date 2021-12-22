package com.telecom.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.telecom.dto.CustomerRepository;
import com.telecom.dto.SimRepository;
import com.telecom.model.Customer;
import com.telecom.model.Sim;

@Service
public class SimReadPlatformServiceImpl implements SimReadPlatformService  {

	private final CustomerRepository customerRepository;
    private final SimRepository simRepository;

    public SimReadPlatformServiceImpl(CustomerRepository customerRepository, SimRepository simRepository) {
        this.customerRepository = customerRepository;
        this.simRepository = simRepository;
    }
    
    // this function will return SIMS of CUSTOMERS according to customer id
	@Override
	public List<Sim> getSimsByCustomerId(Long id) {

        List<Sim> simResponceDataHolder = new ArrayList<>();

        Customer customer = this.customerRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Customer Not Found"));

        Iterable<Sim> sim = customer.getSim();

        sim.forEach(simResponceDataHolder::add);

        return simResponceDataHolder;
	}


    // this function will return all SIMS
	@Override
	public List<Sim> getAllSims() {
	
	        return this.simRepository.findAll();
	    }
	}


