package mycase.resource;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class ResourceUnitTest {

	@Test
	public void test() {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("mycase/resource_application_context.xml");
	}

	@Test
	public void resourceExtendsTest() throws IOException {
		AbstractResourceImpl resource = new AbstractResourceImpl("mycase/resource_application_context.xml");
		System.out.println(resource.getFile().getAbsolutePath());
	}
}
