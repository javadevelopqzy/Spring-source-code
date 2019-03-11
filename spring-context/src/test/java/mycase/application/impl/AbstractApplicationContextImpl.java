package mycase.application.impl;

import org.springframework.beans.*;
import org.springframework.beans.factory.config.*;
import org.springframework.context.support.*;

public class AbstractApplicationContextImpl extends AbstractApplicationContext {

	@Override
	protected void refreshBeanFactory() throws BeansException, IllegalStateException {

	}

	@Override
	protected void closeBeanFactory() {

	}

	@Override
	public ConfigurableListableBeanFactory getBeanFactory() throws IllegalStateException {
		return null;
	}
}
