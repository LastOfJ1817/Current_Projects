package com.websystique.springmvc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="debit")
public class Debit {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="owner_id")
	private Long ownerID;
	
	@NotNull
	@Column(name="contragent_id")
	private Long contragentID;
	
	@NotEmpty
	//@DateTimeFormat(pattern = "MM-dd-yyyy")
	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name="Date")
	private String date;
	
	@NotEmpty
	@Column(name="Document")
	private String document;
	
	@NotEmpty
	@Column(name="Description")
	private String description;
	
	@NotNull
	@Column(name="IncomeAmount")
	private Double incomeAmount;
	
	
	@Column(name="IncludingNDS")
	private Double includingNDS;
	
	@NotNull
	@Column(name="TotalAmount") 
	private Double totalAmount;
	
	@NotNull
	@Column(name="OtherAmount")
	private Double otherAmount;
	
	@Column(name="actID")
	private Long actId;

	 
	public Long getId() {
		
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOwnerID() {
		return ownerID;
	}

	public void setOwnerID(Long ownerID) {
		this.ownerID = ownerID;
	}

	

	public String getDate() {
		return date;
	}

	public void setDate (String date) {
		this.date = date;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getIncomeAmount() {
		return incomeAmount;
	}

	public void setIncomeAmount(Double incomeAmount) {
		this.incomeAmount = incomeAmount;
	}

	public Double getIncludingNDS() {
		return includingNDS;
	}

	public void setIncludingNDS(Double includingNDS) {
		this.includingNDS = includingNDS;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Double getOtherAmount() {
		return otherAmount;
	}

	public void setOtherAmount(Double otherAmount) {
		this.otherAmount = otherAmount;
	}

	public Long getActId() {
		return actId;
	}

	public void setActId(Long actId) {
		this.actId = actId;
	}

	public Long getContragentID() {
		return contragentID;
	}

	public void setContragentID(Long contragentID) {
		this.contragentID = contragentID;
	}
	
	

	
	
	

}
