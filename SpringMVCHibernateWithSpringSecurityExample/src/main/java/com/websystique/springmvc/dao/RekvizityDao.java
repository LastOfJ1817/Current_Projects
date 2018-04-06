package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.Rekvizity;

public interface RekvizityDao {
	
	Rekvizity findById(long id);
	
	void save(Rekvizity rekvizity);
	
	void deleteByOwner(int owner_id);
	void deleteById (long id);
	
	List<Rekvizity> findAllRekvizites();
	
	void updateRekvizity(Rekvizity rekvizity);
	
	List<Rekvizity> findByOwner(long ownerID);

}
