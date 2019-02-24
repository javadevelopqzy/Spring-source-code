package mycase;

import mycase.cycle.*;
import mycase.factory.FactoryBeanTest;
import mycase.property.bean.*;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContextMain {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//		Object bean1 = applicationContext.getBean(FactoryBeanTest.class, "haha", 100);
		ContainListBean bean3 = (ContainListBean) applicationContext.getBean("containListBean");

		bean3.getList().forEach(System.out::println);
	}
}