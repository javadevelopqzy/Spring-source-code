package mycase;

import mycase.factory.FactoryBeanTest;
import mycase.proxy.CustomBeanFactoryPostProcessor;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class BeanMain {

	public static void main(String[] args) {
		ClassPathResource resource = new ClassPathResource("applicationContext.xml");
		XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(resource);
		CustomBeanFactoryPostProcessor bean = xmlBeanFactory.getBean(CustomBeanFactoryPostProcessor.class);
		bean.postProcessBeanFactory(xmlBeanFactory);
		FactoryBeanTest bean1 = xmlBeanFactory.getBean(FactoryBeanTest.class);
		System.out.println(bean1.getAbc());
//		Object bean1 = xmlBeanFactory.getBean(FactoryBeanTest.class, "haha", 100);
//		System.out.println(bean1);
	}
}
