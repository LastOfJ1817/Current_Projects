package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.Phone;


public interface PhoneService {
	
	Phone findById(long id);
	
	List <Phone> findByOwner(int owner_id);
	
	void save(Phone phone);
	
	void deleteByOwner(int owner_id);
	void deleteById (long id);
	
	List<Phone> findAllPhones();
	List<Phone> findABySSO(String SSO);

	void updatePhone(Phone phone);

	
}