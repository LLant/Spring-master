package TestSpring.springwithjdbc.proxy;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyProxy {

	private Logger logger=Logger.getLogger(MyProxy.class);
	
	public void breforPerformance(){
		logger.info("MyProxy breforPerformance().");
	}
	public void afterPerformance(){
		logger.info("MyProxy afterPerformance().");
	}
	
	public Object aroundMethod(ProceedingJoinPoint pjp) throws Throwable{
		// ���߼���ʱ��, ��Ҫ����ִ�еĵ��Ⱥ�˳��
		System.out.println("method around start!");
		org.aspectj.lang.Signature signature=pjp.getSignature();
		// ���÷����Ĳ���
		Object[] obs=pjp.getArgs();
		org.aspectj.lang.JoinPoint.StaticPart part=pjp.getStaticPart();
		// ��ȡĿ�����
		Object o=pjp.getTarget();
		System.out.println("methodName:"+o.getClass().getName()+"."+pjp.getSignature().getName());
		System.out.println("method around end!");
		// ����proceed()�������ͻᴥ������㷽��ִ��
		return pjp.proceed();
	}
}