package mycase.lifecycle;

import org.junit.Test;
import org.springframework.context.support.*;

public class LifeCycleUnitTest {

	@Test
	public void test() {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("mycase/lifecycle_application_context.xml");
		System.out.println(applicationContext.getBean(LifeCycleImpl.class));
	}
}
