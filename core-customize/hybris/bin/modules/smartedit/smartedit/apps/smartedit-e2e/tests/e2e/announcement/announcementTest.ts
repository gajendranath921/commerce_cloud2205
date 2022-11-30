/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { browser } from 'protractor';

import { AnnouncementComponentObject } from '../../utils/components/Announcement';
import { AnnouncementPageObject as PageObject } from './announcementPageObject';

describe('Announcement', () => {
    beforeEach(async () => {
        await PageObject.Actions.navigateToTestPage();
        await browser.waitForContainerToBeReady();
    });

    it('WHEN a non-closeable announcement is displayed THEN it does not have a close button', async () => {
        await PageObject.Actions.displayNonCloseableAnnouncement();

        await AnnouncementComponentObject.Assertions.assertCloseButtonIsNotPresent(0);
        await AnnouncementComponentObject.Assertions.assertAnnouncementHasTextByIndex(
            0,
            PageObject.Constants.NON_CLOSEABLE_ANNOUNCEMENT_CONTENT
        );
    });

    it('WHEN a closeable announcement is displayed THEN it has a close button', async () => {
        await PageObject.Actions.displaySimpleAnnouncement();

        await AnnouncementComponentObject.Assertions.assertCloseButtonIsPresent(0);
    });

    it('WHEN multiple announcements are published THEN all are displayed', async () => {
        await browser.waitForAngularEnabled(false);

        await PageObject.Actions.displayNonCloseableAnnouncement();
        await PageObject.Actions.displaySimpleAnnouncement();

        await AnnouncementComponentObject.Assertions.assertTotalNumberOfAnnouncements(2);
    });

    it('WHEN an announcement is displayed THEN it should disappear after a specified timeout', async () => {
        await PageObject.Actions.displaySimpleAnnouncement();

        await AnnouncementComponentObject.Assertions.assertAnnouncementIsNotDisplayed(0);
    });

    it('WHEN a simple announcement is displayed THEN it prints appropriate data from the message attribute', async () => {
        await PageObject.Actions.displaySimpleAnnouncement();

        await AnnouncementComponentObject.Assertions.assertAnnouncementHasTextByIndex(
            0,
            PageObject.Constants.SIMPLE_ANNOUNCEMENT_CONTENT
        );
    });

    it('WHEN a components announcement in displayed THEN it prints appropriate message from component class', async () => {
        await PageObject.Actions.displayComponentBasedAnnouncement();

        await AnnouncementComponentObject.Assertions.assertAnnouncementHasTextByIndex(
            0,
            PageObject.Constants.COMPONENT_BASED_ANNOUNCEMENT_CONTENT
        );
    });
});
