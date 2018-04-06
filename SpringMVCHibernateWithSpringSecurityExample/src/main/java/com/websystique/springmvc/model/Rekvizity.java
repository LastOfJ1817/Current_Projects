package com.websystique.springmvc.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="rekvizity")
public class Rekvizity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="owner_id")
	private Long ownerID;
	
	@Column(name="unp")
	private Long unp;
	
	@Column(name="address")
	private String address;
	
	@Column(name="account")
	private String account;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bank_id")
	private Bank bank;
	
	


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


	public Long getUnp() {
		return unp;
	}


	public void setUnp(Long unp) {
		this.unp = unp;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getAccount() {
		return account;
	}


	public void setAccount(String account) {
		this.account = account;
	}

	
	public Bank getBank() {
		return bank;
	}


	public void setBank(Bank bank) {
		this.bank = bank;
	}
	
	

	
	
	
	

}
