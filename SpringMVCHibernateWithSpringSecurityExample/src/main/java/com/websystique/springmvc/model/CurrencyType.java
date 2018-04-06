package com.websystique.springmvc.model;

public enum CurrencyType {
	DOLLAR("DOLLAR"),
	BITCOIN("BITCOIN"),
	EURO("EURO"),
	RUBLE("RUBLE");
	
	private String currencyType;
	
	private CurrencyType(String currencyType){
		this.currencyType = currencyType;
	}

	public String getCurrencyType() {
		return currencyType;
	}

	
	
	

}
