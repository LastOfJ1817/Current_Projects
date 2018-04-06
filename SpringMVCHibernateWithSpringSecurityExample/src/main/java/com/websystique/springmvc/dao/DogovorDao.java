package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.Dodovor;

public interface DogovorDao {
	
	void saveDogovor(Dodovor dogovor);
	
	void updateDogovor(Dodovor dogovor);
	
	void deleteDogovorById(long id);
	
	Dodovor findById(long id);

	List<Dodovor> findAllDogovors(); 
	
	List<Dodovor> findAllDogovorssForThePeriod(); 
	
	List<Dodovor> saveDebitsToExcel();
	
	List<Dodovor> findAllDogovorsByOwner(long ownerID); 

}
