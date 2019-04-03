package mycase.bean_factory.create_bean;

import java.util.*;

import org.junit.*;
import org.springframework.context.support.*;

public class DynamicCreateBeanTest {

	@Test
	public void test() {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("mycase/bean_factory/scope/bean_factory_scope_application_context.xml");
		System.out.println(applicationContext.getBeanFactory().createBean(InnerBean.class));
	}

	public static class InnerBean {

		String id;

		public InnerBean() {
			id = UUID.randomUUID().toString();
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		@Override
		public String toString() {
			return id;
		}
	}
}
