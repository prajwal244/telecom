package com.telecom.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telecom.data.SimLinkRequestData;
import com.telecom.model.Customer;
import com.telecom.service.CustomerReadPlateformService;
import com.telecom.service.CustomerWritePlateformService;



@RestController
@RequestMapping("/link")
public class ConnectionController {
	private final CustomerWritePlateformService customerWritePlateformService;
    private final CustomerReadPlateformService customerReadPlateformService;
    private Logger logger = LoggerFactory.getLogger(ConnectionController.class);


    @Autowired
    public ConnectionController(CustomerWritePlateformService customerWritePlateformService, CustomerReadPlateformService customerReadPlateformService) {
        this.customerWritePlateformService = customerWritePlateformService;
        this.customerReadPlateformService = customerReadPlateformService;
    }

    @PostMapping("{id}")
    public Customer LinkSimToCustomer(@RequestBody SimLinkRequestData simId, @PathVariable("id") Long customerId){
        logger.info("Link: Liking Sim "+simId+" to Customer "+customerId);
        return this.customerWritePlateformService.linkSim(customerId,simId.getId());
    }
}
