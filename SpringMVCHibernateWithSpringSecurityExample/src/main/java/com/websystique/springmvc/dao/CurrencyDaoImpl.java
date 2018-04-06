package com.websystique.springmvc.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.Currency;
import com.websystique.springmvc.model.CurrencyType;
import com.websystique.springmvc.model.UserProfile;
import com.websystique.springmvc.util.XMLParser;

@Repository("currencyDAO")
public class CurrencyDaoImpl implements CurrencyDao{
	

	@Override
	public double exchange(double startCurrency, double sum, int currecyID) {
		// TODO Auto-generated method stub
		return 0;
	} 

	@Override
	public List<Currency> findAll() {
		List<Currency> list = new ArrayList<Currency>();
		
		
		String rate = XMLParser.getCurrency("USD");
		Currency usdCur = new Currency();
		usdCur.setCurrencyId(1);
		usdCur.setCurrencyType("USD");
		usdCur.setRate(new Double(rate));
		list.add(usdCur);
		
		String rate1 = XMLParser.getCurrency("EUR");
		Currency usdCur1 = new Currency();
		usdCur1.setCurrencyId(1);
		usdCur1.setCurrencyType("EUR");
		usdCur1.setRate(new Double(rate1));
		list.add(usdCur1);
		
		
		
		return list;
	}

}
