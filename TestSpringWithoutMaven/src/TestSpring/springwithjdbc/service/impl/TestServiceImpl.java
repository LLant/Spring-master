package TestSpring.springwithjdbc.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import TestSpring.springwithjdbc.dao.ITestDAO;
import TestSpring.springwithjdbc.service.ITestService;

@Service("testService")
public class TestServiceImpl implements ITestService {

	@Autowired
	private ITestDAO testDAO;

	@Override
	public void test() {

		Object o = this.testDAO.test();
		System.out.println(o);
	}

	@Override
	public boolean transfer(float money, int from, int to) throws Exception {
		if (money > 0) {
			try {
				this.testDAO.minusMoney(from, money);
//				int i = 1 / 0;
				this.testDAO.addMoney(to, money);
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Map<String, Object> findById(Serializable serializable) throws Exception {
		return this.testDAO.findById(serializable);
	}

	@Override
	public List<Map<String, Object>> findList() throws Exception {
		return this.testDAO.findList();
	}

}
