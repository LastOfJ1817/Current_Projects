package com.websystique.springmvc.dao;
import java.util.List;

import com.websystique.springmvc.model.Phone;
import com.websystique.springmvc.model.User;

public interface PhoneDAO {
	
	Phone findById(long id);
	
	List <Phone> findByOwner(int owner_id);
	
	void save(Phone phone);
	
	void deleteByOwner(int owner_id);
	void deleteById (long id);
	
	List<Phone> findAllPhones();
	List<Phone> findABySSO(String SSO);
	
	public void updatePhone(Phone phone);


}