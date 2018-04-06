package com.websystique.springmvc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="Credits")
public class Credit {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="owner_id")
	private Long ownerID;
	
	@NotEmpty
	@Column(name="Date", nullable=false)
	private Date date;
	
	@NotEmpty
	@Column(name="Document", nullable=false)
	private String document;
	
	@NotEmpty
	@Column(name="Description", nullable=false)
	private String description;
	
	@NotEmpty
	@Column(name="Amount", nullable=false)
	private double amount;

}
