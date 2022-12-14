/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { CommonModule } from '@angular/common';
import { Component, NgModule } from '@angular/core';

import { moduleUtils, ICatalogDetailsService, SeEntryModule } from 'smarteditcommons';

@Component({
    selector: 'item-1',
    template: ` <div class="template_1">Hello</div> `
})
export class Item1Component {}

@Component({
    selector: 'item-2',
    template: ` <div class="template_2">World</div> `
})
export class Item2Component {}

@SeEntryModule('Outerapp')
@NgModule({
    imports: [CommonModule],
    declarations: [Item1Component, Item2Component],
    entryComponents: [Item1Component, Item2Component],
    providers: [
        moduleUtils.bootstrap(
            (catalogDetailsService: ICatalogDetailsService) => {
                catalogDetailsService.addItems([
                    {
                        component: Item1Component
                    }
                ]);

                catalogDetailsService.addItems([
                    {
                        component: Item2Component
                    }
                ]);
            },
            [ICatalogDetailsService]
        )
    ]
})
export class Outerapp {}
