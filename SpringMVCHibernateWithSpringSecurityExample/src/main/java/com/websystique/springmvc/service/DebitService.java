package com.websystique.springmvc.service;

import java.util.Date;
import java.util.List;

import com.websystique.springmvc.model.Credit;
import com.websystique.springmvc.model.Debit;



public interface DebitService {
	
	void saveDebit(Debit debit);
	
	void updateDebit(Debit debit);
	
	void deleteDebitById(long id);
	
	Debit findById(long id);

	List<Debit> findAllDebits(); 
	
	List<Debit> findAllDebitsForThePeriod(); 
	
	List<Debit> saveDebitsToExcel();
	
	List<Debit> findAllDebitsByOwner(int ownerID); 
	
	List<Debit> findAllDebitsByPeriod(int ownerID, Date startDate, Date endDate); 

}
