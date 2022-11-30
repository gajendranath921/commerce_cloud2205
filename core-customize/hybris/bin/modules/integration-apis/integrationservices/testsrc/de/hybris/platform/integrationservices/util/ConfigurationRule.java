/*
 *  Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.integrationservices.util;

import de.hybris.platform.core.Registry;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.rules.ExternalResource;
import org.slf4j.Logger;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * A test rule that automatically restores configuration changes done by the tests.
 * Type of the configuration service to be managed by this rule.
 */
public class ConfigurationRule<T> extends ExternalResource implements MethodInterceptor
{
	private static final Logger LOG = Log.getLogger(ConfigurationRule.class);
	private static final Object[] NO_ARGS = {};

	private final Map<Method, PropertyDescriptor> managedProperties;
	private final Map<Method, Object> initialValues;
	private final T configurationService;
	private T configurationServiceProxy;

	private ConfigurationRule(final T config)
	{
		configurationService = config;
		initialValues = new HashMap<>();
		managedProperties = derivePropertiesFor(config)
				.stream()
				.collect(Collectors.toMap(PropertyDescriptor::getWriteMethod, desc -> desc));
	}

	public static <C> ConfigurationRule<C> createFor(final String beanId, final Class<C> type)
	{
		final C config = getBean(beanId, type);
		return new ConfigurationRule<>(config);
	}

	public T configuration()
	{
		if (configurationServiceProxy == null)
		{
			configurationServiceProxy = createPropertyChangeTrackingProxyFor(configurationService);
		}
		return configurationServiceProxy;
	}

	private T createPropertyChangeTrackingProxyFor(final T config)
	{
		final var enhancer = new Enhancer();
		enhancer.setSuperclass(config.getClass());
		enhancer.setCallback(this);
		return (T) enhancer.create();
	}

	@Override
	public Object intercept(final Object o, final Method method, final Object[] args, final MethodProxy proxy)
			throws InvocationTargetException, IllegalAccessException
	{
		captureInitialValue(method);
		LOG.info("Calling {}({})", method.getName(), args);
		return method.invoke(configurationService, args);
	}

	private void captureInitialValue(final Method setter)
	{
		if (isInitialValueNotCaptured(setter) && isManagedSetterCalled(setter))
		{
			final Method getter = managedProperties.get(setter).getReadMethod();
			try
			{
				LOG.debug("Capturing current value of: {}", getter);
				final Object initialValue = getter.invoke(configurationService, NO_ARGS);
				LOG.info("Saving initial value {} for: {}", initialValue, getter);
				initialValues.put(setter, initialValue);
			}
			catch (final IllegalAccessException | InvocationTargetException e)
			{
				LOG.error("Failed to read initial value using: {}", getter);
			}
		}
	}

	private boolean isInitialValueNotCaptured(final Method method)
	{
		return !initialValues.containsKey(method);
	}

	private boolean isManagedSetterCalled(final Method method)
	{
		return managedProperties.containsKey(method);
	}

	private static <C> C getBean(final String beanId, final Class<C> type)
	{
		return Registry.getApplicationContext().getBean(beanId, type);
	}

	private static Set<PropertyDescriptor> derivePropertiesFor(final Object config)
	{
		try
		{
			final var beanInfo = Introspector.getBeanInfo(config.getClass());
			final PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
			return Stream.of(descriptors)
					.filter(desc -> desc.getWriteMethod() != null)
					.filter(desc -> desc.getReadMethod() != null)
					.collect(Collectors.toSet());
		}
		catch (final IntrospectionException e)
		{
			throw new IllegalStateException("Failed to retrieve configuration properties for " + config);
		}
	}

	@Override
	protected void after()
	{
		restoreInitialValues();
		initialValues.clear();
	}

	private void restoreInitialValues()
	{
		initialValues.entrySet().forEach(this::callSetterWithInitialValue);
	}

	private void callSetterWithInitialValue(final Map.Entry<Method, Object> e)
	{
		final Object[] args = { e.getValue() };
		try
		{
			e.getKey().invoke(configurationService, args);
		}
		catch (final IllegalAccessException | InvocationTargetException ex)
		{
			LOG.error("Failed to reset {} to {}", e.getKey(), e.getValue());
		}
	}
}
