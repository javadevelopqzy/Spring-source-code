package mycase.bean_factory.processor.property;

import org.springframework.beans.*;
import org.springframework.beans.factory.config.*;

public class InstantiationAwareBeanPostProcessorImpl implements InstantiationAwareBeanPostProcessor {

	// bean将要创建时的前置处理
	// 实现代理类，可以返回一个代理object
	@Override
	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
		/*
		if (beanClass == OriginalBean.class) {
			OriginalBean originalBean = new OriginalBean();
			PropertyBean propertyBean = new PropertyBean();
			propertyBean.setId("假装这是代理bean的属性");
			originalBean.setPropertyBean(propertyBean);
			return originalBean;
		}
		*/
		return null;
	}

	// 在bean已经实例化完毕调用此方法，可以根据bean自行设置属性，如果不需要spring进行属性注入返回false，否则返回true
	@Override
	public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
		if (bean instanceof OriginalBean) {
			PropertyBean propertyBean = new PropertyBean();
			propertyBean.setId("这是自己设置的属性");
			((OriginalBean) bean).setPropertyBean(propertyBean);
			return false;
		}
		System.out.println("创建bean" + beanName);
		return true;
	}

	// 给bean属性赋值的前置处理，实现此方法进行属性值处理
	@Override
	public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
		if (bean instanceof OriginalBean) {
			PropertyValue beanPropertyBean = pvs.getPropertyValue("propertyBean");
			assert beanPropertyBean != null;
		}
		return null;
	}
}
