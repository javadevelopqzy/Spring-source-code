/*
 * Copyright 2002-2012 the original author or authors.
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

package org.springframework.core;

import java.lang.reflect.*;

import org.springframework.lang.*;

/**
 * Interface to discover parameter names for methods and constructors.
 *
 * <p>Parameter name discovery is not always possible, but various strategies are
 * available to try, such as looking for debug information that may have been
 * emitted at compile time, and looking for argname annotation values optionally
 * accompanying AspectJ annotated methods.
 *
 * @author Rod Johnson
 * @author Adrian Colyer
 * @since 2.0
 */
// 基础接口参入method对象，返回参数名的方法
public interface ParameterNameDiscoverer {

	/**
	 * Return parameter names for this method,
	 * or {@code null} if they cannot be determined.
	 * @param method method to find parameter names for
	 * @return an array of parameter names if the names can be resolved,
	 * or {@code null} if they cannot
	 */
	// 根据method对象返回方法的所有参数名
	@Nullable
	String[] getParameterNames(Method method);

	/**
	 * Return parameter names for this constructor,
	 * or {@code null} if they cannot be determined.
	 * @param ctor constructor to find parameter names for
	 * @return an array of parameter names if the names can be resolved,
	 * or {@code null} if they cannot
	 */
	// 根据构造函数对象返回构造函数所有的参数名
	@Nullable
	String[] getParameterNames(Constructor<?> ctor);

}
