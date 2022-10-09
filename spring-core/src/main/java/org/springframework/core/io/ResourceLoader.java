/*
 * Copyright 2002-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.core.io;

import org.springframework.lang.Nullable;
import org.springframework.util.ResourceUtils;

/**
 * 定义资源加载器，主要应用于根据给定的资源文件地址返回对应的Resource
 * 加载资源（例如，类路径或文件系统资源）的策略接口。需要 org.springframework.context.ApplicationContext 来提供此功能以及扩展的
 * org.springframework.core.io.support.ResourcePatternResolver 支持。 DefaultResourceLoader 是一个独立的实现，
 * 可以在 ApplicationContext 之外使用，并且也被 ResourceEditor 使用。当在 ApplicationContext 中运行时，
 * 可以使用特定上下文的资源加载策略从字符串中填充 Resource 和 Resource[] 类型的 Bean 属性。
 * Strategy interface for loading resources (e.g., class path or file system
 * resources). An {@link org.springframework.context.ApplicationContext}
 * is required to provide this functionality plus extended
 * {@link org.springframework.core.io.support.ResourcePatternResolver} support.
 *
 * <p>{@link DefaultResourceLoader} is a standalone implementation that is
 * usable outside an ApplicationContext and is also used by {@link ResourceEditor}.
 *
 * <p>Bean properties of type {@code Resource} and {@code Resource[]} can be populated
 * from Strings when running in an ApplicationContext, using the particular
 * context's resource loading strategy.
 *
 * @author Juergen Hoeller
 * @since 10.03.2004
 * @see Resource
 * @see org.springframework.core.io.support.ResourcePatternResolver
 * @see org.springframework.context.ApplicationContext
 * @see org.springframework.context.ResourceLoaderAware
 */
public interface ResourceLoader {

	/** Pseudo URL prefix for loading from the class path: "classpath:". */
	String CLASSPATH_URL_PREFIX = ResourceUtils.CLASSPATH_URL_PREFIX;


	/**
	 * getResource()根据所提供资源的路径 location 返回 Resource 实例，但是它不确保该 Resource 一定存在，需要调用
	 * 该方法的主要实现是在其子类 DefaultResourceLoader 中实现
	 * Return a {@code Resource} handle for the specified resource location.
	 * <p>The handle should always be a reusable resource descriptor,
	 * allowing for multiple {@link Resource#getInputStream()} calls.
	 * <p><ul>
	 * <li>Must support fully qualified URLs, e.g. "file:C:/test.dat".
	 * <li>Must support classpath pseudo-URLs, e.g. "classpath:test.dat".
	 * <li>Should support relative file paths, e.g. "WEB-INF/test.dat".
	 * (This will be implementation-specific, typically provided by an
	 * ApplicationContext implementation.)
	 * </ul>
	 * <p>Note that a {@code Resource} handle does not imply an existing resource;
	 * you need to invoke {@link Resource#exists} to check for existence.
	 * @param location the resource location
	 * @return a corresponding {@code Resource} handle (never {@code null})
	 * @see #CLASSPATH_URL_PREFIX
	 * @see Resource#exists()
	 * @see Resource#getInputStream()
	 */
	Resource getResource(String location);

	/**
	 * 返回 ClassLoader 实例，对于想要获取 ResourceLoader 使用的 ClassLoader 用户来说，可以直接调用该方法来获取，
	 * Expose the {@link ClassLoader} used by this {@code ResourceLoader}.
	 * <p>Clients which need to access the {@code ClassLoader} directly can do so
	 * in a uniform manner with the {@code ResourceLoader}, rather than relying
	 * on the thread context {@code ClassLoader}.
	 * @return the {@code ClassLoader}
	 * (only {@code null} if even the system {@code ClassLoader} isn't accessible)
	 * @see org.springframework.util.ClassUtils#getDefaultClassLoader()
	 * @see org.springframework.util.ClassUtils#forName(String, ClassLoader)
	 */
	@Nullable
	ClassLoader getClassLoader();

}
