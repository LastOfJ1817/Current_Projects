package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.Contragent;

public interface ContragentDao {
	
	Contragent findById(long id);
	
	void saveContragent(Contragent contragent);
	
	void updateContragent(Contragent contragent);
	
	void deleteContragentById(long id);
	
	List<Contragent> findAllContragents(Long ownerID); 
	
	public List<Contragent> findAllContragents();

}
