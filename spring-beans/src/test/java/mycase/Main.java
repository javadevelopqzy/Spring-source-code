package mycase;

import mycase.factory.FactoryBeanTest;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class Main {

	public static void main(String[] args) {
		ClassPathResource resource = new ClassPathResource("applicationContext.xml");
		XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(resource);
		Object bean1 = xmlBeanFactory.getBean(FactoryBeanTest.class);
		System.out.println(bean1);
	}
}
