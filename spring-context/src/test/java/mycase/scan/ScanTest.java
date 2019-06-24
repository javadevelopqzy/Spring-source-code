package mycase.scan;

import org.junit.*;
import org.springframework.beans.factory.support.*;
import org.springframework.context.annotation.*;

public class ScanTest {

	@Test
	public void test() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.refresh();
		// 扫描
		ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner((BeanDefinitionRegistry) applicationContext.getBeanFactory());
		// 仅仅查找，不注册
		// System.out.println(scanner.findCandidateComponents("mycase.scan"));
		// 注册bean
		scanner.scan("mycase.scan");
		ScannerBean bean = applicationContext.getBean(ScannerBean.class);
		System.out.println(bean);
	}
}
