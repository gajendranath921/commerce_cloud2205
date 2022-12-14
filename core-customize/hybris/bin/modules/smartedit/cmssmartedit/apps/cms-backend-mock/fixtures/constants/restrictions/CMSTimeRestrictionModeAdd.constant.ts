/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { IComponentType } from '../../entities/components';

export const CMSTimeRestrictionModeAdd: IComponentType = {
    attributes: [
        {
            cmsStructureType: 'ShortString',
            collection: false,
            editable: false,
            i18nKey: 'type.cmstimerestriction.name.name',
            localized: false,
            paged: false,
            qualifier: 'name',
            required: true
        },
        {
            cmsStructureType: 'DateTime',
            collection: false,
            editable: false,
            i18nKey: 'type.cmstimerestriction.activefrom.name',
            localized: false,
            paged: false,
            qualifier: 'activeFrom',
            required: true
        },
        {
            cmsStructureType: 'DateTime',
            collection: false,
            editable: false,
            i18nKey: 'type.cmstimerestriction.activeuntil.name',
            localized: false,
            paged: false,
            qualifier: 'activeUntil',
            required: true
        }
    ],
    category: 'RESTRICTION',
    code: 'CMSTimeRestriction',
    i18nKey: 'type.cmstimerestriction.name',
    name: 'Time Restriction',
    type: 'timeRestrictionData'
};
