package mycase.application;

import org.junit.*;

import mycase.application.impl.*;

public class ApplicationUnitTest {

	@Test
	public void test() {
		AbstractApplicationContextImpl applicationContext = new AbstractApplicationContextImpl("mycase/lifecycle_application_context.xml");
	}
}
