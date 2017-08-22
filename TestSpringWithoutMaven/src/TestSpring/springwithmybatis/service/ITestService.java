package TestSpring.springwithmybatis.service;

import java.util.List;

import TestSpring.springwithmybatis.model.Account;
import TestSpring.springwithmybatis.model.User;

public interface ITestService {

	public void test();

	public boolean transfer(float money, int from, int to) throws Exception;

	public int insertAccount(Account account) throws Exception;

	public Account findAccountById(int i);

	public User findUserById(int i);

	public List<Account> findAccountsById(int i);
}
