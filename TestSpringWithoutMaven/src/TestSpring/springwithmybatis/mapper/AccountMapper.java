package TestSpring.springwithmybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import TestSpring.springwithmybatis.model.Account;

public interface AccountMapper {

	public static String FIND_ACCOUNT_BY_ID="select "
			+ "id as id,"
			+ "name as name,"
			+ "money as money "
			+ "from account "
			+ "where"
			+ "id=#{id}";
	
	@Select(FIND_ACCOUNT_BY_ID)
	public List<Account> getAccountById(int id);
}
