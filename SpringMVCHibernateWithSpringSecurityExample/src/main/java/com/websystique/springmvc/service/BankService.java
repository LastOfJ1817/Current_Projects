package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.Bank;
import com.websystique.springmvc.model.Dodovor;

public interface BankService {
	
	Bank findById(long id);
	
	void deleteById (long id);
	
	void save (Bank bank);
	
	void updateBank(Bank bank);
	
	List<Bank> findAllBanks(); 

}
