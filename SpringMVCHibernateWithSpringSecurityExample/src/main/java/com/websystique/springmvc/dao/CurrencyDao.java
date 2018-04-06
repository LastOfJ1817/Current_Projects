package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.Currency;
import com.websystique.springmvc.model.CurrencyType;

public interface CurrencyDao {
	
	public double exchange(double startCurrency, double sum, int currecyID);
	
	List<Currency> findAll();

}
