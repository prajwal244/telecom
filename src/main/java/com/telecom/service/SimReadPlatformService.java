package com.telecom.service;

import java.util.List;

import com.telecom.model.Sim;

public interface SimReadPlatformService {
	  List<Sim> getSimsByCustomerId(Long id);
	    List<Sim> getAllSims();
}
