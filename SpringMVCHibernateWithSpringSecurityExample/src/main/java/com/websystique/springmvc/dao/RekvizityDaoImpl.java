package com.websystique.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.Bank;
import com.websystique.springmvc.model.Phone;
import com.websystique.springmvc.model.Rekvizity;
import com.websystique.springmvc.model.User;

@Repository("rekvizityDao")
public class RekvizityDaoImpl extends AbstractDao<Long, Rekvizity> implements RekvizityDao{

	@Override
	public Rekvizity findById(long id) {
		Rekvizity rekvizity = getByKey(id);
		return rekvizity;
	}

	@Override
	public void save(Rekvizity rekvizity) {
		persist(rekvizity);
		
	}

	@Override
	public void deleteByOwner(int owner_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(long id) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("id", id));
		Rekvizity rekvizity = (Rekvizity)crit.uniqueResult();
		delete(rekvizity);
		
	}

	@Override
	public List<Rekvizity> findAllRekvizites() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<Rekvizity> rekvizity = (List<Rekvizity>) criteria.list();
		return rekvizity;
	}

	@Override
	public void updateRekvizity(Rekvizity rekvizity) {
		update(rekvizity);
		
	}

	@Override
	public List<Rekvizity> findByOwner(long ownerID) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("ownerID", (Long.parseLong(String.valueOf(ownerID)))));
		List<Rekvizity> rekvizity = crit.list();
		return rekvizity;
	}

}
