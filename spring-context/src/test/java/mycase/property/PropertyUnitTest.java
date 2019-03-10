package mycase.property;

import mycase.property.bean.ContainDateBean;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PropertyUnitTest {

	@Test
	public void test() {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("mycase/property_application_context.xml");
		System.out.println(applicationContext.getBean(ContainDateBean.class).getDate());
	}
}
