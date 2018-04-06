package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.PhoneDAO;
import com.websystique.springmvc.model.Phone;
import com.websystique.springmvc.model.User;

@Service("phoneService")
@Transactional
public class PhoneServiceImpl implements PhoneService {
	@Autowired
	private PhoneDAO dao;
	
	@Override
	public Phone findById(long id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}
	
	@Override
	public List<Phone> findAllPhones() {
		// TODO Auto-generated method stub
		return dao.findAllPhones();
	}
	

	@Override
	public List<Phone> findByOwner(int owner_id) {
		// TODO Auto-generated method stub
		return dao.findByOwner(owner_id);
	}

	@Override
	public void save(Phone phone) {
		
		dao.save(phone);
		
	}

	@Override
	public void deleteByOwner(int owner_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(long id) {
		dao.deleteById(id);
		
	}



	@Override
	public List<Phone> findABySSO(String SSO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updatePhone(Phone phone) {
		dao.updatePhone(phone);
		
	}

}
