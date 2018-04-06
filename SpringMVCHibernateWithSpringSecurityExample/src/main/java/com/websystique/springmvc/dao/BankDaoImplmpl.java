package com.websystique.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.Bank;
import com.websystique.springmvc.model.Phone;


@Repository("bankDao")
public class BankDaoImplmpl extends AbstractDao <Long, Bank> implements BankDao{

	@Override
	public Bank findById(long id) {
		Bank bank = getByKey(id);
		return bank;
	}

	@Override
	public void deleteById(long id) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("id", id));
		Bank bank = (Bank)crit.uniqueResult();
		delete(bank);
		
	}

	@Override
	public void save(Bank bank) {
		persist(bank);
		
	}

	@Override
	public void updateBank(Bank bank) {
		update(bank);
		
	}

	@Override
	public List<Bank> findAllBanks() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("bankName"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<Bank> banks = (List<Bank>) criteria.list();
		return banks;
	}

}
