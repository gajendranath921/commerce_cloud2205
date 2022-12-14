/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved
 */
package com.hybris.backoffice.bulkedit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.anyObject;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.same;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import org.mockito.Mockito;

import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.media.MediaModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.interceptor.impl.InterceptorExecutionPolicy;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.session.SessionExecutionBody;
import de.hybris.platform.servicelayer.session.SessionService;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.commons.collections4.CollectionUtils;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;
import com.hybris.backoffice.attributechooser.Attribute;
import com.hybris.backoffice.attributechooser.AttributeChooserForm;
import com.hybris.backoffice.bulkedit.renderer.BulkEditAttributesSelectorRenderer;
import com.hybris.backoffice.widgets.notificationarea.NotificationService;
import com.hybris.backoffice.widgets.notificationarea.event.NotificationEvent;
import com.hybris.backoffice.widgets.notificationarea.event.NotificationEventTypes;
import com.hybris.cockpitng.config.jaxb.wizard.CustomType;
import com.hybris.cockpitng.config.jaxb.wizard.StepType;
import com.hybris.cockpitng.dataaccess.context.Context;
import com.hybris.cockpitng.dataaccess.context.impl.DefaultContext;
import com.hybris.cockpitng.dataaccess.facades.object.ObjectFacade;
import com.hybris.cockpitng.dataaccess.facades.object.ObjectFacadeOperationResult;
import com.hybris.cockpitng.dataaccess.facades.object.exceptions.ObjectSavingException;
import com.hybris.cockpitng.dataaccess.facades.permissions.PermissionFacade;
import com.hybris.cockpitng.dataaccess.facades.type.DataAttribute;
import com.hybris.cockpitng.dataaccess.facades.type.DataType;
import com.hybris.cockpitng.dataaccess.facades.type.TypeFacade;
import com.hybris.cockpitng.dataaccess.facades.type.exceptions.TypeNotFoundException;
import com.hybris.cockpitng.engine.WidgetInstanceManager;
import com.hybris.cockpitng.testing.util.CockpitTestUtil;
import com.hybris.cockpitng.type.ObjectValueService;
import com.hybris.cockpitng.validation.model.ValidationInfo;
import com.hybris.cockpitng.validation.model.ValidationSeverity;
import com.hybris.cockpitng.widgets.configurableflow.FlowActionHandlerAdapter;


@RunWith(MockitoJUnitRunner.class)
public class BulkEditHandlerTest
{
	@Mock
	private ObjectValueService objectValueService;
	@Mock
	private ObjectFacade objectFacade;
	@Mock
	private TypeFacade typeFacade;
	@Mock
	private PermissionFacade permissionFacade;
	@Mock
	private NotificationService notificationService;
	@Mock
	private ModelService modelService;
	@Mock
	private FlowActionHandlerAdapter adapter;
	@Mock
	private CustomType customType;
	@Mock
	private SessionService sessionService;
	@Mock
	private BulkEditValidationHelper bulkEditValidationHelper;

	@InjectMocks
	@Spy
	private BulkEditHandler handler;

	private WidgetInstanceManager wim;
	private Context context;

	@Before
	public void setUp()
	{
//		doNothing().when(handler).beginTransaction();
//		doNothing().when(handler).rollbackTransaction();
//		doNothing().when(handler).commitTransaction();
		wim = CockpitTestUtil.mockWidgetInstanceManager();
		when(adapter.getWidgetInstanceManager()).thenReturn(wim);
		context = new DefaultContext();
		doAnswer(inv -> ((SessionExecutionBody) inv.getArguments()[1]).execute()).when(sessionService)
				.executeInLocalViewWithParams(any(), any());
		when(handler.hasModifyPermission(any(), any())).thenReturn(true);
	}

