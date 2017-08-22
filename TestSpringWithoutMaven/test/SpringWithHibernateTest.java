import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import TestSpring.springwithhibernate.model.Account;
import TestSpring.springwithhibernate.service.ITestHibernateService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContextwithhibernate.xml")
public class SpringWithHibernateTest {

	@Resource(name = "testHibernateService")
	private ITestHibernateService testHibernateService;

	@Test
	public void testTransation() {
		boolean b;
		try {
			b = testHibernateService.transfer(200, 1, 3);
			if (b) {
				System.out.println("ת�˳ɹ�");
			} else {
				System.out.println("ת��ʧ��");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ת��ʧ��");
		}
	}
	@Test
	public void testSave(){
		Account account=new Account();
		account.setName("zhong");
		account.setMoney(1000);
		this.testHibernateService.save(account);
	}
	
	@Test
	public void testget(){
		Account account=this.testHibernateService.getEntity(Account.class, 5);
		System.out.println(account);
	}
}
