/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { GatewayProxied, IAnnouncementService, SeDowngradeService } from 'smarteditcommons';

@SeDowngradeService(IAnnouncementService)
@GatewayProxied('showAnnouncement', 'closeAnnouncement')
export class AnnouncementService extends IAnnouncementService {}
