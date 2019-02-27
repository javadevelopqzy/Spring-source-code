/*
 * Copyright 2002-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.aop.config;

import org.w3c.dom.Element;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.parsing.BeanComponentDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.lang.Nullable;

/**
 * Utility class for handling registration of auto-proxy creators used internally
 * by the '{@code aop}' namespace tags.
 *
 * <p>Only a single auto-proxy creator should be registered and multiple configuration
 * elements may wish to register different concrete implementations. As such this class
 * delegates to {@link AopConfigUtils} which provides a simple escalation protocol.
 * Callers may request a particular auto-proxy creator and know that creator,
 * <i>or a more capable variant thereof</i>, will be registered as a post-processor.
 *
 * @author Rob Harrop
 * @author Juergen Hoeller
 * @author Mark Fisher
 * @since 2.0
 * @see AopConfigUtils
 */
public abstract class AopNamespaceUtils {

	/**
	 * The {@code proxy-target-class} attribute as found on AOP-related XML tags.
	 */
	public static final String PROXY_TARGET_CLASS_ATTRIBUTE = "proxy-target-class";

	/**
	 * The {@code expose-proxy} attribute as found on AOP-related XML tags.
	 */
	private static final String EXPOSE_PROXY_ATTRIBUTE = "expose-proxy";


	public static void registerAutoProxyCreatorIfNecessary(
			ParserContext parserContext, Element sourceElement) {

		BeanDefinition beanDefinition = AopConfigUtils.registerAutoProxyCreatorIfNecessary(
				parserContext.getRegistry(), parserContext.extractSource(sourceElement));
		useClassProxyingIfNecessary(parserContext.getRegistry(), sourceElement);
		registerComponentIfNecessary(beanDefinition, parserContext);
	}

	public static void registerAspectJAutoProxyCreatorIfNecessary(
			ParserContext parserContext, Element sourceElement) {

		BeanDefinition beanDefinition = AopConfigUtils.registerAspectJAutoProxyCreatorIfNecessary(
				parserContext.getRegistry(), parserContext.extractSource(sourceElement));
		useClassProxyingIfNecessary(parserContext.getRegistry(), sourceElement);
		registerComponentIfNecessary(beanDefinition, parserContext);
	}

	// 注册AnnotationAwareAspectJAutoProxyCreator
	public static void registerAspectJAnnotationAutoProxyCreatorIfNecessary(
			ParserContext parserContext, Element sourceElement) {
		// 生成字节码增强类AnnotationAwareAspectJAutoProxyCreator的bean，并注册到beanFactory中
		BeanDefinition beanDefinition = AopConfigUtils.registerAspectJAnnotationAutoProxyCreatorIfNecessary(
				parserContext.getRegistry(), parserContext.extractSource(sourceElement));
		// 解析<aop:aspectj-autoproxy>的属性expose-proxy和proxy-target-class
		useClassProxyingIfNecessary(parserContext.getRegistry(), sourceElement);
		// 触发XML组件加载完的事件，目前是空实现，可以自行实现
		registerComponentIfNecessary(beanDefinition, parserContext);
	}

	// 解析<aop:aspectj-autoproxy>的属性expose-proxy和proxy-target-class
	private static void useClassProxyingIfNecessary(BeanDefinitionRegistry registry, @Nullable Element sourceElement) {
		if (sourceElement != null) {
			// 获取proxy-target-class属性
			boolean proxyTargetClass = Boolean.parseBoolean(sourceElement.getAttribute(PROXY_TARGET_CLASS_ATTRIBUTE));
			// 如果proxy-target-class=true，设置字节码增强类属性proxyTargetClass=true
			// proxyTargetClass表示使用什么代理方式，默认是false（类实现接口则JDK动态代理，未实现接口则CGLIB），true则强制使用CGLIB
			if (proxyTargetClass) {
				AopConfigUtils.forceAutoProxyCreatorToUseClassProxying(registry);
			}
			// 获取expose-proxy属性
			boolean exposeProxy = Boolean.parseBoolean(sourceElement.getAttribute(EXPOSE_PROXY_ATTRIBUTE));
			// 如果expose-proxy=true，表示每次获取代理类时放入一个ThreadLocal
			// 在被代理的bean内部可以通过方法AopContext.currentProxy()获取到代理对象，实现调用内部的方法也进行前置后置处理
			// 如：类mycase.aop.AopExposeProxyTestBean
			if (exposeProxy) {
				AopConfigUtils.forceAutoProxyCreatorToExposeProxy(registry);
			}
		}
	}

	// 触发XML组件加载完的事件，目前是空实现，可以自行实现
	private static void registerComponentIfNecessary(@Nullable BeanDefinition beanDefinition, ParserContext parserContext) {
		if (beanDefinition != null) {
			parserContext.registerComponent(
					new BeanComponentDefinition(beanDefinition, AopConfigUtils.AUTO_PROXY_CREATOR_BEAN_NAME));
		}
	}

}