	@Test
	public void notifyWhenValidationFails() throws TypeNotFoundException
	{
		//given
		final HashMap<String, String> params = new HashMap<>();
		final String qualifier = ProductModel.SUPERCATEGORIES;
		final ItemModel product = prepareBulkEditData(1, 2, params, qualifier, DataAttribute.AttributeType.MAP, true);
		final StepType stepType = mock(StepType.class);
		final Map<Object, List<ValidationInfo>> validationResult = new HashMap<>();
		final ValidationInfo info = mock(ValidationInfo.class);
		final List<ValidationInfo> infos = Lists.newArrayList(info);
		wim.getModel().put("allSteps", Lists.newArrayList(stepType, stepType));
		validationResult.put(product, infos);

		when(bulkEditValidationHelper.validateModifiedItems(any(), eq(ValidationSeverity.WARN))).thenReturn(validationResult);
		//when
		handler.perform(customType, adapter, params);

		//then
		final BulkEditForm bulkEditForm = wim.getModel().getValue("bulkEditForm", BulkEditForm.class);
		final List<ValidationResult> validations = bulkEditForm.getValidations();
		assertThat(validations).hasSize(1);
		assertThat(validations.get(0).getItem()).isEqualTo(product);
		assertThat(validations.get(0).getValidationInfos()).hasSize(1);
		assertThat(validations.get(0).getValidationInfos().get(0)).isEqualTo(info);
		verify(adapter).custom();
	}

	@Test
	public void changeCollectionValue() throws TypeNotFoundException
	{
		//given
		final ArrayList<String> newValue = Lists.newArrayList("a", "b");
		final ArrayList<String> oldValue = Lists.newArrayList("c");
		final HashMap<String, String> params = new HashMap<>();
		final ItemModel product = prepareBulkEditData(newValue, oldValue, params, ProductModel.SUPERCATEGORIES,
				DataAttribute.AttributeType.COLLECTION, false);
		//when
		handler.perform(customType, adapter, params);

		//then
		verify(objectValueService).setValue(eq(ProductModel.SUPERCATEGORIES), same(product),
				argThat(new ArgumentMatcher<Collection<String>>()
				{
					@Override
					public boolean matches(Collection<String> strings) {
						return strings.containsAll(Lists.newArrayList("a", "b", "c"));
					}
				}));
	}

	@Test
	public void changeCollectionValueWithOverride() throws TypeNotFoundException
	{
		//given
		final ArrayList<String> newValue = Lists.newArrayList("a", "b");
		final ArrayList<String> oldValue = Lists.newArrayList("c");
		final HashMap<String, String> params = new HashMap<>();
		final ItemModel product = prepareBulkEditData(newValue, oldValue, params, ProductModel.SUPERCATEGORIES,
				DataAttribute.AttributeType.COLLECTION, true);
		//when
		handler.perform(customType, adapter, params);

		//then
		verify(objectValueService).setValue(eq(ProductModel.SUPERCATEGORIES), same(product),
				argThat(new ArgumentMatcher<Collection<String>>()
				{
					@Override
					public boolean matches(Collection<String> strings) {
						return strings.containsAll(newValue) && !strings.containsAll(oldValue);
					}
				}));
	}

	@Test
	public void changeMapValue() throws TypeNotFoundException
	{
		//given
		final Map<String, String> newValue = new HashMap<>();
		newValue.put("a", "valA");
		newValue.put("b", "valB");

		final Map<String, String> oldValue = new HashMap<>();
		oldValue.put("c", "valC");
		final HashMap<String, String> params = new HashMap<>();
		final String qualifier = ProductModel.SUPERCATEGORIES;
		final ItemModel product = prepareBulkEditData(newValue, oldValue, params, qualifier, DataAttribute.AttributeType.MAP,
				false);
		//when
		handler.perform(customType, adapter, params);

		//then
		verify(objectValueService).setValue(eq(qualifier), same(product), argThat(new ArgumentMatcher<Map<String, String>>()
		{
			@Override
			public boolean matches(Map<String, String> stringStringMap) {
				return stringStringMap.entrySet().containsAll(CollectionUtils.union(newValue.entrySet(), oldValue.entrySet()));
			}
		}));
	}

