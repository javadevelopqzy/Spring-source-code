package mycase.resource;

import java.io.*;

import org.junit.*;
import org.springframework.core.io.*;

import mycase.resource.impl.*;
import mycase.resource.protocol.*;

public class ResourceUnitTest {

	@Test
	public void test() throws IOException {
		DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
		Resource resource = resourceLoader.getResource("mycase/resource_application_context.xml");
		System.out.println(resource.getFile().length());
	}

	@Test
	public void abstractResourceExtendsTest() throws IOException {
		AbstractResourceImpl resource = new AbstractResourceImpl("mycase/resource_application_context.xml");
		System.out.println(resource.getFile().length());
	}

	@Test
	public void abstractFileResolvingResourceExtendsTest() throws IOException {
		AbstractFileResolvingResourceImpl resource = new AbstractFileResolvingResourceImpl("mycase/resource_application_context.xml");
		System.out.println(resource.getFile().length());
	}

	@Test
	public void customProtocolTest() throws IOException {
		DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
		resourceLoader.addProtocolResolver(new QzyProtocolResolver());
		Resource resource = resourceLoader.getResource(QzyProtocolResolver.QZY_PROTOCOL_PREFIX + "mycase/resource_application_context.xml");
		System.out.println(resource.getFile().length());
	}
}
