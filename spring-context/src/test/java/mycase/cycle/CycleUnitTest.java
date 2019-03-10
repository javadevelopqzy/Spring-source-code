package mycase.cycle;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CycleUnitTest {

	@Test
	public void test() {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("mycase/cycle_application_context.xml");

	}
}
