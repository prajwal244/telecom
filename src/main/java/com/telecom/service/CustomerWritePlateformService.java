package com.telecom.service;

import java.util.List;

import com.telecom.model.Customer;

public interface CustomerWritePlateformService {
	 Customer createCustomer(Customer customer);
	    Customer linkSim(Long customerId, List<Long> simId);
}
