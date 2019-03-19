package mycase.bean_factory.scope;

import org.junit.*;
import org.springframework.context.support.*;

public class ThreadScopeUnitTest {

	@Test
	public void test() throws InterruptedException {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("mycase/bean_factory/scope/bean_factory_scope_application_context.xml");
		applicationContext.getBeanFactory().registerScope("thread", new ThreadScope());
		new Thread(
			() -> {
				ThreadScopeBean bean = applicationContext.getBean(ThreadScopeBean.class);
				// 线程重复获取bean，直接返回
				bean = applicationContext.getBean(ThreadScopeBean.class);
				bean = applicationContext.getBean(ThreadScopeBean.class);
			}
		).start();
		Thread.sleep(100);
		ThreadScopeBean bean = applicationContext.getBean(ThreadScopeBean.class);
		System.out.println(bean);
	}
}
