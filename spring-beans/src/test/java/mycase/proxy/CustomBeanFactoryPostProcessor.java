package mycase.proxy;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionVisitor;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.util.StringValueResolver;

import java.util.Set;

public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

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


}
