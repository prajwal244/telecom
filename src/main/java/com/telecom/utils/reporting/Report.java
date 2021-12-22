package com.telecom.utils.reporting;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.telecom.model.Customer;

public interface Report {
	 public void genrateReport(List<Customer> customer, LocalDate localDate, LocalTime localTime);
}
