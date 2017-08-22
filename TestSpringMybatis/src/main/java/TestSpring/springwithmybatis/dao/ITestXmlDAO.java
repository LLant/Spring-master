package TestSpring.springwithmybatis.dao;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Repository;

import TestSpring.springwithmybatis.model.Account;

@Repository("testXmlDAO")
public interface ITestXmlDAO {

	public int addMoney(int userId, float money);

	public int minusMoney(int userId, float money);

	@CacheEvict(value={"indexCache"},allEntries=true,beforeInvocation=true)
	public int insertAccount(Account account);
//	allEntries是boolean类型，表示是否需要清除缓存中的所有元素。默认为false，表示不需要。当指定了allEntries为true时，
//	Spring Cache将忽略指定的key。有的时候我们需要Cache一下清除所有的元素，这比一个一个清除元素更有效率
	
//	beforeInvocation清除操作默认是在对应方法成功执行之后触发的，即方法如果因为抛出异常而未能成功返回时也不会触发清除操作。
//	使用beforeInvocation可以改变触发清除操作的时间，当我们指定该属性值为true时，Spring会在调用该方法之前清除缓存中的指定元素
	@CacheEvict(value="indexCache",key="'xmlgetAccountById'+#id")
	public Account getAccountById(int id);
	@CacheEvict(value="indexCache",key="'xmlfindAccountsById'+#id")
	public List<Account> findAccountsById(int id);
}