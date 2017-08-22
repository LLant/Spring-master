package TestSpring.springwithmybatis.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import TestSpring.springwithmybatis.dao.ITestXmlDAO;
import TestSpring.springwithmybatis.model.Account;
import TestSpring.springwithmybatis.service.ITestXmlService;

@Service("testXmlService")
public class TestXmlServiceImpl implements ITestXmlService {

	Logger logger = LoggerFactory.getLogger(TestXmlServiceImpl.class);

	@Resource
	private ITestXmlDAO testXmlDAO;

	@Override
	public int insertAccount(Account account) throws Exception {
		return this.testXmlDAO.insertAccount(account);
	}

	@Override
	public Account findAccountById(int i) {
		return this.testXmlDAO.getAccountById(i);
	}

	@Override
	public List<Account> findAccountsById(int i) {
		List<Account> accounts = this.testXmlDAO.findAccountsById(i);
		return accounts;
	}

}
