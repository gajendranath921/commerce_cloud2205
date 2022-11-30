/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { IcmsLinkToComponentAttribute } from './cmslinkToComponentAttribute.entity';
import { IComponentTypeAttribute } from './componentTypeAttribute.entity';

export interface IComponentType {
    attributes: (IcmsLinkToComponentAttribute | IComponentTypeAttribute)[];
    category: string;
    code: string;
    i18nKey?: string;
    name: string;
    type?: string;
}
