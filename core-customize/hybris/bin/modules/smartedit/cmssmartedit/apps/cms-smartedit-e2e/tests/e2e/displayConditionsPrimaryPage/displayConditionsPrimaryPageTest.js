/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
describe('displayConditionsPrimaryPageTest', function () {
    var page = e2e.pageObjects.DisplayConditionsPrimaryPage;
    var component = e2e.componentObjects.DisplayConditionsPrimaryPage;
    const ASSERTION_DESCR = 'First Primary Page';

    beforeEach(function () {
        browser.bootstrap(__dirname);
    });

    describe('when read only', function () {
        beforeEach(function () {
            page.actions.clickReadOnlyCheckbox();
        });

        it('should display a label for the associated primary page', function () {
            component.assertions.associatedPrimaryPageLabelContainsText(
                'Primary page associated to the variation'
            );
        });

        it('should display the associated primary page name', function () {
            component.assertions.associatedPrimaryPageNameContainsText(ASSERTION_DESCR);
        });
    });

    describe('when read and write', function () {
        it('should have a dropdown with the selected option as the associated primary page', function () {
            component.assertions.selectedOptionContainsText(ASSERTION_DESCR);
        });

        it('should have a dropdown with all primary pages as options', function () {
            component.actions.togglePrimaryPagesSelector();

            component.assertions.optionContainsTextByIndex(ASSERTION_DESCR, 0);
            component.assertions.optionContainsTextByIndex('Second Primary Page', 1);
        });

        it('should trigger the onPrimaryPageSelect callback on selecting another primary page', function () {
            component.actions.togglePrimaryPagesSelector();

            component.actions.selectPrimaryPageByText('Second Primary Page');

            page.assertions.onPrimaryPageSelectedHaveBeenCalled();
        });
    });
});
