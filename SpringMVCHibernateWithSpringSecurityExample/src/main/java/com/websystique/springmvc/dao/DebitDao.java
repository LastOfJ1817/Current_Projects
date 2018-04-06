package com.websystique.springmvc.dao;

import java.util.Date;
import java.util.List;

import com.websystique.springmvc.model.Debit;

public interface DebitDao {
	
	void saveDebit(Debit debit);
	
	void updateDebit(Debit debit);
	
	void deleteDebitById(long id);

	List<Debit> findAllDebits(); 
	
	List<Debit> findAllDebitsForThePeriod(); 
	
	List<Debit> saveDebitsToExcel();
	
	List<Debit> findAllDebitsByOwner(int ownerID); 
	
	Debit findById(long id);
	
	List<Debit> findAllDebitsByPeriod(int ownerID, Date startDate, Date endDate); 

}
