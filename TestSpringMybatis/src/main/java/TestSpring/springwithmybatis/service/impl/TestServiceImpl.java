package TestSpring.springwithmybatis.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import TestSpring.springwithmybatis.dao.ITestDAO;
import TestSpring.springwithmybatis.model.Account;
import TestSpring.springwithmybatis.service.ITestService;

@Service("testService")
public class TestServiceImpl implements ITestService {

	Logger logger = LoggerFactory.getLogger(TestServiceImpl.class);

	@Resource
	private ITestDAO testDAO;

	@Override
	public void test() {
	}

	@Override
	public boolean transfer(float money, int from, int to) throws Exception {
		this.testDAO.minusMoney(from, money);
		// int i = 1/0;
		this.testDAO.addMoney(to, money);
		return true;
	}

	@Override
	public int insertAccount(Account account) throws Exception {
		return this.testDAO.insertAccount(account);
	}

	@Override
	public Account findAccountById(int i) {
		return this.testDAO.getAccountById(i);
	}

	@Override
	public List<Account> findAccountsById(int i) {
		List<Account> accounts = this.testDAO.findAccountsById(i);
		return this.testDAO.findAccountsById(i);
	}

}
