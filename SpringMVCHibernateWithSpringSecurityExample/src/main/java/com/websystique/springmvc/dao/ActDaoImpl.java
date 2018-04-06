package com.websystique.springmvc.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.Act;
import com.websystique.springmvc.model.Contragent;
import com.websystique.springmvc.model.Debit;

@Repository("ActDao")
public class ActDaoImpl extends AbstractDao<Long, Act> implements ActDao{

	@Override
	public Act findById(long id) {
		Act act = getByKey(id);
		return act;
	}

	@Override
	public void saveAct(Act act) {
		persist(act);
		
	}

	@Override
	public void updateAct(Act act) {
		update(act);
		
	}

	@Override
	public void deleteActById(long id) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("id", id));
		Act act = (Act)crit.uniqueResult();
		delete(act);
		
	}

	@Override
	public List<Act> findAllActsByOwner(long ownerID) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("ownerID", (Long.parseLong(String.valueOf(ownerID)))));
		crit.addOrder(Order.asc("date"));
		List<Act> acts = (List<Act>) crit.list();
		return acts;
	}

	@Override
	public List<Act> findAllActsByContragentId(long contragentID) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("contragentID", (Long.parseLong(String.valueOf(contragentID)))));
		List<Act> acts = (List<Act>) crit.list();
		return acts;
	}

	@Override
	public List<Act> findAllActsByPeriod(int ownerID, Date startDate, Date endDate) {
		Criteria crit = createEntityCriteria();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		crit.add(Restrictions.eq("ownerID", (Long.parseLong(String.valueOf(ownerID)))));
		if(startDate != null) {
            crit.add(Restrictions.ge("date", df.format(startDate.getTime())));
        }
        if(endDate != null) {
            crit.add(Restrictions.le("date", df.format(endDate.getTime())));
        }
        crit.addOrder(Order.asc("date"));
		return (List<Act>) crit.list();
	}

}
