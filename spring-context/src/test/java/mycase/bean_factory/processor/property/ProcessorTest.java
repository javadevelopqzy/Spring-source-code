package mycase.bean_factory.processor.property;

import org.junit.*;
import org.springframework.context.support.*;

public class ProcessorTest {

	@Test
	public void test() {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("mycase/bean_factory/processor/bean_factory_processor_application_context.xml");
		applicationContext.getBean(OriginalBean.class).getPropertyBean().display();
	}
}
