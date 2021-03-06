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
		// 加逻辑的时候, 不要依赖执行的的先后顺序
		System.out.println("method around start!");
		org.aspectj.lang.Signature signature=pjp.getSignature();
		// 调用方法的参数
		Object[] obs=pjp.getArgs();
		org.aspectj.lang.JoinPoint.StaticPart part=pjp.getStaticPart();
		// 获取目标对象
		Object o=pjp.getTarget();
		System.out.println("methodName:"+o.getClass().getName()+"."+pjp.getSignature().getName());
		System.out.println("method around end!");
		// 调用proceed()方法，就会触发切入点方法执行
		return pjp.proceed();
	}
}
