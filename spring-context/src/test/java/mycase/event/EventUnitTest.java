package mycase.event;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EventUnitTest {

	@Test
	public void test() {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("mycase/event_application_context.xml");
		applicationContext.publishEvent(new MyEvent("data", "msg"));
	}
}