	@Test
	public void changeMapValueWithOverride() throws TypeNotFoundException
	{
		//given
		final Map<String, String> newValue = new HashMap<>();
		newValue.put("a", "valA");
		newValue.put("b", "valB");

		final Map<String, String> oldValue = new HashMap<>();
		oldValue.put("c", "valC");
		final HashMap<String, String> params = new HashMap<>();
		final String qualifier = ProductModel.SUPERCATEGORIES;
		final ItemModel product = prepareBulkEditData(newValue, oldValue, params, qualifier, DataAttribute.AttributeType.MAP, true);
		//when
		handler.perform(customType, adapter, params);

		//then
		verify(objectValueService).setValue(eq(qualifier), same(product), argThat(new ArgumentMatcher<Map<String, String>>()
		{
			@Override
			public boolean matches(Map<String, String> stringStringMap) {
				return stringStringMap.entrySet().containsAll(newValue.entrySet()) && !stringStringMap.entrySet().containsAll(oldValue.entrySet());
			}
		}));
	}

	protected ItemModel prepareBulkEditData(final Object newValue, final Object oldValue, final HashMap<String, String> params,
			final String qualifier, final DataAttribute.AttributeType type, final boolean addQualifierToMerge)
			throws TypeNotFoundException
	{
		final DataAttribute categories = mockDataAttribute(qualifier, type);

		final Attribute attributeCategories = mockAttribute(categories);

		final ItemModel product = mock(ProductModel.class);
		final DataType dataType = mockDataTypeWithAttributes(ProductModel._TYPECODE, Lists.newArrayList(categories));
		when(typeFacade.getType(product)).thenReturn(ProductModel._TYPECODE);
		when(typeFacade.load(ProductModel._TYPECODE)).thenReturn(dataType);

		final HashSet<Attribute> chosenAttributes = Sets.newHashSet(attributeCategories);
		final ArrayList<Object> itemsToEdit = Lists.newArrayList(product);

		final BulkEditForm bulkEditForm = initBulkEditForm(chosenAttributes, itemsToEdit);
		if (!addQualifierToMerge)
		{
			bulkEditForm.addQualifierToMerge(categories.getQualifier());
		}

		params.put(BulkEditAttributesSelectorRenderer.PARAM_BULK_EDIT_FORM_MODEL_KEY, "bulkEditForm");


		final ObjectFacadeOperationResult saveFailure = new ObjectFacadeOperationResult();
		when(objectFacade.save(eq(bulkEditForm.getItemsToEdit()), any(Context.class))).thenReturn(saveFailure);


		when(objectValueService.getValue(attributeCategories.getQualifier(), bulkEditForm.getTemplateObject()))
				.thenReturn(newValue);
		when(objectValueService.getValue(attributeCategories.getQualifier(), product)).thenReturn(oldValue);
		return product;
	}

	private ItemModel mockTemplateObject()
	{
		final ItemModel templateObject = mock(ProductModel.class);
		when(typeFacade.getType(templateObject)).thenReturn(ProductModel._TYPECODE);
		return templateObject;
	}

