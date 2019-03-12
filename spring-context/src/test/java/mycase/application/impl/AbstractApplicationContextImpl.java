package mycase.application.impl;

import java.io.*;

import org.jetbrains.annotations.*;
import org.springframework.beans.*;
import org.springframework.beans.factory.config.*;
import org.springframework.beans.factory.support.*;
import org.springframework.beans.factory.xml.*;
import org.springframework.context.support.*;
import org.springframework.core.io.*;

public class AbstractApplicationContextImpl extends AbstractApplicationContext {

	// 实现类内部必须持有beanFactory
	private DefaultListableBeanFactory beanFactory;
	private String path;

	public AbstractApplicationContextImpl(String path) {
		this.path = path;
		// 调用refresh方法
		refresh();
	}

	// 需要实现此方法，读取指定的XML文件，并且加载为BeanDefinition注册到beanFactory中
	@Override
	protected void refreshBeanFactory() throws BeansException, IllegalStateException {
		beanFactory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
		try {
			Resource[] resource = getResources(path);
			beanDefinitionReader.loadBeanDefinitions(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void closeBeanFactory() {
		this.beanFactory = null;
	}

	// 需要实现，返回持有的beanFactory
	@Override
	public ConfigurableListableBeanFactory getBeanFactory() throws IllegalStateException {
		return beanFactory;
	}

	@Override
	protected void initPropertySources() {
		System.out.println("-----------------------------");
		System.out.println("beanFactory初始化的前置处理");
		System.out.println("-----------------------------");
	}

	// 注册完所有的BeanDefinition的后置处理
	@Override
	protected void postProcessBeanFactory(@NotNull ConfigurableListableBeanFactory beanFactory) {
		System.out.println("-----------------------------");
		System.out.println("注册完所有的BeanDefinition的后置处理");
		System.out.println("-----------------------------");
	}

	// 准备注册监听器和实例化单例bean的前置处理
	// 已经实例化完BeanPostProcessor
	// 调用完所有BeanDefinitionRegistryPostProcessor和BeanFactoryPostProcessor了
	// 初始化完MessageSource和ApplicationEventMulticaster
	@Override
	protected void onRefresh() throws BeansException {
		System.out.println("-----------------------------");
		System.out.println("已经实例化完BeanPostProcessor、调用完所有BeanDefinitionRegistryPostProcessor和BeanFactoryPostProcessor了");
		System.out.println("初始化完MessageSource和ApplicationEventMulticaster了");
		System.out.println("准备注册监听器和实例化单例bean的前置处理");
		System.out.println("-----------------------------");
	}


}
