package com.websystique.springmvc.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.ActDao;

import com.websystique.springmvc.model.Act;
import com.websystique.springmvc.model.Debit;

@Service("actService")
@Transactional
public class ActServiceImpl implements ActService{
	
	@Autowired
	private ActDao dao;
	
	@Override
	public Act findById(long id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public void saveAct(Act act) {
		dao.saveAct(act);
		
	}

	@Override
	public void updateAct(Act act) {
		dao.updateAct(act);
		
	}

	@Override
	public void deleteActById(long id) {
		dao.deleteActById(id);
		
	}

	@Override
	public List<Act> findAllActsByOwner(long ownerID) {
		// TODO Auto-generated method stub
		return dao.findAllActsByOwner(ownerID);
	}

	@Override
	public List<Act> findAllActsByContragentId(long contragentID) {
		// TODO Auto-generated method stub
		return dao.findAllActsByContragentId(contragentID);
	}

	@Override
	public List<Act> findAllActsByPeriod(int ownerID, Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return dao.findAllActsByPeriod(ownerID, startDate, endDate);
	}

}
