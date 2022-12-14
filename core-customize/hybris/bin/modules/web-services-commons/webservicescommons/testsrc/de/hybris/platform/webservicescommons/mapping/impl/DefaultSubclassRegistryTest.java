/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.webservicescommons.mapping.impl;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.webservicescommons.mapping.config.SubclassMapping;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.context.ApplicationContext;

import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;


@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class DefaultSubclassRegistryTest
{
	@Mock
	private ApplicationContext ctx;
	private DefaultSubclassRegistry defaultSubclassRegistry;
	private Map<String, SubclassMapping> mapping;

	@Before
	public void setUp()
	{
		mapping = new HashMap<>();
		createSubclassMapping(TestParentDTO.class, TestDTO.class);
		createSubclassMapping(TestDTO.class, TestSubclassDTO.class);

		defaultSubclassRegistry = new DefaultSubclassRegistry();
	}

	protected void createSubclassMapping(final Class clazz, final Class subclass)
	{
		final SubclassMapping subclassMapping = new SubclassMapping();
		subclassMapping.setParentClass(clazz);
		final Set<Class> subclassesSet = new HashSet<>();
		subclassesSet.add(subclass);
		subclassMapping.setSubclassesSet(subclassesSet);
		mapping.put(clazz.getName(), subclassMapping);
	}

	@Test
	public void testGetSubclasses()
	{
		//given
		when(ctx.getBeansOfType(SubclassMapping.class)).thenReturn(mapping);
		defaultSubclassRegistry.setApplicationContext(ctx);
		defaultSubclassRegistry.init();

		//when
		final Set<Class> subclasses = defaultSubclassRegistry.getSubclasses(TestParentDTO.class);

		//then
		Assert.assertNotNull(subclasses);
		Assert.assertTrue(subclasses.contains(TestDTO.class));
		Assert.assertEquals(1, subclasses.size());
	}

	@Test
	public void testGetSubclassesWhenThereIsNoMapping()
	{
		//given
		when(ctx.getBeansOfType(SubclassMapping.class)).thenReturn(Collections.emptyMap());
		defaultSubclassRegistry.setApplicationContext(ctx);
		defaultSubclassRegistry.init();

		//when
		final Set<Class> subclasses = defaultSubclassRegistry.getSubclasses(TestParentDTO.class);

		//then
		Assert.assertNotNull(subclasses);
		Assert.assertTrue(subclasses.isEmpty());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetSubclassesWithNullParam()
	{
		//when
		defaultSubclassRegistry.getSubclasses(null);
	}

	@Test
	public void testGetAllSubclasses()
	{
		//given
		when(ctx.getBeansOfType(SubclassMapping.class)).thenReturn(mapping);
		defaultSubclassRegistry.setApplicationContext(ctx);
		defaultSubclassRegistry.init();

		//when
		final Set<Class> subclasses = defaultSubclassRegistry.getAllSubclasses(TestParentDTO.class);

		//then
		Assert.assertNotNull(subclasses);
		Assert.assertTrue(subclasses.contains(TestDTO.class));
		Assert.assertTrue(subclasses.contains(TestSubclassDTO.class));
		Assert.assertEquals(2, subclasses.size());
	}

	@Test
	public void testGetAllSubclassesWhenThereIsNoMapping()
	{
		//given
		lenient().when(ctx.getBeansOfType(SubclassMapping.class)).thenReturn(Collections.emptyMap());
		defaultSubclassRegistry.setApplicationContext(ctx);

		//when
		final Set<Class> subclasses = defaultSubclassRegistry.getAllSubclasses(TestParentDTO.class);

		//then
		Assert.assertNotNull(subclasses);
		Assert.assertTrue(subclasses.isEmpty());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetAllSubclassesWithNullParam()
	{
		//when
		defaultSubclassRegistry.getAllSubclasses(null);
	}

	@Test
	public void testRegisterSubclass()
	{
		//when
		defaultSubclassRegistry.registerSubclass(TestParentDTO.class, TestDTO.class);

		//then
		final Set<Class> subclasses = defaultSubclassRegistry.getSubclasses(TestParentDTO.class);
		Assert.assertNotNull(subclasses);
		Assert.assertTrue(subclasses.contains(TestDTO.class));
		Assert.assertEquals(1, subclasses.size());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRegisterSubclassWithNullParent()
	{
		//when
		defaultSubclassRegistry.registerSubclass(null, TestDTO.class);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRegisterSubclassWithNullSubclass()
	{
		//when
		defaultSubclassRegistry.registerSubclass(TestParentDTO.class, null);
	}

	@Test
	public void testRegisterSubclasses()
	{
		//given
		Set<Class> subclasses = Collections.singleton(TestDTO.class);

		//when
		defaultSubclassRegistry.registerSubclasses(TestParentDTO.class, subclasses);

		//then
		subclasses = defaultSubclassRegistry.getSubclasses(TestParentDTO.class);
		Assert.assertNotNull(subclasses);
		Assert.assertTrue(subclasses.contains(TestDTO.class));
		Assert.assertEquals(1, subclasses.size());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRegisterSubclassesWithNullParent()
	{
		//given
		final Set<Class> subclasses = Collections.singleton(TestDTO.class);

		//when
		defaultSubclassRegistry.registerSubclasses(null, subclasses);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRegisterSubclassesWithNullSubclasses()
	{
		//when
		defaultSubclassRegistry.registerSubclasses(TestParentDTO.class, null);
	}

	//Unregistering tests

	@Test
	public void testUnregisterSubclass()
	{
		//given
		defaultSubclassRegistry.registerSubclass(TestParentDTO.class, TestDTO.class);
		defaultSubclassRegistry.registerSubclass(TestParentDTO.class, Test2DTO.class);
		Set<Class> subclasses = defaultSubclassRegistry.getSubclasses(TestParentDTO.class);
		Assert.assertEquals(2, subclasses.size());

		//when
		defaultSubclassRegistry.unregisterSubclass(TestParentDTO.class, Test2DTO.class);

		//then
		subclasses = defaultSubclassRegistry.getSubclasses(TestParentDTO.class);
		Assert.assertNotNull(subclasses);
		Assert.assertTrue(subclasses.contains(TestDTO.class));
		Assert.assertEquals(1, subclasses.size());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testUneregisterSubclassWithNullParent()
	{
		//when
		defaultSubclassRegistry.unregisterSubclass(null, TestDTO.class);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testUnregisterSubclassWithNullSubclass()
	{
		//when
		defaultSubclassRegistry.unregisterSubclass(TestParentDTO.class, null);
	}

	@Test
	public void testUnregisterSubclasses()
	{
		//given
		defaultSubclassRegistry.registerSubclass(TestParentDTO.class, TestDTO.class);
		defaultSubclassRegistry.registerSubclass(TestParentDTO.class, Test2DTO.class);
		defaultSubclassRegistry.registerSubclass(TestParentDTO.class, TestSubclassDTO.class);
		Set<Class> subclasses = defaultSubclassRegistry.getSubclasses(TestParentDTO.class);
		Assert.assertEquals(3, subclasses.size());
		subclasses.remove(TestSubclassDTO.class);

		//when
		defaultSubclassRegistry.unregisterSubclasses(TestParentDTO.class, subclasses);

		//then
		subclasses = defaultSubclassRegistry.getSubclasses(TestParentDTO.class);
		Assert.assertNotNull(subclasses);
		Assert.assertTrue(subclasses.contains(TestSubclassDTO.class));
		Assert.assertEquals(1, subclasses.size());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testUnregisterSubclassesWithNullParent()
	{
		//given
		final Set<Class> subclasses = Collections.singleton(TestDTO.class);

		//when
		defaultSubclassRegistry.unregisterSubclasses(null, subclasses);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testUnregisterSubclassesWithNullSubclasses()
	{
		//when
		defaultSubclassRegistry.unregisterSubclasses(TestParentDTO.class, null);
	}

	@Test
	public void testUnregisterAllSubclasses()
	{
		//given
		defaultSubclassRegistry.registerSubclass(TestParentDTO.class, TestDTO.class);
		defaultSubclassRegistry.registerSubclass(TestParentDTO.class, Test2DTO.class);
		Set<Class> subclasses = defaultSubclassRegistry.getSubclasses(TestParentDTO.class);
		Assert.assertEquals(2, subclasses.size());

		//when
		defaultSubclassRegistry.unregisterSubclasses(TestParentDTO.class);

		//then
		subclasses = defaultSubclassRegistry.getSubclasses(TestParentDTO.class);
		Assert.assertNotNull(subclasses);
		Assert.assertTrue(subclasses.isEmpty());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testUneregisterAllSubclassesWithNullParent()
	{
		//when
		defaultSubclassRegistry.unregisterSubclasses(null);
	}


	private static class TestParentDTO
	{
		private String parentName;
	}

	private static class TestDTO extends TestParentDTO
	{
		private String name;
	}

	private static class Test2DTO extends TestParentDTO
	{
		private String name;
	}

	private static class TestSubclassDTO extends TestDTO
	{
		private String subclassName;
	}
}
