package TestSpring.springwithhibernate.dao;

import java.io.Serializable;

public interface ITestHibernateDAO {

	public Object test();

	public boolean addMoney(int userId, float money);

	public boolean minusMoney(int userId, float money);

	public Serializable save(Object o);

	public <T> T getEntity(Class clazz, Serializable id);
//	前面的T就是泛型类型，后面的参数T表示的是自定义参数
//	<T>是泛型的默认值，可以被任意类型所代替
}
