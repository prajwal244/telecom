package com.telecom.service;

import java.util.List;

import com.telecom.model.Customer;

public interface CustomerReadPlateformService {
	 List<Customer> getAllCustomer();
	    Customer getCustomerById(long id);
}
