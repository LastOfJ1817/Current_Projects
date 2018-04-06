package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.CurrencyDao;
import com.websystique.springmvc.model.Currency;
import com.websystique.springmvc.model.CurrencyType;

@Service("currencyService")
@Transactional
public class CurrencyServiceImpl implements CurrencyService{
	
	@Autowired
	private CurrencyDao dao;
	
	@Override
	public double exchange(double startCurrency, double sum, int currecyID) {
		
		return dao.exchange(startCurrency, sum, currecyID);
	}

	
	@Override
	public List<Currency> findAll() {
		
		return dao.findAll();
	}

}
