package com.websystique.springmvc.dao;

import java.util.Date;
import java.util.List;

import com.websystique.springmvc.model.Act;
import com.websystique.springmvc.model.Debit;

public interface ActDao {
	
	Act findById(long id);
	
	void saveAct(Act act);
	
	void updateAct(Act act);
	
	void deleteActById(long id);
	
	public List<Act> findAllActsByOwner(long ownerID); 
	
	public List<Act> findAllActsByContragentId(long contragentID);
	
	List<Act> findAllActsByPeriod(int ownerID, Date startDate, Date endDate); 

}
