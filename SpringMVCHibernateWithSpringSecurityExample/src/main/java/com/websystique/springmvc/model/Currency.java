package com.websystique.springmvc.model;

import java.util.ArrayList;
import java.util.List;

import com.websystique.springmvc.util.XMLParser;

public class Currency {
	private int currencyId;
	private double startCurrency;
	private double finishCurrency;
	private double rate;
	private String currencyType;
	private List<Currency> list = new ArrayList();
	
	

	
	public int getCurrencyId() {
		return currencyId;
	}
	public void setCurrencyId(int currencyId) {
		this.currencyId = currencyId;
	}
	
	public double getStartCurrency() {
		return startCurrency;
	}
	public void setStartCurrency(double startCurrency) {
		this.startCurrency = startCurrency;
	}
	public double getFinishCurrency() {
		return finishCurrency;
	}
	public void setFinishCurrency(double finishCurrency) {
		this.finishCurrency = finishCurrency;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public String getCurrencyType() {
		
		return currencyType;
	}
	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}
	
	
	

}
