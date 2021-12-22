package com.telecom.data;

import com.telecom.model.Customer;

public class CustomerRequestData {
	 private Customer customer;

	    public CustomerRequestData() {
	    }

	    public CustomerRequestData(Customer customer) {
	        this.customer = customer;
	    }

	    public Customer getCustomer() {
	        return customer;
	    }

	    public void setCustomer(Customer customer) {
	        this.customer = customer;
	    }
}
