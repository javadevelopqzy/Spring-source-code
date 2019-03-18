package mycase.factory_bean;

import org.springframework.beans.factory.*;

public class FactoryBeanInterfaceImpl implements FactoryBean {

	@Override
	public Object getObject() {
		return new mycase.factory_bean.ActualBean();
	}

	@Override
	public Class<?> getObjectType() {
		return ActualBean.class;
	}
}
