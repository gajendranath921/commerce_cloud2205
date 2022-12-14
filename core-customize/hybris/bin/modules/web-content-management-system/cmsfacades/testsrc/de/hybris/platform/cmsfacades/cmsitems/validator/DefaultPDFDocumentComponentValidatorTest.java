/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmsfacades.cmsitems.validator;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.cms2.model.contents.components.PDFDocumentComponentModel;
import de.hybris.platform.cmsfacades.common.validator.ValidationErrors;
import de.hybris.platform.cmsfacades.common.validator.ValidationErrorsProvider;
import de.hybris.platform.cmsfacades.common.validator.impl.DefaultValidationErrors;
import de.hybris.platform.cmsfacades.languages.LanguageFacade;
import de.hybris.platform.cmsfacades.validator.data.ValidationError;
import de.hybris.platform.commercefacades.storesession.data.LanguageData;
import de.hybris.platform.core.model.media.MediaModel;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import static de.hybris.platform.cmsfacades.constants.CmsfacadesConstants.FIELD_REQUIRED_L10N;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@UnitTest
@RunWith(MockitoJUnitRunner.Silent.class)
public class DefaultPDFDocumentComponentValidatorTest
{
    @InjectMocks
    private DefaultPDFDocumentComponentValidator validator;

    @Mock
    private LanguageFacade languageFacade;
    @Mock
    private CommonI18NService commonI18NService;
    @Mock
    private ValidationErrorsProvider validationErrorsProvider;

    private ValidationErrors validationErrors = new DefaultValidationErrors();

    @Before
    public void setup()
    {
        final LanguageData language = new LanguageData();
        language.setRequired(true);
        language.setIsocode(Locale.ENGLISH.toLanguageTag());
        when(languageFacade.getLanguages()).thenReturn(Arrays.asList(language));
        when(commonI18NService.getLocaleForIsoCode(Locale.ENGLISH.toLanguageTag())).thenReturn(Locale.ENGLISH);
        when(validationErrorsProvider.getCurrentValidationErrors()).thenReturn(validationErrors);
    }

    @Test
    public void testValidatePDFWithoutRequiredAttributeAddErrors()
    {
        final MediaModel media = new MediaModel();

        final PDFDocumentComponentModel itemModel = new PDFDocumentComponentModel();
        itemModel.setPdfFile(media, Locale.ENGLISH);
        itemModel.setHeight(12);
        validator.validate(itemModel);

        final List<ValidationError> errors = validationErrorsProvider.getCurrentValidationErrors().getValidationErrors();

        assertEquals(1, errors.size());

        assertThat(errors.get(0).getField(), is(PDFDocumentComponentModel.PDFFILE));
        assertThat(errors.get(0).getErrorCode(), is(FIELD_REQUIRED_L10N));
    }


    @Test
    public void testValidatePDFWithVideoModelAddNoError()
    {
        final MediaModel media = new MediaModel();
        media.setCode("test");

        final PDFDocumentComponentModel itemModel = new PDFDocumentComponentModel();
        itemModel.setPdfFile(media, Locale.ENGLISH);
        itemModel.setHeight(12);
        validator.validate(itemModel);

        final List<ValidationError> errors = validationErrorsProvider.getCurrentValidationErrors().getValidationErrors();

        assertTrue(errors.isEmpty());
    }

    @Test
    public void testValidateHeightWithVideoModelAddNoError()
    {
        final MediaModel media = new MediaModel();
        media.setCode("test");

        final PDFDocumentComponentModel itemModel = new PDFDocumentComponentModel();
        itemModel.setPdfFile(media, Locale.ENGLISH);
        itemModel.setHeight(12);
        validator.validate(itemModel);

        final List<ValidationError> errors = validationErrorsProvider.getCurrentValidationErrors().getValidationErrors();

        assertTrue(errors.isEmpty());
    }
}
