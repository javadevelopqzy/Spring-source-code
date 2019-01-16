package mycase;

import mycase.factory.FactoryBeanTest;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContextMain {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

		Object bean1 = applicationContext.getBean(FactoryBeanTest.class, "haha", 100);
		System.out.println(bean1);
	}
}
