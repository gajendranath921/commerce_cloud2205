/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { Component, SimpleChange } from '@angular/core';
import { noop } from 'lodash';

import { functionsUtils, TypedMap } from 'smarteditcommons';
import { createSimulateNgOnChanges } from 'testhelpers';
import { DropdownMenuComponent, IDropdownMenuItem } from './dropdownMenu';

describe('DropdownMenu', () => {
    let component: DropdownMenuComponent;

    @Component({
        selector: '',
        template: ''
    })
    class MockDropdownMenuItemComponent {}

    const mockDropdownItems: TypedMap<IDropdownMenuItem[]> = {
        callback: [
            {
                callback: noop
            }
        ],
        component: [
            {
                component: MockDropdownMenuItemComponent
            }
        ]
    };

    type Input = Partial<Pick<typeof component, 'dropdownItems'>>;
    let simulateNgOnChanges: ReturnType<typeof createSimulateNgOnChanges>;

    beforeEach(() => {
        component = new DropdownMenuComponent(null);

        simulateNgOnChanges = createSimulateNgOnChanges<Input>(component);
    });

    describe('ngOnChanges', () => {
        const errorMessage =
            'DropdownMenuComponent.validateDropdownItem - Dropdown Item must contain "callback" or "component"';

        it('throws an error if callback and component are provided', () => {
            expect(async () => {
                const dropdownItems = [
                    { ...mockDropdownItems.callback[0], ...mockDropdownItems.component[0] }
                ];
                try {
                    await simulateNgOnChanges({
                        dropdownItems: new SimpleChange(undefined, dropdownItems, false)
                    });
                    functionsUtils.assertFail();
                } catch (err) {
                    expect(err.message).toBe(errorMessage);
                }
            });
        });
    });

    describe('sets component or default component on clonedDropdownItems', () => {
        it('GIVEN callback WHEN ngOnChanges is called THEN default component will be set', () => {
            // Given
            component.dropdownItems = mockDropdownItems.callback;

            // When
            simulateNgOnChanges({
                dropdownItems: new SimpleChange(undefined, mockDropdownItems.callback, false)
            });

            // Assert
            expect(component.clonedDropdownItems[0].component).toBeDefined();
        });

        it('GIVEN component WHEN ngOnChanges is called THEN component property should not be affected', () => {
            // GIVEN
            component.dropdownItems = mockDropdownItems.component;

            // WHEN
            simulateNgOnChanges({
                dropdownItems: new SimpleChange(undefined, mockDropdownItems.component, false)
            });

            // THEN
            expect(component.clonedDropdownItems[0].component).toBe(MockDropdownMenuItemComponent);
        });
    });
});
