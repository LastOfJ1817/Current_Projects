package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.DogovorDao;
import com.websystique.springmvc.model.Dodovor;

@Service("dogovorService")
@Transactional
public class DogovorServiceImpl implements DogovorService{
	
	@Autowired
	private DogovorDao dao;

	@Override
	public void saveDogovor(Dodovor dogovor) {
		dao.saveDogovor(dogovor);
		
	}

	@Override
	public void updateDogovor(Dodovor dogovor) {
		dao.updateDogovor(dogovor);
		
	}

	@Override
	public void deleteDogovorById(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Dodovor findById(long id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public List<Dodovor> findAllDogovors() {
		// TODO Auto-generated method stub
		return dao.findAllDogovors();
	}

	@Override
	public List<Dodovor> findAllDogovorssForThePeriod() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Dodovor> saveDebitsToExcel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Dodovor> findAllDogovorsByOwner(long ownerID) {
		// TODO Auto-generated method stub
		return dao.findAllDogovorsByOwner(ownerID);
	}

}
