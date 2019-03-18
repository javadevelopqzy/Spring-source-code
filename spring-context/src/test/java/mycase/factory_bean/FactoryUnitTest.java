package mycase.factory_bean;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryUnitTest {

	@Test
	public void test() {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("mycase/factory_application_context.xml");
		mycase.factory_bean.ActualBean bean = (ActualBean) applicationContext.getBean("actualBean1");
		System.out.println(bean.getName());
	}
}
