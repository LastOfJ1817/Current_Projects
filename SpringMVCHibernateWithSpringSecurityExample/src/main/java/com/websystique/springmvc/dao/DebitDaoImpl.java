package com.websystique.springmvc.dao;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.Debit;
import com.websystique.springmvc.model.Phone;


@Repository("DebitDao")
public class DebitDaoImpl extends AbstractDao <Long, Debit> implements DebitDao{

	@Override
	public void saveDebit(Debit debit) {
		persist(debit);
		
	}

	@Override
	public void updateDebit(Debit debit) {
		update(debit);
		
	}

	@Override
	public void deleteDebitById(long id) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("id", id));
		Debit debit = (Debit)crit.uniqueResult();
		delete(debit);
		
		
	}

	@Override
	public List<Debit> findAllDebits() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Debit> findAllDebitsForThePeriod() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Debit> saveDebitsToExcel() {
		File myExcelFile = new File("myExcelFile.xls");
		return null;
	}

	@Override
	public List<Debit> findAllDebitsByOwner(int ownerID) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("ownerID", (Long.parseLong(String.valueOf(ownerID)))));
		List<Debit> debits = (List<Debit>) crit.list();
		return debits;
		
	}

	@Override
	public Debit findById(long id) {
		Debit debit = getByKey(id);
		return debit;
	}

	@Override
	public List<Debit> findAllDebitsByPeriod(int ownerID, Date startDate, Date endDate) {
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
		return (List<Debit>) crit.list();
	}

	
	

}
