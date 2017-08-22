package TestSpring.springwithhibernate.dao.impl;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import TestSpring.springwithhibernate.dao.ITestHibernateDAO;
import TestSpring.springwithhibernate.model.Account;

@Repository
public class TestHibernateDAOImpl extends HibernateDaoSupport implements ITestHibernateDAO{

	@Autowired
	public void setMySessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	
	@Override
	public Object test() {
		return null;
	}

	@Override
	public boolean addMoney(int userId, float money) {
		Account account=this.getHibernateTemplate().get(Account.class,userId);
		account.setMoney(account.getMoney()+money);
		try {
			this.getHibernateTemplate().update(account);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean minusMoney(int userId, float money) {
		Account account=this.getHibernateTemplate().get(Account.class, userId);
		account.setMoney(account.getMoney()-money);
		try {
			this.getHibernateTemplate().update(account);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Serializable save(Object o) {
		return this.getHibernateTemplate().save(o);
	}

	@Override
	public <T> T getEntity(Class clazz, Serializable id) {
		return (T) this.getHibernateTemplate().get(clazz, id);
	}

}
