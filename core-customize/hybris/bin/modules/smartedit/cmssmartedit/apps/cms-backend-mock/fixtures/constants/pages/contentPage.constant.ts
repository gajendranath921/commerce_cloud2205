/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { IComponentType } from '../../entities/components/componentType.entity';

export const contentPage: IComponentType = {
    attributes: [
        {
            cmsStructureType: 'ShortString',
            i18nKey: 'type.abstractpage.uid.name',
            localized: false,
            qualifier: 'uid'
        },
        {
            cmsStructureType: 'ShortString',
            i18nKey: 'type.abstractpage.name.name',
            localized: false,
            qualifier: 'name',
            required: true
        },
        {
            cmsStructureType: 'DateTime',
            i18nKey: 'type.abstractpage.creationtime.name',
            localized: false,
            qualifier: 'creationtime'
        },
        {
            cmsStructureType: 'DateTime',
            i18nKey: 'type.abstractpage.modifiedtime.name',
            localized: false,
            qualifier: 'modifiedtime'
        },
        {
            cmsStructureType: 'ShortString',
            i18nKey: 'type.abstractpage.title.name',
            localized: true,
            qualifier: 'title',
            required: true
        },
        {
            cmsStructureType: 'ShortString',
            i18nKey: 'type.contentpage.label.name',
            localized: false,
            qualifier: 'label',
            required: true
        },
        {
            cmsStructureType: 'PageRestrictionsEditor',
            i18nKey: 'type.abstractpage.restrictions.name',
            qualifier: 'restrictions'
        }
    ],
    category: 'PAGE',
    code: 'MockPage',
    i18nKey: 'type.mockpage.name',
    name: 'Mock Page'
};
