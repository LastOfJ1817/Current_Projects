package com.websystique.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.Contragent;
import com.websystique.springmvc.model.Debit;
import com.websystique.springmvc.model.Dodovor;
import com.websystique.springmvc.model.Phone;

@Repository("DogovorDao")
public class DogovorDaoImpl extends AbstractDao<Long, Dodovor> implements DogovorDao{

	@Override
	public void saveDogovor(Dodovor dogovor) {
		persist(dogovor);
		
	}

	@Override
	public void updateDogovor(Dodovor dogovor) {
		update(dogovor);
		
	}

	@Override
	public void deleteDogovorById(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Dodovor findById(long id) {
		Dodovor dogovor = getByKey(id);
		return dogovor;
	}

	@Override
	public List<Dodovor> findAllDogovors() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("number"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<Dodovor> dogovors = (List<Dodovor>) criteria.list();
		return dogovors;
		
	}

	@Override
	public List<Dodovor> findAllDogovorssForThePeriod() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Dodovor> saveDebitsToExcel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Dodovor> findAllDogovorsByOwner(long ownerID) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("ownerID", (Long.parseLong(String.valueOf(ownerID)))));
		crit.addOrder(Order.asc("number"));
		List<Dodovor> dogovors = (List<Dodovor>) crit.list();
		return dogovors;
	}
}
