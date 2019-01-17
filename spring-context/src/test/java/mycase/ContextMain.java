package mycase;

import mycase.cycle.*;
import mycase.factory.FactoryBeanTest;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContextMain {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

//		Object bean1 = applicationContext.getBean(FactoryBeanTest.class, "haha", 100);
		Bean3 bean3 = (Bean3) applicationContext.getBean("bean3");
		System.out.println(bean3.getDate());
	}
}
