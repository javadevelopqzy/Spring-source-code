package mycase;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import mycase.aop.*;

public class ContextMain {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//		Object bean1 = applicationContext.getBean(FactoryBeanTest.class, "haha", 100);
//		ContainListBean bean3 = (ContainListBean) applicationContext.getBean("containListBean");
//
//		bean3.getList().forEach(System.out::println);
//		MyEvent event = new MyEvent("这是消息源对象", "msg对象");
//		applicationContext.publishEvent(event);
		applicationContext.getBean(AopExposeProxyTestBean.class).test();
	}
}