	@Test
	public void changeLocalizedValue() throws TypeNotFoundException
	{
		//given
		final DataAttribute categories = mockDataAttribute(ProductModel.SUPERCATEGORIES, DataAttribute.AttributeType.SINGLE);
		when(categories.isLocalized()).thenReturn(true);

		final Attribute attributeCategories = mockAttribute(categories);
		attributeCategories.setSubAttributes(Sets.newHashSet(new Attribute(attributeCategories, Locale.ENGLISH.toLanguageTag()),
				new Attribute(attributeCategories, Locale.TRADITIONAL_CHINESE.toLanguageTag())));

		final ItemModel product = mock(ProductModel.class);
		final DataType dataType = mockDataTypeWithAttributes(ProductModel._TYPECODE, Lists.newArrayList(categories));
		when(typeFacade.getType(product)).thenReturn(ProductModel._TYPECODE);
		when(typeFacade.load(ProductModel._TYPECODE)).thenReturn(dataType);

		final HashSet<Attribute> chosenAttributes = Sets.newHashSet(attributeCategories);
		final ArrayList<Object> itemsToEdit = Lists.newArrayList(product);

		final BulkEditForm bulkEditForm = initBulkEditForm(chosenAttributes, itemsToEdit);

		final ObjectFacadeOperationResult saveFailure = new ObjectFacadeOperationResult();
		when(objectFacade.save(eq(bulkEditForm.getItemsToEdit()), any(Context.class))).thenReturn(saveFailure);

		final Map<Locale, String> newValue = new HashMap<>();
		newValue.put(Locale.TRADITIONAL_CHINESE, "newValue");
		newValue.put(Locale.ENGLISH, null);

		final Map<Locale, String> oldValue = new HashMap<>();
		oldValue.put(Locale.ENGLISH, "oldValueEnglish");

		when(objectValueService.getValue(attributeCategories.getQualifier(), bulkEditForm.getTemplateObject()))
				.thenReturn(newValue);
		when(objectValueService.getValue(attributeCategories.getQualifier(), product)).thenReturn(oldValue);
		//when
		handler.perform(customType, adapter, createParams());

		//then
		verify(objectValueService).setValue(eq(categories.getQualifier()), same(product),
				argThat(new ArgumentMatcher<Map<Locale, Object>>()
				{
					@Override
					public boolean matches(final Map<Locale, Object> map) {
						if (map.size() != 2) {
							return false;
						}

						final AtomicBoolean status = new AtomicBoolean(true);
						map.forEach((key, value) -> {
							if (!"newValue".equals(value) && !"oldValueEnglish".equals(value)) {
								status.set(false);
							}
						});

						return status.get();
					}
				}));
	}

	@Test
	public void clearLocalizedValue() throws TypeNotFoundException
	{
		//given
		final DataAttribute categories = mockDataAttribute(ProductModel.SUPERCATEGORIES, DataAttribute.AttributeType.SINGLE);
		when(categories.isLocalized()).thenReturn(true);

		final Attribute attributeCategories = mockAttribute(categories);
		attributeCategories.setSubAttributes(Sets.newHashSet(new Attribute(attributeCategories, Locale.ENGLISH.toLanguageTag()),
				new Attribute(attributeCategories, Locale.TRADITIONAL_CHINESE.toLanguageTag())));

		final ItemModel product = mock(ProductModel.class);
		final DataType dataType = mockDataTypeWithAttributes(ProductModel._TYPECODE, Lists.newArrayList(categories));
		when(typeFacade.getType(product)).thenReturn(ProductModel._TYPECODE);
		when(typeFacade.load(ProductModel._TYPECODE)).thenReturn(dataType);

		final Set<Attribute> chosenAttributes = Sets.newHashSet(attributeCategories);
		final List<Object> itemsToEdit = Lists.newArrayList(product);

		final BulkEditForm bulkEditForm = initBulkEditForm(chosenAttributes, itemsToEdit);
		bulkEditForm.addQualifierToClear(ProductModel.SUPERCATEGORIES);


		final HashMap<String, String> params = createParams();

		final ObjectFacadeOperationResult<Object> saveFailure = new ObjectFacadeOperationResult();
		when(objectFacade.save(eq(bulkEditForm.getItemsToEdit()), any(Context.class))).thenReturn(saveFailure);

		final Map<Locale, String> newValue = new HashMap<>();
		newValue.put(Locale.TRADITIONAL_CHINESE, "newValue");
		newValue.put(Locale.ENGLISH, null);

		final Map<Locale, String> oldValue = new HashMap<>();
		oldValue.put(Locale.ENGLISH, "oldValueEnglish");

		Mockito.lenient().when(objectValueService.getValue(attributeCategories.getQualifier(), bulkEditForm.getTemplateObject()))
				.thenReturn(newValue);
		when(objectValueService.getValue(attributeCategories.getQualifier(), product)).thenReturn(oldValue);
		//when
		handler.perform(customType, adapter, params);

		//then
		verify(objectValueService).setValue(eq(categories.getQualifier()), same(product),
				argThat(new ArgumentMatcher<Map<Locale, Object>>()
				{
					@Override
					public boolean matches(final Map<Locale, Object> map) {
						if (map.size() != 2) {
							return false;
						}

						final AtomicBoolean status = new AtomicBoolean(true);
						map.forEach((key, value) -> {
							if ("newValue".equals(value) || "oldValueEnglish".equals(value)) {
								status.set(false);
							}
						});

						return status.get();
					}
				}));
	}

