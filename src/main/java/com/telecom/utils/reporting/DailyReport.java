package com.telecom.utils.reporting;

import org.springframework.beans.factory.annotation.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.telecom.model.Customer;
import com.telecom.utils.notifier.BirthdateNotifiler;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Component
public class DailyReport  implements Report {
	  @Value( "${reporting.path}" )
	    private String path;
	    @Value( "${reporting.filename}" )
	    private String filename;

	    private Logger logger = LoggerFactory.getLogger(BirthdateNotifiler.class);

		@Override
		public void genrateReport(List<Customer> customer, LocalDate localDate, LocalTime localTime) {
			 Gson gson = new Gson();
		        String customerJson = gson.toJson(customer);
		        String timeAndDate = localDate+"--"+localTime.toString().replace(":","-");

		        if (customer.size()>0){
		            logger.info("Report: Genrating report for the customers");
		            try {
		                FileWriter myWriter = new FileWriter(path+"\\"+timeAndDate+"-"+filename,true);
		                myWriter.write(customerJson);
		                myWriter.close();
		            } catch (IOException e) {
		                e.printStackTrace();
		            }
		        }
			
		}

	  
	

}
