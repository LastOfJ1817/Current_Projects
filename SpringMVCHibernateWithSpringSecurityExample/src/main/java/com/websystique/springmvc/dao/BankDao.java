package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.Bank;

public interface BankDao {
	
	Bank findById(long id);
	
	void deleteById (long id);
	
	void save (Bank bank);
	
	void updateBank(Bank bank);
	
	List<Bank> findAllBanks();

}