	@Test
	public void clearValue() throws TypeNotFoundException
	{
		//given
		final DataAttribute categories = mockDataAttribute(ProductModel.SUPERCATEGORIES, DataAttribute.AttributeType.SINGLE);

		final Attribute attributeCategories = mockAttribute(categories);

		final ItemModel product = mock(ProductModel.class);
		final DataType dataType = mockDataTypeWithAttributes(ProductModel._TYPECODE, Lists.newArrayList(categories));
		when(typeFacade.getType(product)).thenReturn(ProductModel._TYPECODE);
		when(typeFacade.load(ProductModel._TYPECODE)).thenReturn(dataType);

		final Set<Attribute> chosenAttributes = Sets.newHashSet(attributeCategories);
		final List<Object> itemsToEdit = Lists.newArrayList(product);

		final BulkEditForm bulkEditForm = initBulkEditForm(chosenAttributes, itemsToEdit);
		bulkEditForm.addQualifierToClear(ProductModel.SUPERCATEGORIES);


		final HashMap<String, String> params = createParams();
		wim.getModel().setValue("bulkEditForm", bulkEditForm);


		final ObjectFacadeOperationResult saveFailure = new ObjectFacadeOperationResult();
		when(objectFacade.save(eq(bulkEditForm.getItemsToEdit()), any(Context.class))).thenReturn(saveFailure);

		Mockito.lenient().when(objectValueService.getValue(attributeCategories.getQualifier(), bulkEditForm.getTemplateObject())).thenReturn("a");
		Mockito.lenient().when(objectValueService.getValue(attributeCategories.getQualifier(), product)).thenReturn("b");
		//when
		handler.perform(customType, adapter, params);

		//then
		verify(objectValueService).setValue(eq(categories.getQualifier()), same(product),
				argThat(new ArgumentMatcher<Collection<String>>()
				{
					@Override
					public boolean matches(Collection<String> strings) {
						return Objects.isNull(strings);
					}
				}));
	}


	@Test
	public void doNothingOnMissingForm()
	{
		final Map<String, String> params = new HashMap<>();

		handler.perform(customType, adapter, params);

		verify(adapter, never()).done();
		verify(adapter, never()).cancel();
		verify(adapter, never()).next();
		verify(adapter, never()).back();
		verify(adapter, never()).custom();
	}

	@Test
	public void changeVariantAttribute() throws TypeNotFoundException
	{
		//given
		final DataAttribute color = mockDataAttribute("color", DataAttribute.AttributeType.SINGLE);
		when(color.isVariantAttribute()).thenReturn(true);

		final Attribute attributeColor = mockAttribute(color);

		final ItemModel product = mock(ProductModel.class);
		final DataType dataType = mockDataTypeWithAttributes(ProductModel._TYPECODE, Lists.newArrayList(color));
		when(typeFacade.getType(product)).thenReturn(ProductModel._TYPECODE);
		when(typeFacade.load(ProductModel._TYPECODE)).thenReturn(dataType);

		final Set<Attribute> chosenAttributes = Sets.newHashSet(attributeColor);
		final List<Object> itemsToEdit = Lists.newArrayList(product);

		final BulkEditForm bulkEditForm = initBulkEditForm(chosenAttributes, itemsToEdit);

		final Map<String, Object> variantAttributesMapModel = new HashMap<>();
		wim.getModel().setValue(BulkEditConstants.VARIANT_ATTRIBUTES_MAP_MODEL, variantAttributesMapModel);
		when(objectValueService.getValue(attributeColor.getQualifier(), variantAttributesMapModel)).thenReturn("red");

		final ObjectFacadeOperationResult saveResult = new ObjectFacadeOperationResult();
		when(objectFacade.save(eq(bulkEditForm.getItemsToEdit()), any(Context.class))).thenReturn(saveResult);
		//when(notificationService.getWidgetNotificationSource(any(WidgetInstanceManager.class))).thenReturn("test");

		//when
		handler.perform(customType, adapter, createParams());

		//then
		final InOrder inOrder = Mockito.inOrder(handler, objectValueService, objectFacade, notificationService);
		inOrder.verify(objectValueService).setValue(color.getQualifier(), product, "red");
		inOrder.verify(objectFacade).save(eq(itemsToEdit), any(Context.class));
		inOrder.verify(notificationService).notifyUser(nullable(String.class), eq(NotificationEventTypes.EVENT_TYPE_OBJECT_UPDATE),
				eq(NotificationEvent.Level.SUCCESS), any());
		inOrder.verifyNoMoreInteractions();
	}

