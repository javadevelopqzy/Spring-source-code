package mycase.lifecycle;

import org.springframework.beans.*;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.*;
import org.springframework.context.*;
import org.springframework.core.env.*;
import org.springframework.core.io.*;
import org.springframework.util.*;

public class LifeCycleBean implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware,
		EnvironmentAware, EmbeddedValueResolverAware, ResourceLoaderAware, ApplicationEventPublisherAware,
		MessageSourceAware, ApplicationContextAware, BeanPostProcessor, InitializingBean, DisposableBean {

	// bean的名称获取
	@Override
	public void setBeanName(String name) {
		System.out.println("beanName:" + name);
	}

	// beanClassLoader的获取
	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {
		System.out.println("classLoader:" + classLoader);
	}

	// IOC容器的获取
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("beanFactory:" + beanFactory);
	}

	// 环境信息的获取
	@Override
	public void setEnvironment(Environment environment) {
		System.out.println("environment:" + environment);
	}

	// EmbeddedValueResolver可以把bean属性配置的变量（${}形式）解析成实际的值
	@Override
	public void setEmbeddedValueResolver(StringValueResolver resolver) {
		System.out.println("resolver:" + resolver);
	}

	// ResourceLoader提供了加载文件的API
	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
	}

	// 获取spring事件发布对象，applicationEventPublisher可以推送自定义事件
	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
	}

	// 消息源的获取，国际化相关的处理
	@Override
	public void setMessageSource(MessageSource messageSource) {
	}

	// Application的获取，是beanFactory的扩展接口，包含IOC容器以及应用相关的API
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
	}

	// 实例化的前置处理
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return null;
	}

	// 实例化完的处理
	@Override
	public void afterPropertiesSet() throws Exception {

	}

	// 实例化的后置处理
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return null;
	}

	// 销毁的处理
	@Override
	public void destroy() throws Exception {

	}
}
