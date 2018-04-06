package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.Contragent;

public interface ContragentService {
	
	Contragent findById(long id);
	
	void saveContragent(Contragent contragent);
	
	void updateContragent(Contragent contragent);
	
	void deleteContragentById(long id);
	
	List<Contragent> findAllContragents(Long ownerID); 
	
	public List<Contragent> findAllContragents();

}
