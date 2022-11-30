/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { PopupOverlayObject } from './popupOverlayObject';

describe('Popup Overlay - ', () => {
    const HELLO_TEXT = 'Hello from component!';
    beforeEach(async () => {
        await PopupOverlayObject.Actions.navigate();
    });

    it('WHEN trigger is set to "click" the popup opens after click', async () => {
        await PopupOverlayObject.Actions.setTriggerToClick();
        await PopupOverlayObject.Actions.clickPopupOverlayAnchor();

        await PopupOverlayObject.Assertions.popupIsPresent(HELLO_TEXT);
    });

    it('WHEN trigger is set to "hover" the popup opens on mouseenter', async () => {
        await PopupOverlayObject.Actions.setTriggerToHover();
        await PopupOverlayObject.Actions.hoverOverAnchor();

        await PopupOverlayObject.Assertions.popupIsPresent(HELLO_TEXT);
    });

    it('WHEN trigger is set to "hover" the popup closes on mouseleave', async () => {
        await PopupOverlayObject.Actions.setTriggerToHover();
        await PopupOverlayObject.Actions.hoverOverAnchor();
        await PopupOverlayObject.Actions.hoverAwayAnchor();

        await PopupOverlayObject.Assertions.popupIsAbsent(HELLO_TEXT);
    });

    it('WHEN trigger is set to "always displayed" the popup is always open', async () => {
        await PopupOverlayObject.Actions.setTriggerToAlwaysDisplayed();

        await PopupOverlayObject.Assertions.popupIsPresent(HELLO_TEXT);
    });

    it('WHEN trigger is set to "always hidden" the popup is always hidden', async () => {
        await PopupOverlayObject.Actions.setTriggerToAlwaysHidden();
        await PopupOverlayObject.Actions.clickPopupOverlayAnchor();

        await PopupOverlayObject.Assertions.popupIsAbsent(HELLO_TEXT);
    });

    it('WHEN popup is opened the callback message is visible', async () => {
        await PopupOverlayObject.Actions.setTriggerToClick();
        await PopupOverlayObject.Actions.clickPopupOverlayAnchor();

        await PopupOverlayObject.Assertions.messageIsDisplayed('On Show');
    });

    it('WHEN popup is closed the callback message is visible', async () => {
        await PopupOverlayObject.Actions.setTriggerToClick();
        await PopupOverlayObject.Actions.clickPopupOverlayAnchor();
        await PopupOverlayObject.Actions.clickPopupOverlayAnchor();

        await PopupOverlayObject.Assertions.messageIsDisplayed('On Hide');
    });
});
