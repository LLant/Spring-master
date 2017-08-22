package TestSpring.springwithhibernate.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import TestSpring.springwithhibernate.dao.ITestHibernateDAO;
import TestSpring.springwithhibernate.service.ITestHibernateService;

@Service("testHibernateService")
public class TestHibernateServiceImpl implements ITestHibernateService {

	@Autowired
	private ITestHibernateDAO testHibernateDAO;

	@Override
	public void test() {
		Object o = this.testHibernateDAO.test();
		System.out.println(o);
	}

	@Override
	public boolean transfer(float money, int from, int to) throws Exception {
		if (money > 0) {
			try {
				this.testHibernateDAO.minusMoney(from, money);
//				 int i=1/0;
				this.testHibernateDAO.addMoney(to, money);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		} else {
			return false;
		}
	}

	@Override
	public Serializable save(Object o) {
		return this.testHibernateDAO.save(o);
	}

	@Override
	public <T> T getEntity(Class clazz, Serializable id) {
		return this.testHibernateDAO.getEntity(clazz, id);
	}

}