import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import TestSpring.springwithjdbc.dynamicdatasource.DatabaseContextHolder;
import TestSpring.springwithjdbc.service.ITestService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContextwithjdbc.xml")
public class SpringWithJdbcTest {

	@Resource(name = "testService")
	private ITestService testService;

	@Test
	public void test() {
		boolean b;
		try {
			b = this.testService.transfer(200, 1, 2);
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
	public void testFind() {
		try {
			DatabaseContextHolder.setDataSourceOne();
			Map<String, Object> map = testService.findById(1);
			System.out.println("one>>" + map);

			DatabaseContextHolder.setDataSourceTwo();
			Map<String, Object> map1 = testService.findById(1);
			System.out.println("two>>" + map1);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
