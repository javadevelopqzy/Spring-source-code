package mycase.factory;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryUnitTest {

	@Test
	public void test() {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("mycase/factory_application_context.xml");
		Object factory = applicationContext.getBean(ActualBean.class);
		System.out.println(factory);
	}
}
