package mycase.proxy;

import java.util.*;

import org.jetbrains.annotations.*;
import org.springframework.beans.*;
import org.springframework.beans.factory.config.*;
import org.springframework.core.*;
import org.springframework.util.*;

public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor, Ordered {

	Set<String> set;

	public void main() {
		System.out.println("hello!");
	}

	@Override
	public void postProcessBeanFactory(@NotNull ConfigurableListableBeanFactory beanFactory) throws BeansException {
		String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanDefinitionName);
			// 把属性值为bbc的替换为789
			StringValueResolver stringValueResolver = strVal -> {
				if (strVal.equals("bbc")) return "789";
				return strVal;
			};
			BeanDefinitionVisitor beanDefinitionVisitor = new BeanDefinitionVisitor(stringValueResolver);
			beanDefinitionVisitor.visitBeanDefinition(beanDefinition);
		}
		System.out.println("自定义的备案被调用了");
	}


	@Override
	public int getOrder() {
		return 0;
	}
}
