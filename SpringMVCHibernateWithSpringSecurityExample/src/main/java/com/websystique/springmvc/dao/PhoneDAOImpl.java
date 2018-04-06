package com.websystique.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.Phone;
import com.websystique.springmvc.model.User;
import com.websystique.springmvc.model.UserProfile;

@Repository("phoneDAO")
public class PhoneDAOImpl extends AbstractDao <Long, Phone> implements PhoneDAO{

	@Override
	public Phone findById(long id) {
		Phone phone = getByKey(id);
		return phone;
	}

	@Override
	public List<Phone> findByOwner(int ownerID) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("ownerID", (Long.parseLong(String.valueOf(ownerID)))));
		List<Phone> phones = (List<Phone>) crit.list();
		return phones;
//		User user = (User)crit.uniqueResult();
//		if(user!=null){
//			Hibernate.initialize(user.getUserProfiles());
//		}
//		
		
//		Criteria crit = createEntityCriteria();
//		crit.add(Restrictions.eq("type", type));
//		return (UserProfile) crit.uniqueResult();
//		
//		return null;
	}

	@Override
	public void save(Phone phone) {
		persist(phone);
		
	}

	@Override
	public void deleteByOwner(int owner_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(long id) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("id", id));
		Phone phone = (Phone)crit.uniqueResult();
		delete(phone);
		
	}

	@Override
	public List<Phone> findAllPhones() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("type"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<Phone> phones = (List<Phone>) criteria.list();
		
		// No need to fetch userProfiles since we are not showing them on list page. Let them lazy load. 
		// Uncomment below lines for eagerly fetching of userProfiles if you want.
		/*
		for(User user : users){
			Hibernate.initialize(user.getUserProfiles());
		}*/
		return phones;
	}

	@Override
	public List<Phone> findABySSO(String SSO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updatePhone(Phone phone) {
		update(phone);
		
	}

	
}
