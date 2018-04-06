package com.websystique.springmvc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.Credit;
import com.websystique.springmvc.model.Debit;

@Repository("CreditDao")
public class CreditDaoImpl extends AbstractDao <Long, Credit> implements CreditDao{

	@Override
	public void saveCredits(Credit credit) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCredit(Credit credit) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCreditById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Credit> findAllCredits() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Credit> findAllCreditsForThePeriod() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Credit> saveCreditsToExcel() {
		// TODO Auto-generated method stub
		return null;
	}

}
