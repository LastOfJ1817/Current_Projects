package com.websystique.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.Contragent;
import com.websystique.springmvc.model.Debit;
import com.websystique.springmvc.model.UserProfile;



@Repository("ContragentDao")
public class ContragentDaoImpl extends AbstractDao<Long, Contragent> implements ContragentDao{

	

	@Override
	public void saveContragent(Contragent contragent) {
		persist(contragent);
		
	}

	@Override
	public void updateContragent(Contragent contragent) {
		update(contragent);
		
	}

	@Override
	public void deleteContragentById(long id) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("id", id));
		Contragent contragent = (Contragent)crit.uniqueResult();
		delete(contragent);
		
	}

	@Override
	public List<Contragent> findAllContragents(Long ownerID) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("ownerID", ownerID));
		List<Contragent> contragents = (List<Contragent>) crit.list();
		return contragents;
	}
	
	
	@Override
	public List<Contragent> findAllContragents() {
		Criteria crit = createEntityCriteria();
		crit.addOrder(Order.asc("name"));
		//crit.addOrder(Order.asc("id"));
		return (List<Contragent>)crit.list();
	}

	@Override
	public Contragent findById(long id) {
		Contragent contragent = getByKey(id);
		return contragent;
	}

}
