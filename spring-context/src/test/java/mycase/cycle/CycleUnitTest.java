package mycase.cycle;

import org.junit.*;
import org.springframework.beans.factory.xml.*;
import org.springframework.core.io.*;

public class CycleUnitTest {

	@Test
	public void test() {
		ClassPathResource classPathResource = new ClassPathResource("mycase/cycle_application_context.xml");
		XmlBeanFactory applicationContext = new XmlBeanFactory(classPathResource);
		// 不允许出现循环依赖，因此加上之后下面会报错
		applicationContext.setAllowCircularReferences(false);
		Bean3 bean = applicationContext.getBean(Bean3.class);
	}
}
