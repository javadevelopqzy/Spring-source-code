package mycase.environment;

import org.junit.*;
import org.springframework.context.support.*;

import mycase.environment.bean.*;

public class EnvironmentUnitTest {

	@Test
	public void test() {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[] { "mycase/environment_application_context.xml" }, false);
		// 设置为开发环境
//		applicationContext.getEnvironment().setActiveProfiles("dev");
//		applicationContext.refresh();
//		EnvironmentDevBean bean = applicationContext.getBean(EnvironmentDevBean.class);
//		System.out.println(bean);

		// 设置为生产环境
		applicationContext.getEnvironment().setActiveProfiles("pro");
		applicationContext.refresh();
		EnvironmentProBean bean = applicationContext.getBean(EnvironmentProBean.class);
		System.out.println(bean);
	}
}
