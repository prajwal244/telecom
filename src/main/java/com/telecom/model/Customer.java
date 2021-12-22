package com.telecom.model;


import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity
@Table(name = "t_customer")
public class Customer {
	    
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "customer_id")
	    @Id
	    private long id;
	    @Column(name = "name")
	    private String name;
	    @Column(name = "email")
	    private String email;
	    @Column(name = "birthdate")
	    private Date date;
	    @OneToMany(targetEntity = Sim.class,cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
	    @JoinColumn(name = "cs_fk",referencedColumnName = "customer_id")
	    private List<Sim> sim;



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

		public List<Sim> getSim() {
			return sim;
		}

		public void setSim(List<Sim> sim) {
			this.sim = sim;
		}

		
		

}
