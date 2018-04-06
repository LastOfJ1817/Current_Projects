package com.websystique.springmvc.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="bank")
public class Bank {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="bank_name")
	private String bankName;
	
	@Column(name="bank_address")
	private String bankAddress;
	
	@Column(name="bik")
	private String bankCode;
	
	//@OneToMany(mappedBy = "rekvizity", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
   // private Set<Rekvizity> attachments = new HashSet<Rekvizity>();
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankAddress() {
		return bankAddress;
	}

	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	

	
	
	
	
	
	

}
