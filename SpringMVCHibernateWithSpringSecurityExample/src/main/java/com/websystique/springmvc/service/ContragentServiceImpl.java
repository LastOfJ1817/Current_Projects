package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.ContragentDao;

import com.websystique.springmvc.model.Contragent;

@Service("contragentService")
@Transactional
public class ContragentServiceImpl implements ContragentService{
	
	@Autowired
	private ContragentDao dao;

	@Override
	public Contragent findById(long id) {
		
		return dao.findById(id);
	}

	@Override
	public void saveContragent(Contragent contragent) {
		dao.saveContragent(contragent);
		
	}

	@Override
	public void updateContragent(Contragent contragent) {
		dao.updateContragent(contragent);
		
	}

	@Override
	public void deleteContragentById(long id) {
		dao.deleteContragentById(id);
		
	}

	@Override
	public List<Contragent> findAllContragents(Long ownerID) {
		// TODO Auto-generated method stub
		return dao.findAllContragents(ownerID);
	}

	@Override
	public List<Contragent> findAllContragents() {
		// TODO Auto-generated method stub
		return dao.findAllContragents();
	}

}
