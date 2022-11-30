/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { SeDowngradeService } from 'smarteditcommons';

@SeDowngradeService()
export class AbAnalyticsService {
    public getABAnalyticsForComponent(
        smarteditComponentId: string
    ): Promise<{ aValue: number; bValue: number }> {
        return Promise.resolve({
            aValue: 30,
            bValue: 70
        });
    }
}
