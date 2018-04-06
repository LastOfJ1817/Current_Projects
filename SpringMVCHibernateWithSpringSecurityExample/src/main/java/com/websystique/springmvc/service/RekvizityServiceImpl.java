package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.RekvizityDao;
import com.websystique.springmvc.model.Rekvizity;

@Service("rekvizityService")
@Transactional
public class RekvizityServiceImpl implements RekvizityService{
	
	@Autowired
	private RekvizityDao dao;

	@Override
	public Rekvizity findById(long id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public void save(Rekvizity rekvizity) {
		dao.save(rekvizity);
		
	}

	@Override
	public void deleteByOwner(int owner_id) {
		dao.deleteByOwner(owner_id);
		
	}

	@Override
	public void deleteById(long id) {
		dao.deleteById(id);
		
	}

	@Override
	public List<Rekvizity> findAllRekvizites() {
		// TODO Auto-generated method stub
		return dao.findAllRekvizites();
	}

	@Override
	public void updateRekvizity(Rekvizity rekvizity) {
		dao.updateRekvizity(rekvizity);
		
	}

	@Override
	public List<Rekvizity> findByOwner(long ownerID) {
		// TODO Auto-generated method stub
		return dao.findByOwner(ownerID);
	}


}
