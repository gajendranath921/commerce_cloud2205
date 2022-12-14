/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
describe('Delete Page Menu', function () {
    var confirmationModal = e2e.componentObjects.confirmationModal;
    var pageList = e2e.pageObjects.PageList;
    var perspective = e2e.componentObjects.modeSelector;
    var popover = e2e.componentObjects.popover;
    var storefront = e2e.componentObjects.storefront;
    var alerts = e2e.componentObjects.alerts;
    var deletePageMenu = e2e.pageObjects.DeletePageMenu;
    var workflow = e2e.componentObjects.workflow;
    var backendClient = e2e.mockBackendClient;
    var DELETABLE_PAGE_NAME = 'Some Other Page';

    beforeEach(function () {
        browser.bootstrap(__dirname);
        browser.waitForWholeAppToBeReady();
    });

    afterEach(function () {
        browser.waitForAngularEnabled(true);
    });

    describe('Non-Deletable page not in workflow', function () {
        beforeEach(function (done) {
            workflow.utils.setNumberOfWorkflowsToReturn(0);
            perspective.select(perspective.BASIC_CMS_PERSPECTIVE).then(function () {
                done();
            });
        });

        afterEach(function (done) {
            perspective.select(perspective.PREVIEW_PERSPECTIVE).then(function () {
                done();
            });
        });

        it('GIVEN the user is on the storefront view of a non-deletable page THEN the "move to trash" option is rendered inactive AND I expect a popover to get rendered on hover with a meaningful message.', function () {
            deletePageMenu.assertions.deletePageMenuIconIsInactive();
            deletePageMenu.actions.hoverOnDeletePageMenu();
            popover.assertions.isDisplayedWithProvidedText(
                'This is the homepage. It cannot be moved to trash.'
            );
        });
    });

    describe('Non-Deletable page in workflow', function () {
        let fixtureID0;

        beforeAll(async function () {
            fixtureID0 = await backendClient.replaceFixture(
                [
                    'cmswebservices\\/v1\\/catalogs\\/apparel-ukContentCatalog\\/versions\\/Staged\\/workflows'
                ],
                {
                    pagination: {
                        count: 1,
                        page: 0,
                        totalCount: 0,
                        totalPages: 0
                    },
                    workflows: [
                        {
                            createVersion: false,
                            description: '',
                            isAvailableForCurrentPrincipal: true,
                            status: 'RUNNING',
                            workflowCode: '000001J' + 0
                        }
                    ]
                }
            );
        });

        beforeEach(function (done) {
            workflow.utils.setNumberOfWorkflowsToReturn(1);
            storefront.actions.goToSecondPage().then(function () {
                browser.switchToParent().then(function () {
                    browser.waitForPresence(perspective.modeSelectorBtn()).then(function () {
                        perspective.select(perspective.BASIC_CMS_PERSPECTIVE).then(function () {
                            done();
                        });
                    });
                });
            });
        });

        afterEach(function (done) {
            workflow.utils.setNumberOfWorkflowsToReturn(0);
            perspective.select(perspective.PREVIEW_PERSPECTIVE).then(function () {
                done();
            });
        });

        it('GIVEN the user is on the storefront view of a non-deletable page that is in workflow THEN the "move to trash" option is rendered inactive AND I expect a popover to get rendered on hover with a meaningful message.', function () {
            deletePageMenu.assertions.deletePageMenuIconIsInactive();
            deletePageMenu.actions.hoverOnDeletePageMenu();
            popover.assertions.isDisplayedWithProvidedText(
                'se.cms.tooltip.page.in.workflow.movetotrash'
            );
        });

        afterAll(function () {
            backendClient.removeFixture(fixtureID0);
        });
    });

    describe('Deletable page', function () {
        beforeEach(function (done) {
            workflow.utils.setNumberOfWorkflowsToReturn(0);
            storefront.actions.goToSecondPage().then(function () {
                browser.switchToParent().then(function () {
                    browser.waitForPresence(perspective.modeSelectorBtn()).then(function () {
                        perspective.select(perspective.BASIC_CMS_PERSPECTIVE).then(function () {
                            done();
                        });
                    });
                });
            });
        });

        describe('Move to trash toolbar item is enabled', function () {
            afterEach(function (done) {
                workflow.utils.setNumberOfWorkflowsToReturn(0);
                perspective.select(perspective.PREVIEW_PERSPECTIVE).then(function () {
                    done();
                });
            });

            it('GIVEN the user is on the storefront page of a deletable page THEN the "move to trash" option is rendered active AND I expect no popover anchor to be found for the "move to trash" option.', function () {
                deletePageMenu.assertions.deletePageMenuIconIsActive();
                deletePageMenu.actions.hoverOnDeletePageMenu();
                deletePageMenu.assertions.deletePageMenuIconPopoverAnchorIsNotPresent();
            });
        });

        describe('WHEN doing a soft delete of a page THEN it should be visible in trash page view', function () {
            it('GIVEN the user is on the storefront content page of a deletable page WHEN I trigger and confirm the soft deletion of the page THEN I am expected to be redirected to the page list view AND the deleted page is to be listed on the trash page view.', function () {
                // WHEN
                deletePageMenu.actions.clickOnDeletePageMenu();
                confirmationModal.actions.confirmConfirmationModal();
                alerts.actions.flush();
                pageList.actions.clickOnTrashViewLink();

                // THEN
                pageList.assertions.pageRowIsRenderedByPageName(DELETABLE_PAGE_NAME);
            });
        });
    });
});
