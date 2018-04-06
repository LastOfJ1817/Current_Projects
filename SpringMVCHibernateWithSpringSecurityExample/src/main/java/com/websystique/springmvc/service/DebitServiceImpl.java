package com.websystique.springmvc.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.DebitDao;
import com.websystique.springmvc.model.Debit;


@Service("debitService")
@Transactional
public class DebitServiceImpl implements DebitService{

	
	@Autowired
	private DebitDao dao;
	
	
	@Override
	public void saveDebit(Debit debit) {
		dao.saveDebit(debit);
		
	}

	@Override
	public void updateDebit(Debit debit) {
		dao.updateDebit(debit);
		
	}

	@Override
	public void deleteDebitById(long id) {
		dao.deleteDebitById(id);
		
	}

	@Override
	public List<Debit> findAllDebits() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Debit> findAllDebitsForThePeriod() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Debit> saveDebitsToExcel() {
		return dao.saveDebitsToExcel();
	}

	@Override
	public List<Debit> findAllDebitsByOwner(int ownerID) {
		// TODO Auto-generated method stub
		return dao.findAllDebitsByOwner(ownerID);
	}

	@Override
	public Debit findById(long id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public List<Debit> findAllDebitsByPeriod(int ownerID, Date startDate, Date endDate) {
		
		return dao.findAllDebitsByPeriod(ownerID, startDate, endDate);
	}

	

}
