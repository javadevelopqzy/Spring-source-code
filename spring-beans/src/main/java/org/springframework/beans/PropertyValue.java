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

package org.springframework.beans;

import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;

import java.io.Serializable;

/**
 * Object to hold information and value for an individual bean property.
 * Using an object here, rather than just storing all properties in
 * a map keyed by property name, allows for more flexibility, and the
 * ability to handle indexed properties etc in an optimized way.
 *
 * <p>Note that the value doesn't need to be the final required type:
 * A {@link BeanWrapper} implementation should handle any necessary conversion,
 * as this object doesn't know anything about the objects it will be applied to.
 *
 * @author Rod Johnson
 * @author Rob Harrop
 * @author Juergen Hoeller
 * @since 13 May 2001
 * @see PropertyValues
 * @see BeanWrapper
 */
// bean的property属性，每一个此类对象对应bean注入的一个property
@SuppressWarnings("serial")
public class PropertyValue extends BeanMetadataAttributeAccessor implements Serializable {

	// 属性的name（key）
	private final String name;

	// 属性未转换前的value
	// Spring定义了多种封装类型，此值可能是以下对象：
	// （1）BeanDefinitionHolder对象：<property>配置中有其他命名空间的XML节点
	// （2）RuntimeBeanReference对象：<property>配置了<ref>，bean依赖的另一个bean配置了<ref>时
	// （3）RuntimeBeanNameReference对象：<property>配置了<idref>标签，bean依赖的另一个bean配置了<idref>时
	// （4）TypedStringValue对象：<property>配置了value属性，先存在此包装类，实际类型未知
	// （5）ManagedArray对象：<property>配置了array标签，保存此包装类
	// （6）ManagedList对象：<property>配置了list标签，保存此包装类
	// （7）ManagedSet对象：<property>配置了set标签，保存此包装类
	// （8）ManagedMap对象：<property>配置了map标签，保存此包装类
	// （9）ManagedProperties对象：<property>配置了prop标签，保存此包装类
	@Nullable
	private final Object value;

	// 标识，是否是可选属性，如果是可选的，找不到此property的value时，将会忽略
	private boolean optional = false;

	// 标识，此属性是否已经被转换为实际的类型，因为从配置文件读取的都是String
	private boolean converted = false;

	// 转换后的值，如果原始值不需要转换则为空
	@Nullable
	private Object convertedValue;

	/** Package-visible field that indicates whether conversion is necessary. */
	@Nullable
	volatile Boolean conversionNecessary;

	/** Package-visible field for caching the resolved property path tokens. */
	@Nullable
	transient volatile Object resolvedTokens;


	/**
	 * Create a new PropertyValue instance.
	 * @param name the name of the property (never {@code null})
	 * @param value the value of the property (possibly before type conversion)
	 */
	public PropertyValue(String name, @Nullable Object value) {
		Assert.notNull(name, "Name must not be null");
		this.name = name;
		this.value = value;
	}

	/**
	 * Copy constructor.
	 * @param original the PropertyValue to copy (never {@code null})
	 */
	public PropertyValue(PropertyValue original) {
		Assert.notNull(original, "Original must not be null");
		this.name = original.getName();
		this.value = original.getValue();
		this.optional = original.isOptional();
		this.converted = original.converted;
		this.convertedValue = original.convertedValue;
		this.conversionNecessary = original.conversionNecessary;
		this.resolvedTokens = original.resolvedTokens;
		setSource(original.getSource());
		copyAttributesFrom(original);
	}

	/**
	 * Constructor that exposes a new value for an original value holder.
	 * The original holder will be exposed as source of the new holder.
	 * @param original the PropertyValue to link to (never {@code null})
	 * @param newValue the new value to apply
	 */
	public PropertyValue(PropertyValue original, @Nullable Object newValue) {
		Assert.notNull(original, "Original must not be null");
		this.name = original.getName();
		this.value = newValue;
		this.optional = original.isOptional();
		this.conversionNecessary = original.conversionNecessary;
		this.resolvedTokens = original.resolvedTokens;
		setSource(original);
		copyAttributesFrom(original);
	}


	/**
	 * Return the name of the property.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Return the value of the property.
	 * <p>Note that type conversion will <i>not</i> have occurred here.
	 * It is the responsibility of the BeanWrapper implementation to
	 * perform type conversion.
	 */
	// 属性未转换前的value
	@Nullable
	public Object getValue() {
		return this.value;
	}

	/**
	 * Return the original PropertyValue instance for this value holder.
	 * @return the original PropertyValue (either a source of this
	 * value holder or this value holder itself).
	 */
	public PropertyValue getOriginalPropertyValue() {
		PropertyValue original = this;
		Object source = getSource();
		while (source instanceof PropertyValue && source != original) {
			original = (PropertyValue) source;
			source = original.getSource();
		}
		return original;
	}

	/**
	 * Set whether this is an optional value, that is, to be ignored
	 * when no corresponding property exists on the target class.
	 * @since 3.0
	 */
	public void setOptional(boolean optional) {
		this.optional = optional;
	}

	/**
	 * Return whether this is an optional value, that is, to be ignored
	 * when no corresponding property exists on the target class.
	 * @since 3.0
	 */
	// 判断是否是可选的，如果是可选的，找不到此property的value时，将会忽略
	public boolean isOptional() {
		return this.optional;
	}

	/**
	 * Return whether this holder contains a converted value already ({@code true}),
	 * or whether the value still needs to be converted ({@code false}).
	 */
	// 标识，此属性是否已经被转换为实际的类型，因为从配置文件读取的都是String
	// 当转换成功后设置为true
	public synchronized boolean isConverted() {
		return this.converted;
	}

	/**
	 * Set the converted value of the constructor argument,
	 * after processed type conversion.
	 */
	// 设置转换后的值
	public synchronized void setConvertedValue(@Nullable Object value) {
		this.converted = true;
		this.convertedValue = value;
	}

	/**
	 * Return the converted value of the constructor argument,
	 * after processed type conversion.
	 */
	@Nullable
	public synchronized Object getConvertedValue() {
		return this.convertedValue;
	}


	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PropertyValue)) {
			return false;
		}
		PropertyValue otherPv = (PropertyValue) other;
		return (this.name.equals(otherPv.name) &&
				ObjectUtils.nullSafeEquals(this.value, otherPv.value) &&
				ObjectUtils.nullSafeEquals(getSource(), otherPv.getSource()));
	}

	@Override
	public int hashCode() {
		return this.name.hashCode() * 29 + ObjectUtils.nullSafeHashCode(this.value);
	}

	@Override
	public String toString() {
		return "bean property '" + this.name + "'";
	}

}
