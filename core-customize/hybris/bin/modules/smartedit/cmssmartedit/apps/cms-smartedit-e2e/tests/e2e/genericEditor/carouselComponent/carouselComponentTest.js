/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
/* jshint unused:false, undef:false */
describe('Product Carousel Component - ', () => {
    var page = e2e.pageObjects.GenericEditor;
    var genericEditor = e2e.componentObjects.genericEditor;
    var productCarousel = e2e.componentObjects.productCarousel;
    var backendClient = e2e.mockBackendClient;
    const PRODUCT_STAGED = 'Asterisk SS youth black M';
    const PRODUCT_ONLINE = 'Avionics Shades Black';

    beforeEach(async () => {
        await browser.bootstrap(__dirname);
        await browser.get('/apps/cms-smartedit-e2e/generated/pages/smartedit.html#!/ng/carousel');
    });

    var componentData = {
        title: {
            EN: 'some title',
            IT: 'some title in italian'
        },
        products: {
            Staged: [PRODUCT_STAGED],
            Online: [PRODUCT_ONLINE]
        },
        categories: {
            Staged: ['Pants'],
            Online: ['Shirts']
        }
    };

    describe(
        'New component with change permissions for attributes products and categories - ' +
            'GIVEN a new product carousel component is added ',
        () => {
            beforeEach(async () => {
                await productCarousel.actions.prepareApp(true, true);
                await browser.waitForAngularEnabled(false);
            });

            it('THEN the editor can be saved', async () => {
                // GIVEN
                await page.actions.openGenericEditor();

                // WHEN
                await productCarousel.actions.setProductCarouselData(componentData);
                await genericEditor.actions.save();
                // THEN
                await page.actions.openGenericEditor();
                await productCarousel.assertions.hasRightData(componentData);
            });

            it(
                'WHEN the editor is opened ' +
                    'THEN the editor cannot be saved as it is not dirty ',
                async () => {
                    // GIVEN
                    await page.actions.openGenericEditor();

                    // THEN
                    await genericEditor.assertions.saveIsDisabled();
                }
            );

            it(
                'WHEN the editor is opened ' +
                    'THEN all fields in the editor are displayed correctly',
                async () => {
                    // GIVEN
                    await page.actions.openGenericEditor();

                    // THEN
                    await productCarousel.assertions.componentIsEmpty();
                }
            );
        }
    );

    describe('New component with read-only permissions for attributes products and categories - ', function () {
        beforeEach(async () => {
            await productCarousel.actions.prepareApp(false, false);
            await browser.waitForAngularEnabled(false);
        });

        it(
            'GIVEN a new product carousel component is added ' +
                'WHEN the editor is opened ' +
                'THEN the Add Items buttons are not displayed for product and categories attributes',
            async () => {
                // GIVEN
                await page.actions.openGenericEditor();

                // THEN
                await productCarousel.assertions.productsAddButtonIsNotDisplayed();
                await productCarousel.assertions.categoriesAddButtonIsNotDisplayed();
            }
        );
    });

    describe('Existing component - ', function () {
        let fixtureID0;

        beforeAll(async function () {
            fixtureID0 = await backendClient.modifyFixture(
                [
                    'cmssmarteditwebservices\\/v1\\/catalogs\\/apparel-ukContentCatalog\\/versions\\/Staged\\/workfloweditableitems'
                ],
                {
                    'editableItems.0.editableByUser': true
                }
            );
        });

        beforeEach(async () => {
            await productCarousel.actions.prepareApp(true, true);
            await page.actions.openGenericEditor();
            await productCarousel.actions.setProductCarouselData(componentData);
            await genericEditor.actions.save();
            await browser.waitForAngularEnabled(false);
        });

        it(
            'GIVEN the component already exists ' +
                'WHEN the editor is opened ' +
                'THEN the editor cannot be saved as it is not dirty ',
            async () => {
                // GIVEN
                await page.actions.openGenericEditor();

                // THEN
                await genericEditor.assertions.saveIsDisabled();
            }
        );

        describe('GIVEN the component already contains products ', function () {
            it('WHEN I reorder products and save ' + 'THEN their order is persisted', async () => {
                // GIVEN
                const originalOrder = [PRODUCT_STAGED, PRODUCT_ONLINE];
                const newOrder = [PRODUCT_ONLINE, PRODUCT_STAGED];
                await page.actions.openGenericEditor();
                await productCarousel.assertions.productsAreInRightOrder(originalOrder);

                // WHEN
                await productCarousel.actions.moveProductToPosition(0, 1);
                await genericEditor.actions.save();
                await page.actions.openGenericEditor();

                // THEN
                await productCarousel.assertions.productsAreInRightOrder(newOrder);
            });

            it('WHEN I move products up and save ' + 'THEN the new list is persisted', async () => {
                // GIVEN
                const originalOrder = [PRODUCT_STAGED, PRODUCT_ONLINE];
                const newExpectedOrder = [PRODUCT_ONLINE, PRODUCT_STAGED];
                await page.actions.openGenericEditor();
                await productCarousel.assertions.productsAreInRightOrder(originalOrder);

                // WHEN
                await productCarousel.actions.moveProductUp(1);
                await genericEditor.actions.save();

                await page.actions.openGenericEditor();

                // THEN
                await productCarousel.assertions.productsAreInRightOrder(newExpectedOrder);
            });

            it(
                'WHEN I move products down and save ' + 'THEN the new list is persisted',
                async () => {
                    // GIVEN
                    const originalOrder = [PRODUCT_STAGED, PRODUCT_ONLINE];
                    const newExpectedOrder = [PRODUCT_ONLINE, PRODUCT_STAGED];
                    await page.actions.openGenericEditor();
                    await productCarousel.assertions.productsAreInRightOrder(originalOrder);

                    // WHEN
                    await productCarousel.actions.moveProductDown(0);
                    await genericEditor.actions.save();

                    await page.actions.openGenericEditor();
                    // THEN
                    await productCarousel.assertions.productsAreInRightOrder(newExpectedOrder);
                }
            );

            it('WHEN I remove products and save ' + 'THEN the new list is persisted', async () => {
                // GIVEN
                const originalList = [PRODUCT_STAGED, PRODUCT_ONLINE];
                const newList = [PRODUCT_STAGED];
                await page.actions.openGenericEditor();
                await productCarousel.assertions.productsAreInRightOrder(originalList);

                // WHEN
                await productCarousel.actions.deleteProduct(1);
                await genericEditor.actions.save();

                await page.actions.openGenericEditor();
                // THEN
                await productCarousel.assertions.productsAreInRightOrder(newList);
            });
        });

        it(
            'GIVEN the component already contains categories ' +
                'WHEN I remove categories and save ' +
                'THEN the new list is persisted',
            async () => {
                // GIVEN
                const originalList = ['Pants', 'Shirts'];
                const newList = ['Pants'];

                await page.actions.openGenericEditor();

                await productCarousel.assertions.categoriesAreInRightOrder(originalList);

                // WHEN
                await productCarousel.actions.deleteCategory(1);
                await genericEditor.actions.save();

                // THEN
                await page.actions.openGenericEditor();
                await productCarousel.assertions.categoriesAreInRightOrder(newList);
            }
        );

        afterAll(function () {
            backendClient.removeFixture(fixtureID0);
        });

        // NOTE: We are only testing that products are given in the right order, as that can affect
        // how the carousel is displayed. The order of categories though doesn't have any noticeable effect.
    });
});
