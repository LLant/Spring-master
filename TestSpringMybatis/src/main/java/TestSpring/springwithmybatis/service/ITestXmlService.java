package TestSpring.springwithmybatis.service;

import java.util.List;

import TestSpring.springwithmybatis.model.Account;

public interface ITestXmlService {

	public int insertAccount(Account account) throws Exception;

	public Account findAccountById(int i);

	public List<Account> findAccountsById(int i);
}
