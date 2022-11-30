/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { ConfirmModalServiceObject } from './confirmModalServiceObject';

describe('ConfirmationModalService', () => {
    beforeEach(async () => {
        await ConfirmModalServiceObject.Actions.navigateToTestPage();
    });

    describe('Modal with description - ', async () => {
        it('is present after button is triggered', async () => {
            await ConfirmModalServiceObject.Actions.clickTriggerButton();

            await ConfirmModalServiceObject.Assertions.modalIsPresent();
        });

        it('has valid texts', async () => {
            await ConfirmModalServiceObject.Actions.clickTriggerButton();

            await ConfirmModalServiceObject.Assertions.modalHasCorrectTitle(
                'my.confirmation.title'
            );
            await ConfirmModalServiceObject.Assertions.modalHasCorrectBody(
                'my.confirmation.message'
            );
        });
    });
});
