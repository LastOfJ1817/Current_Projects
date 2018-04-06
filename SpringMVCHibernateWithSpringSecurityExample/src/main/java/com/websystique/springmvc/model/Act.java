 package com.websystique.springmvc.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="act")
public class Act {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long actId;
	
	@Column(name = "dogovor_id")
	private Long dogovorID;
	
	@Column(name = "contragent_id")
	private Long contragentID;
	
	@Column(name = "owner_id")
	private Long ownerID;

	@NotEmpty
	@Column(name = "Act_Date")
	private String date;

	@NotEmpty
	@Column(name = "Act_Number")
	private String number;

	
	
	@NotNull
	@Column(name = "Act_Sum")
	private Double summ;

	public Long getActId() {
		return actId;
	}

	public void setActId(Long actId) {
		this.actId = actId;
	}

	public Long getDogovorID() {
		return dogovorID;
	}

	public void setDogovorID(Long dogovorID) {
		this.dogovorID = dogovorID;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Double getSumm() {
		return summ;
	}

	public void setSumm(Double summ) {
		this.summ = summ;
	}

	public Long getOwnerID() {
		return ownerID;
	}

	public void setOwnerID(Long ownerID) {
		this.ownerID = ownerID;
	}

	public Long getContragentID() {
		return contragentID;
	}

	public void setContragentID(Long contragentID) {
		this.contragentID = contragentID;
	}

	
	
	

	
	
	
	

	
	
	

}

