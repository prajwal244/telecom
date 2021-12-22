package com.telecom.data;

import java.sql.Date;

public class CustomerResponceData {
	 private long id;
	    private String name;
	    private String email;
	    private Date date;

	    public CustomerResponceData() {
	    }

	    public CustomerResponceData(long id, String name, String email, Date date) {
	        this.id = id;
	        this.name = name;
	        this.email = email;
	        this.date = date;
	    }

	    public long getId() {
	        return id;
	    }

	    public void setId(long id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public Date getDate() {
	        return date;
	    }

	    public void setDate(Date date) {
	        this.date = date;
	    }
}
