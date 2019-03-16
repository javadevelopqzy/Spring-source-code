package mycase.factory;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryUnitTest {

	@Test
	public void test() {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("mycase/factory_application_context.xml");
		ActualBean bean = (ActualBean) applicationContext.getBean("actualBean1");
		System.out.println(bean.getName());
	}
}
