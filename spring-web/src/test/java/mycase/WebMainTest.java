package mycase;

import org.springframework.web.context.support.*;

import mycase.factory.*;

public class WebMainTest {

	public static void main(String[] args) {
		XmlWebApplicationContext applicationContext = new XmlWebApplicationContext();
		applicationContext.setConfigLocation("applicationContext.xml");
		applicationContext.refresh();
		FactoryBeanTest bean = applicationContext.getBean(FactoryBeanTest.class);
		System.out.println(bean.getAbc());
	}
}