	@Test
	public void changeVariantAttributeFailure() throws TypeNotFoundException
	{
		//given
		final DataAttribute color = mockDataAttribute("color", DataAttribute.AttributeType.SINGLE);
		when(color.isVariantAttribute()).thenReturn(true);

		final Attribute attributeColor = mockAttribute(color);

		final ItemModel product = mock(ProductModel.class);
		final DataType dataType = mockDataTypeWithAttributes(ProductModel._TYPECODE, Lists.newArrayList(color));
		when(typeFacade.getType(product)).thenReturn(ProductModel._TYPECODE);
		when(typeFacade.load(ProductModel._TYPECODE)).thenReturn(dataType);

		final Set<Attribute> chosenAttributes = Sets.newHashSet(attributeColor);
		final List<Object> itemsToEdit = Lists.newArrayList(product);

		final BulkEditForm bulkEditForm = initBulkEditForm(chosenAttributes, itemsToEdit);

		final Map<String, Object> variantAttributesMapModel = new HashMap<>();
		wim.getModel().setValue(BulkEditConstants.VARIANT_ATTRIBUTES_MAP_MODEL, variantAttributesMapModel);
		when(objectValueService.getValue(attributeColor.getQualifier(), variantAttributesMapModel)).thenReturn("red");

		final ObjectFacadeOperationResult saveResult = new ObjectFacadeOperationResult();
		saveResult.addFailedObject(product, mock(ObjectSavingException.class));
		when(objectFacade.save(eq(bulkEditForm.getItemsToEdit()), any(Context.class))).thenReturn(saveResult);
		//when(notificationService.getWidgetNotificationSource(any(WidgetInstanceManager.class))).thenReturn("test");
		//when
		handler.perform(customType, adapter, createParams());

		//then
		final InOrder inOrder = Mockito.inOrder(handler, objectValueService, objectFacade, modelService, notificationService);
		inOrder.verify(objectValueService).setValue(color.getQualifier(), product, "red");
		inOrder.verify(objectFacade).save(eq(itemsToEdit), any(Context.class));
		inOrder.verify(modelService).refresh(product);
		inOrder.verify(notificationService).notifyUser(nullable(String.class), eq(NotificationEventTypes.EVENT_TYPE_OBJECT_UPDATE),
				eq(NotificationEvent.Level.FAILURE), any());
		inOrder.verifyNoMoreInteractions();
	}

	@Test
	public void shouldNotSaveWhenNoPermission() throws TypeNotFoundException
	{
		//given
		final HashMap<String, String> params = new HashMap<>();
		final ItemModel product = prepareBulkEditData("newValue", "oldValue", params, ProductModel.EAN,
				DataAttribute.AttributeType.SINGLE, false);

		BulkEditForm form = wim.getModel().getValue("bulkEditForm", BulkEditForm.class);
		when(handler.hasModifyPermission(eq(form), eq(params))).thenReturn(false);
		//when
		handler.perform(customType, adapter, params);

		//then
		verifyNoMoreInteractions(objectFacade);
	}

	@Test
	public void shouldSaveWithInterceptorsWhenValidatedAllAttributes() throws TypeNotFoundException
	{
		//given
		final HashMap<String, String> params = new HashMap<>();
		final ItemModel product = prepareBulkEditData("newValue", "oldValue", params, ProductModel.EAN,
				DataAttribute.AttributeType.SINGLE, false);

		wim.getModel().getValue("bulkEditForm", BulkEditForm.class).setValidateAllAttributes(true);
		//when
		handler.perform(customType, adapter, params);

		//then
		verifyNoMoreInteractions(sessionService);
		verify(objectFacade).save(eq(Lists.newArrayList(product)), any(Context.class));
	}

