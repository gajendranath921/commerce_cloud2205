/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { SelectObject } from './selectObject';

describe('Select', () => {
    beforeEach(() => {
        SelectObject.Actions.navigateToTestPage();
    });

    describe('- Basic', () => {
        const SELECT_ONE = 'select-one';
        it('GIVEN select trigger is clicked THEN menu is present', () => {
            SelectObject.Actions.clickSelectDropdownTrigger(SELECT_ONE);
            SelectObject.Assertions.selectDropdownMenuIsPresent(SELECT_ONE);
        });

        it('GIVEN select trigger is clicked when dropdown is open THEN menu is absent', () => {
            SelectObject.Actions.clickSelectDropdownTrigger(SELECT_ONE);
            SelectObject.Actions.clickSelectDropdownTrigger(SELECT_ONE);
            SelectObject.Assertions.selectDropdownMenuIsAbsent(SELECT_ONE);
        });

        it('Select placeholder exists', () => {
            SelectObject.Assertions.selectDropdownTriggerPlaceholderIsPresent(
                SELECT_ONE,
                'My placeholder'
            );
        });

        it('GIVEN select value is selected THEN the select menu is absent', () => {
            SelectObject.Actions.clickSelectDropdownTrigger(SELECT_ONE);
            SelectObject.Actions.clickMenuItemByValue(SELECT_ONE, 'label_0');
            SelectObject.Assertions.selectDropdownMenuIsAbsent(SELECT_ONE);
        });

        it('GIVEN select value is selected THEN the select output displays value', () => {
            SelectObject.Actions.clickSelectDropdownTrigger(SELECT_ONE);
            SelectObject.Actions.clickMenuItemByValue(SELECT_ONE, 'label_0');
            SelectObject.Assertions.selectDropdownOutputIsPresent('select-one-output', 'value_0');
        });

        it('GIVEN select value is selected THEN the placeholder value changes', () => {
            SelectObject.Actions.clickSelectDropdownTrigger(SELECT_ONE);
            SelectObject.Actions.clickMenuItemByValue(SELECT_ONE, 'label_0');
            SelectObject.Assertions.selectDropdownTriggerPlaceholderIsPresent(
                SELECT_ONE,
                'label_0'
            );
        });
    });
    describe('- With Initial Value', () => {
        const SELECT_TWO = 'select-two';
        it('Select placeholder exists with initial value label', () => {
            SelectObject.Assertions.selectDropdownTriggerPlaceholderIsPresent(
                SELECT_TWO,
                'label_0'
            );
        });

        it('GIVEN select dropdown menu item is clicked THEN placeholder is no longer set to initial value', () => {
            SelectObject.Actions.clickSelectDropdownTrigger(SELECT_TWO);
            SelectObject.Actions.clickMenuItemByValue(SELECT_TWO, 'label_1');
            SelectObject.Assertions.selectDropdownTriggerPlaceholderIsPresent(
                SELECT_TWO,
                'label_1'
            );
        });
    });

    describe('- Intergration with Angular Forms', () => {
        const SELECT_THREE = 'select-three';
        it('GIVEN select value is selected THEN the select output displays value using reactive forms', () => {
            SelectObject.Actions.clickSelectDropdownTrigger(SELECT_THREE);
            SelectObject.Actions.clickMenuItemByValue(SELECT_THREE, 'label_1');

            SelectObject.Assertions.selectDropdownOutputIsPresent('select-three-output', 'value_1');
        });

        it('GIVEN angular form control is initialized with value THEN the select placeholder should display value', () => {
            SelectObject.Assertions.selectDropdownTriggerPlaceholderIsPresent(
                SELECT_THREE,
                'label_0'
            );
        });
    });
});
