package com.telecom.utils.notifier;

import org.springframework.stereotype.Component;

import com.telecom.model.Customer;
import com.telecom.service.CustomerReadPlateformService;
import com.telecom.service.email.EmailSender;
import com.telecom.utils.reporting.Report;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


@Component
public class BirthdateNotifiler implements ImportentDateNotifier {

	 private Logger logger = LoggerFactory.getLogger(BirthdateNotifiler.class);

	    // days and message are beign set from the application.propertie file
	    @Value("${birthdate.notification.day}")
	    private int days;
	    @Value("${birthdate.notification.message}")
	    private String message;
	    private final EmailSender emailSender;
	    private final CustomerReadPlateformService customerReadPlateformService;
	    private Report report;
	    private List<Customer> customerHolder;
	    private Date localDate;

	    public BirthdateNotifiler(EmailSender emailSender, CustomerReadPlateformService customerReadPlateformService, Report report) {
	        this.emailSender = emailSender;
	        this.customerReadPlateformService = customerReadPlateformService;
	        this.report = report;
	        this.customerHolder = new ArrayList<>();
	        this.localDate = new Date(Calendar.getInstance().getTime().getTime());;
	    }

	    @Override
	    public String notification(String to,String name) {
	        this.emailSender.send(to,buildEmail(name));
	        return "Birthday Email Send";
	    }

	    // this function will trigger every 24 hour to check the customer birthdays and also the current day birthdays
	    //@Scheduled(cron = "0 0 23 * * *")
	    @Scheduled(fixedRate = 20000)
	    public void checkBirthDateInterval() throws InterruptedException{
	        Iterable<Customer> customers = this.customerReadPlateformService.getAllCustomer();
	        customers.forEach(this::calculateBirthday);

	        // genrateReporting is for daily customer reporting
	        this.report.genrateReport(customerHolder, LocalDate.now(), LocalTime.now());
	        this.customerHolder = new ArrayList<>();
	        logger.info("Birthday: Checking daily birthdays");
	    }

	    // helper function to calculate current and advance birthday
	    private void calculateBirthday(Customer customer){

	        Date customerBirthdate = customer.getDate();
	        Date localDate = this.localDate;
	        Date futureDate = addDays(localDate,days);

	        Calendar cal = Calendar.getInstance();
	        cal.setTime(customerBirthdate);
	        int customerMonth = cal.get(Calendar.MONTH)+1;
	        int customerDay = cal.get(Calendar.DAY_OF_MONTH);

	        cal.setTime(futureDate);
	        int futureDateMonth = cal.get(Calendar.MONTH)+1;
	        int futureDateDay = cal.get(Calendar.DAY_OF_MONTH);

	        cal.setTime(localDate);
	        int localDateMonth = cal.get(Calendar.MONTH)+1;
	        int localDateDay = cal.get(Calendar.DAY_OF_MONTH);


	        // check for checking the advance birthday
	        if (customerMonth==futureDateMonth && customerDay==futureDateDay){
	            this.notification(customer.getEmail(),customer.getName());

	            customerHolder.add(customer);
	            logger.info("Happy Birthday: "+ customer.getName());
	        }

	        // check for checking the current day birthday
	        if (customerMonth==localDateMonth && customerDay==localDateDay){
	            customerHolder.add(customer);
	        }

	    }

	    // helper function for add days to any given date
	    private static Date addDays(Date date, int days) {

	        Calendar c = Calendar.getInstance();
	        c.setTime(date);
	        c.add(Calendar.DATE, days);
	        return new Date(c.getTimeInMillis());

	    }

	    // this function will return a html to send birthday greetings
	    private String buildEmail(String name) {
	    	
	    	return "<div>"+"HI " +name+" Happy Birthday "+"/n"+" from "+" Prajwal"
	    	+"</div>";
	    }
}
