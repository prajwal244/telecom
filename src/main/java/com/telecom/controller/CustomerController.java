package com.telecom.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telecom.data.CustomerResponceData;
import com.telecom.model.Customer;
import com.telecom.service.CustomerReadPlateformService;
import com.telecom.service.CustomerWritePlateformService;
import com.telecom.utils.notifier.ImportentDateNotifier;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	  private final CustomerWritePlateformService customerWritePlateformService;
	    private final CustomerReadPlateformService customerReadPlateformService;
	    private final ImportentDateNotifier importentDateNotifier;
	    private Logger logger = LoggerFactory.getLogger(CustomerController.class);

	    @Autowired
	    public CustomerController(CustomerWritePlateformService customerWritePlateformService, CustomerReadPlateformService customerReadPlateformService, ImportentDateNotifier importentDateNotifier) {
	        this.customerWritePlateformService = customerWritePlateformService;
	        this.customerReadPlateformService = customerReadPlateformService;
	        this.importentDateNotifier = importentDateNotifier;
	    }

	    @PostMapping
	    public CustomerResponceData createCustomer(@RequestBody Customer c){
	        logger.info("Creating customer:"+ c.getName());
	        Customer customer = this.customerWritePlateformService.createCustomer(c);
	        CustomerResponceData customerResponceData = new CustomerResponceData();
	        customerResponceData.setId(customer.getId());
	        customerResponceData.setName(customer.getName());
	        customerResponceData.setEmail(customer.getEmail());
	        customerResponceData.setDate(customer.getDate());
	        return customerResponceData;
	    }

	    @GetMapping
	    public List<Customer> getAllCustomer(){
	        logger.info("Customer: Getting all customers");
	        return this.customerReadPlateformService.getAllCustomer();
	    }

	    @GetMapping("{customerId}")
	    public Customer getCustomerSims(@PathVariable("customerId") Long id){
	        logger.info("Customer: Getting sims of customer"+id.toString());
	        return this.customerReadPlateformService.getCustomerById(id);
	    }

	
}
