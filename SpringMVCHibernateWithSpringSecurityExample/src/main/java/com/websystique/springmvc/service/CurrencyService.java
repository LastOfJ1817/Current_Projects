package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.Currency;
import com.websystique.springmvc.model.CurrencyType;
import com.websystique.springmvc.model.UserProfile;

public interface CurrencyService {
	
	public double exchange(double startCurrency, double sum, int currecyID);
	
	List<Currency> findAll();
}