	@Test
	public void shouldSaveWithoutInterceptorsWhenDidNotValidateAllAttributes() throws TypeNotFoundException
	{
		//given
		final Set<String> disabledInterceptorsBeanNames = new HashSet<>();
		final Map<String, Object> params2 = ImmutableMap.of(InterceptorExecutionPolicy.DISABLED_INTERCEPTOR_BEANS,
				Collections.unmodifiableSet(disabledInterceptorsBeanNames));

		final HashMap<String, String> params = new HashMap<>();
		final ItemModel product = prepareBulkEditData("newValue", "oldValue", params, ProductModel.EAN,
				DataAttribute.AttributeType.SINGLE, false);

		wim.getModel().getValue("bulkEditForm", BulkEditForm.class).setValidateAllAttributes(false);

		//when
		handler.perform(customType, adapter, params);

		//then
		verify(sessionService).executeInLocalViewWithParams(eq(params2), any());
		verify(objectFacade).save(eq(Lists.newArrayList(product)), any(Context.class));
	}

	@Test
	public void shouldSetValueFromDynamicAttributeHandler() throws TypeNotFoundException
	{
		//given
		final Attribute attribute = mockAttribute(mockDataAttribute("permittedPrincipals", DataAttribute.AttributeType.COLLECTION));
		final DynamicAttributeBulkEditHandler dynamicAttributeBulkEditHandler = mock(DynamicAttributeBulkEditHandler.class);
		when(dynamicAttributeBulkEditHandler.canHandle("permittedPrincipals")).thenReturn(true);

		//when
		handler.registerDynamicAttributeBulkEditHandler(dynamicAttributeBulkEditHandler);
		handler.setCollectionValue(mock(MediaModel.class), attribute, mock(BulkEditForm.class));

		//then
		verify(dynamicAttributeBulkEditHandler, Mockito.times(1)).getSelectedItems();
	}

	private DataType mockDataTypeWithAttributes(final String typeCode, final Collection<DataAttribute> attributes)
	{
		final DataType dataType = mock(DataType.class);
		Mockito.lenient().when(dataType.getCode()).thenReturn(typeCode);
		Mockito.lenient().when(dataType.getAttributes()).thenReturn(attributes);
		attributes.forEach(attr -> when(dataType.getAttribute(attr.getQualifier())).thenReturn(attr));
		return dataType;
	}

	private DataAttribute mockDataAttribute(final String attribute, final DataAttribute.AttributeType attributeType)
	{
		final DataAttribute da = mock(DataAttribute.class);
		when(da.getQualifier()).thenReturn(attribute);
		Mockito.lenient().when(da.getDefinedType()).thenReturn(DataType.STRING);
		Mockito.lenient().when(da.getValueType()).thenReturn(DataType.STRING);
		when(da.getAttributeType()).thenReturn(attributeType);
		return da;
	}

	protected Attribute mockAttribute(final DataAttribute approval)
	{
		return new Attribute(approval.getQualifier(), approval.getQualifier(), approval.isMandatory());
	}

	public BulkEditForm initBulkEditForm(final Set<Attribute> chosenAttributes, final List<Object> itemsToEdit)
	{
		final AttributeChooserForm attributesForm = new AttributeChooserForm();
		attributesForm.setChosenAttributes(chosenAttributes);

		final BulkEditForm bulkEditForm = new BulkEditForm();
		bulkEditForm.setItemsToEdit(itemsToEdit);
		bulkEditForm.setAttributesForm(attributesForm);
		bulkEditForm.setTemplateObject(mockTemplateObject());

		wim.getModel().setValue("bulkEditForm", bulkEditForm);

		return bulkEditForm;
	}

	public HashMap<String, String> createParams()
	{
		final HashMap<String, String> params = new HashMap<>();
		params.put(BulkEditAttributesSelectorRenderer.PARAM_BULK_EDIT_FORM_MODEL_KEY, "bulkEditForm");
		return params;
	}
}
