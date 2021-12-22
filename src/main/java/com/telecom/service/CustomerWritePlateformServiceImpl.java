package com.telecom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telecom.dto.CustomerRepository;
import com.telecom.dto.SimRepository;
import com.telecom.model.Customer;
import com.telecom.model.Sim;
@Service
public class CustomerWritePlateformServiceImpl implements CustomerWritePlateformService {
	 private final CustomerRepository customerRepository;
	    private final SimRepository simRepository;
	    private final SimReadPlatformService simReadPlatformService;


	    @Autowired
	    public CustomerWritePlateformServiceImpl(CustomerRepository customerRepository, SimRepository simRepository, SimReadPlatformService simReadPlatformService) {
	        this.customerRepository = customerRepository;
	        this.simRepository = simRepository;
	        this.simReadPlatformService = simReadPlatformService;
	    }
	 // this function will create CUSTOMER
	@Override
	public Customer createCustomer(Customer customer) {
		 return this.customerRepository.save(customer);
	}
	// this function will link SIM to CUSTOMER
	@Override
	public Customer linkSim(Long customerId, List<Long> simId) {
		 Customer customer = this.customerRepository.findById(customerId).get();
	        List<Sim> sims = this.simRepository.findAllById(simId);
	        List<Sim> customerSim = simReadPlatformService.getSimsByCustomerId(customerId);
	        customerSim.addAll(sims);
	        customer.setSim(customerSim);
	        return this.customerRepository.save(customer);
	}

}
