/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { browser } from 'protractor';

export namespace CatalogDetailsPageObject {
    export const Actions = {
        async openAndBeReady(): Promise<void> {
            await browser.get('smartedit-e2e/generated/e2e/catalogDetails/#!/ng/storefront');
            await browser.waitForContainerToBeReady();
        }
    };
}
