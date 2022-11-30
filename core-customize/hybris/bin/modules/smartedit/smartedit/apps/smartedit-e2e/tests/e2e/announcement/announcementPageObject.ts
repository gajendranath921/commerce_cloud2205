/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { browser, by, element, ElementFinder } from 'protractor';

export namespace AnnouncementPageObject {
    export enum Constants {
        NON_CLOSEABLE_ANNOUNCEMENT_CONTENT = 'This is a non closeable announcement',
        SIMPLE_ANNOUNCEMENT_CONTENT = 'This is a simple announcement',
        COMPONENT_BASED_ANNOUNCEMENT_CONTENT = 'Component Based Announcement Message'
    }

    export const Elements = {
        nonCloseableAnnouncementButton(): ElementFinder {
            return element(by.id('test-announcement-non-closeable-button'));
        },

        simpleAnnouncementButton(): ElementFinder {
            return element(by.id('test-announcement-simple-button'));
        },

        componentBasedAnnouncementButton(): ElementFinder {
            return element(by.id('test-announcement-component-button'));
        }
    };

    export const Actions = {
        async navigateToTestPage(): Promise<void> {
            await browser.get('smartedit-e2e/generated/e2e/announcement/#!/ng');
        },

        async displayNonCloseableAnnouncement(): Promise<void> {
            await AnnouncementPageObject.Elements.nonCloseableAnnouncementButton().click();
        },

        async displaySimpleAnnouncement(): Promise<void> {
            await AnnouncementPageObject.Elements.simpleAnnouncementButton().click();
        },

        async displayComponentBasedAnnouncement(): Promise<void> {
            await AnnouncementPageObject.Elements.componentBasedAnnouncementButton().click();
        }
    };
}
