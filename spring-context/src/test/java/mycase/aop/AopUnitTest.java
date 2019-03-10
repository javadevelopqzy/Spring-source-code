package mycase.aop;

import mycase.aop.cglib.CglibBean;
import mycase.aop.jdk.DynamicProxyinterface;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopUnitTest {

	@Test
	public void test(){
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("mycase/aop_application_context.xml");
		// 动态代理
		applicationContext.getBean(DynamicProxyinterface.class).test();
		// CGLIB
		applicationContext.getBean(CglibBean.class).test();
	}
}
