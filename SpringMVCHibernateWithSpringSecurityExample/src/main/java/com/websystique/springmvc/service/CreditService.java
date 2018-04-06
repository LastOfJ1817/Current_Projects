package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.Credit;


public interface CreditService {
	
	void saveCredits(Credit credit);
	
	void updateCredit(Credit credit);
	
	void deleteCreditById(int id);

	List<Credit> findAllCredits(); 
	
	List<Credit> findAllCreditsForThePeriod(); 
	
	List<Credit> saveCreditsToExcel();

}
