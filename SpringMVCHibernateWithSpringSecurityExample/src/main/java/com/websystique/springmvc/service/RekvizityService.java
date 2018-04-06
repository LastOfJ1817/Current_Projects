package com.websystique.springmvc.service;

import java.util.List;


import com.websystique.springmvc.model.Rekvizity;

public interface RekvizityService {
	
	Rekvizity findById(long id);
	List <Rekvizity> findByOwner(long ownerID);
	
	void save(Rekvizity rekvizity);
	
	void deleteByOwner(int owner_id);
	void deleteById (long id);
	
	List<Rekvizity> findAllRekvizites();
	
	void updateRekvizity(Rekvizity rekvizity);

}
