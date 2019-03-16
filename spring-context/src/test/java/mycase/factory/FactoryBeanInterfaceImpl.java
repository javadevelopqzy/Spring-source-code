package mycase.factory;

import org.springframework.beans.factory.*;

public class FactoryBeanInterfaceImpl implements FactoryBean {

	@Override
	public Object getObject() {
		return new ActualBean();
	}

	@Override
	public Class<?> getObjectType() {
		return ActualBean.class;
	}
}
