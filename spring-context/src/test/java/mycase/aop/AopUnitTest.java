package mycase.aop;

import org.junit.*;
import org.springframework.context.support.*;

import mycase.aop.cglib.*;
import mycase.aop.jdk.*;

public class AopUnitTest {

	@Test
	public void test() {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("mycase/aop_application_context.xml");
		// 动态代理
		applicationContext.getBean(DynamicProxyinterface.class).test();
		// CGLIB
		applicationContext.getBean(CglibBean.class).test();
	}
}
