package mycase.factory.processor;

import org.springframework.beans.*;
import org.springframework.beans.factory.config.*;

import mycase.factory.*;

public class FactoryBeanProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof ActualBean) {
			System.out.println("代理了bean");
			((ActualBean) bean).setName("设置一个新名字");
		}
		return bean;
	}
}
