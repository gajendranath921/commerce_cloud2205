/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { browser, by, element } from 'protractor';
import { WhiteToolbarComponentObject } from '../../../utils/components/WhiteToolbarComponentObject';
import { ItemMechanismPageObject } from './ItemMechanismPageObject';

describe('Configure toolbar', () => {
    const CSS_BUTTON_IMG_ACTION3 = 'button img[title="action3"]';
    const CSS_BUTTON_IMG_ACTION4 = 'button img[title="action4"]';
    const CSS_BUTTON_IMG_ACTION5 = 'button img[title="action5"]';
    const CSS_BUTTON_IMG_ACTION6 = 'button img[title="action6"]';

    describe('through outer toolbarservice', () => {
        beforeEach(async () => {
            await ItemMechanismPageObject.Actions.navigate();
        });

        it("items of type 'ACTION' and 'HYBRID_ACTION' will be added", async () => {
            await ItemMechanismPageObject.Assertions.assertTotalItemsCount(0);
            await ItemMechanismPageObject.Actions.clickSendActionsOuterButton();
            await ItemMechanismPageObject.Assertions.assertTotalItemsCount(4);

            await ItemMechanismPageObject.Assertions.assertActionHasCorrectAttribute(
                'action5',
                'alt',
                'action5'
            );
            await ItemMechanismPageObject.Assertions.assertActionHasCorrectAttribute(
                'action5',
                'src',
                '/icon5.png'
            );
            await ItemMechanismPageObject.Assertions.assertActionHasCorrectAttribute(
                'action6',
                'alt',
                'action6'
            );
            await ItemMechanismPageObject.Assertions.assertActionHasCorrectAttribute(
                'action6',
                'src',
                '/icon6.png'
            );
            await ItemMechanismPageObject.Assertions.assertActionHasCorrectAttribute(
                'action8_btn',
                'type',
                'button'
            );
            await ItemMechanismPageObject.Assertions.assertActionHasCorrectAttribute(
                'action8_btn_iconclass',
                'class',
                'hyicon hyicon-clone se-toolbar-menu-ddlb--button__icon'
            );
            await ItemMechanismPageObject.Assertions.assertActionHasCorrectAttribute(
                'action8_btn_lbl',
                'innerText',
                'ICON TEST'
            );
        });

        it("item of type 'HYBRID_ACTION' will display its template", async () => {
            await ItemMechanismPageObject.Assertions.assertTotalItemsCount(0);
            await ItemMechanismPageObject.Actions.clickSendActionsOuterButton();
            await ItemMechanismPageObject.Assertions.assertTotalItemsCount(4);

            await ItemMechanismPageObject.Actions.clickHybridActionButton();

            await ItemMechanismPageObject.Assertions.assertHybridActionTemplateHasText(
                'HYBRID ACTION TEMPLATE'
            );
        });

        it("item of type 'HYBRID_ACTION' will display its template, and will dissappear on click outside", async () => {
            await ItemMechanismPageObject.Assertions.assertTotalItemsCount(0);
            await ItemMechanismPageObject.Actions.clickSendActionsOuterButton();
            await ItemMechanismPageObject.Assertions.assertTotalItemsCount(4);

            await ItemMechanismPageObject.Actions.clickHybridActionButton();
            await ItemMechanismPageObject.Assertions.assertHybridActionTemplateHasText(
                'HYBRID ACTION TEMPLATE'
            );

            await ItemMechanismPageObject.Actions.clickOutside();
            await ItemMechanismPageObject.Assertions.assertHybricActionTemplateIsAbsent();
        });

        it("Callbacks will be executed successfully when items of type 'ACTION' and 'HYBRID_ACTION", async () => {
            await ItemMechanismPageObject.Actions.clickSendActionsOuterButton();

            await ItemMechanismPageObject.Actions.clickAction('action5');

            await ItemMechanismPageObject.Assertions.messageHasText('Action 5 called');
            await browser.switchToIFrame();
            await ItemMechanismPageObject.Assertions.messageHasText('');
            await browser.switchToParent();

            await ItemMechanismPageObject.Actions.clickAction('action6');
            await ItemMechanismPageObject.Assertions.messageHasText('Action 6 called');
            await browser.switchToIFrame();
            await ItemMechanismPageObject.Assertions.messageHasText('');
            await browser.switchToParent();
        });

        it("item of type 'TEMPLATE' will display its template", async () => {
            await ItemMechanismPageObject.Assertions.assertTotalItemsCount(0);
            await ItemMechanismPageObject.Actions.clickSendActionsOuterButton();
            await ItemMechanismPageObject.Assertions.assertTotalItemsCount(4);

            expect(await element(by.id('standardTemplate')).getText()).toBe('STANDARD TEMPLATE');
        });

        it('can remove toolbar items', async () => {
            // Arrange
            await ItemMechanismPageObject.Actions.clickSendActionsOuterButton();

            expect(await element(by.id('standardTemplate')).isPresent()).toBe(true);
            expect(await element(by.css(CSS_BUTTON_IMG_ACTION5)).isPresent()).toBe(true);
            expect(await element(by.css(CSS_BUTTON_IMG_ACTION6)).isPresent()).toBe(true);

            // Act
            await browser.click(by.id('removeActionsOuter'));

            // Assert
            await browser.waitForAbsence(element(by.id('standardTemplate')));
            await browser.waitForAbsence(element(by.css(CSS_BUTTON_IMG_ACTION5)));
            expect(await element(by.css(CSS_BUTTON_IMG_ACTION6)).isPresent()).toBe(true);
        });
    });

    describe('through inner toolbarservice', async () => {
        beforeEach(async () => {
            await ItemMechanismPageObject.Actions.navigate();
        });

        it("items of type 'ACTION' will be added", async () => {
            await ItemMechanismPageObject.Assertions.assertTotalItemsCount(0);
            await browser.switchToIFrame();
            await ItemMechanismPageObject.Actions.clickSendActionsInnerButton();
            await browser.switchToParent();
            await ItemMechanismPageObject.Assertions.assertTotalItemsCount(2);

            await ItemMechanismPageObject.Assertions.assertActionHasCorrectAttribute(
                'action3',
                'alt',
                'action3'
            );

            await ItemMechanismPageObject.Assertions.assertActionHasCorrectAttribute(
                'action4',
                'alt',
                'action4'
            );
        });

        it("Callbacks will be executed successfully when items of type 'ACTION'", async () => {
            await browser.switchToIFrame();
            await ItemMechanismPageObject.Actions.clickSendActionsInnerButton();

            await browser.switchToParent();
            await ItemMechanismPageObject.Actions.clickAction('action3');
            await ItemMechanismPageObject.Assertions.messageHasText('');
            await browser.switchToIFrame(false);
            await ItemMechanismPageObject.Assertions.messageHasText('Action 3 called');

            await browser.switchToParent();
            await ItemMechanismPageObject.Actions.clickAction('action4');

            await ItemMechanismPageObject.Assertions.messageHasText('');
            await browser.switchToIFrame(false);
            await ItemMechanismPageObject.Assertions.messageHasText('Action 4 called');
        });

        it(' can remove toolbar items', async () => {
            // Arrange
            await browser.switchToIFrame();
            await ItemMechanismPageObject.Actions.clickSendActionsInnerButton();

            await browser.switchToParent();
            expect(await element(by.css(CSS_BUTTON_IMG_ACTION3)).isPresent()).toBe(true);
            expect(await element(by.css(CSS_BUTTON_IMG_ACTION4)).isPresent()).toBe(true);
            await browser.switchToIFrame();

            // Act
            await browser.click(by.id('removeAction'));

            // Assert
            await browser.switchToParent();
            expect(await element(by.css(CSS_BUTTON_IMG_ACTION3)).isPresent()).toBe(true);
            await browser.waitForAbsence(element(by.css(CSS_BUTTON_IMG_ACTION4)));
        });
    });

    describe('through inner AND outer toolbarservice', async () => {
        beforeEach(async () => {
            await ItemMechanismPageObject.Actions.navigate();
        });

        it('Actions will not conflict', async () => {
            await ItemMechanismPageObject.Actions.clickSendActionsOuterButton();
            await browser.switchToIFrame();
            await ItemMechanismPageObject.Actions.clickSendActionsInnerButton();
            await browser.switchToParent();
            await ItemMechanismPageObject.Assertions.assertTotalItemsCount(6);

            await ItemMechanismPageObject.Assertions.assertActionHasCorrectAttribute(
                'action3',
                'alt',
                'action3'
            );
            await ItemMechanismPageObject.Assertions.assertActionHasCorrectAttribute(
                'action4',
                'alt',
                'action4'
            );
            await ItemMechanismPageObject.Assertions.assertActionHasCorrectAttribute(
                'action5',
                'alt',
                'action5'
            );
            await ItemMechanismPageObject.Assertions.assertActionHasCorrectAttribute(
                'action6',
                'alt',
                'action6'
            );
        });

        it('removing items does not conflict with each other', async () => {
            // Arrange
            await browser.switchToIFrame();
            await ItemMechanismPageObject.Actions.clickSendActionsInnerButton();

            await browser.switchToParent();
            await ItemMechanismPageObject.Actions.clickSendActionsOuterButton();

            expect(await element(by.id('standardTemplate')).isPresent()).toBe(true);
            expect(await element(by.css(CSS_BUTTON_IMG_ACTION3)).isPresent()).toBe(true);
            expect(await element(by.css(CSS_BUTTON_IMG_ACTION4)).isPresent()).toBe(true);
            expect(await element(by.css(CSS_BUTTON_IMG_ACTION5)).isPresent()).toBe(true);
            expect(await element(by.css(CSS_BUTTON_IMG_ACTION6)).isPresent()).toBe(true);
            await browser.switchToIFrame();

            // Act
            await browser.click(by.id('removeAction'));
            await browser.switchToParent();
            await ItemMechanismPageObject.Actions.clickSendActionsOuterButton();

            // Assert
            await browser.waitForAbsence(element(by.id('standardTemplate')));
            expect(await element(by.css(CSS_BUTTON_IMG_ACTION3)).isPresent()).toBe(true);
            await browser.waitForAbsence(element(by.css(CSS_BUTTON_IMG_ACTION4)));
            await browser.waitForAbsence(element(by.css(CSS_BUTTON_IMG_ACTION5)));
            expect(await element(by.css(CSS_BUTTON_IMG_ACTION6)).isPresent()).toBe(true);
        });
    });

    describe('Toolbar Context', async () => {
        const TOOLBAR_ITEM_KEY_ACTION6 = 'toolbar.action.action6';
        beforeEach(async () => {
            await ItemMechanismPageObject.Actions.navigate();
        });

        it('item will show the toolbar context component provided', async () => {
            await ItemMechanismPageObject.Actions.clickSendActionsOuterButton();
            await WhiteToolbarComponentObject.Actions.clickShowActionToolbarContext5();
            expect(
                await WhiteToolbarComponentObject.Elements.getToolbarItemContextByKey(
                    'toolbar.action.action5'
                ).isPresent()
            ).toBeTruthy();
            expect(
                await WhiteToolbarComponentObject.Elements.getToolbarItemContextTextByKey(
                    'toolbar.action.action5'
                )
            ).toBe('Action 5 - Context');
        });

        it('item will show the content of the toolbar context component provided', async () => {
            await ItemMechanismPageObject.Actions.clickSendActionsOuterButton();
            await WhiteToolbarComponentObject.Actions.clickShowHybridActionToolbarContext();
            expect(
                WhiteToolbarComponentObject.Elements.getToolbarItemContextByKey(
                    TOOLBAR_ITEM_KEY_ACTION6
                ).isPresent()
            ).toBeTruthy();
            expect(
                await WhiteToolbarComponentObject.Elements.getToolbarItemContextTextByKey(
                    TOOLBAR_ITEM_KEY_ACTION6
                )
            ).toBe('Hybrid Action 6 - Context');
        });

        it('item will show and hide the content of the toolbar context based on the event', async () => {
            await ItemMechanismPageObject.Actions.clickSendActionsOuterButton();
            await WhiteToolbarComponentObject.Actions.clickShowHybridActionToolbarContext();

            expect(
                await WhiteToolbarComponentObject.Elements.getToolbarItemContextByKey(
                    TOOLBAR_ITEM_KEY_ACTION6
                ).isPresent()
            ).toBeTruthy();

            await WhiteToolbarComponentObject.Actions.clickHideHybridActionToolbarContext();

            await browser.waitForAbsence(
                WhiteToolbarComponentObject.Elements.getToolbarItemContextByKey(
                    TOOLBAR_ITEM_KEY_ACTION6
                )
            );

            await WhiteToolbarComponentObject.Actions.clickShowHybridActionToolbarContext();
            expect(
                await WhiteToolbarComponentObject.Elements.getToolbarItemContextByKey(
                    TOOLBAR_ITEM_KEY_ACTION6
                ).isPresent()
            ).toBeTruthy();
        });
    });
});
