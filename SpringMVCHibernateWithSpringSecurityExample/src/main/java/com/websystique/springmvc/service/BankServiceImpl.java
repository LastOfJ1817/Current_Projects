package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.BankDao;
import com.websystique.springmvc.model.Bank;

@Service("bankService")
@Transactional
public class BankServiceImpl implements BankService{
	
	@Autowired
	private BankDao dao;

	@Override
	public Bank findById(long id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public void deleteById(long id) {
		dao.deleteById(id);
		
	}

	@Override
	public void save(Bank bank) {
		dao.save(bank);
		
	}

	@Override
	public void updateBank(Bank bank) {
		dao.updateBank(bank);
		
	}

	@Override
	public List<Bank> findAllBanks() {
		// TODO Auto-generated method stub
		return dao.findAllBanks();
	}

}
