/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { IPermission } from './index';

export interface IGlobalPermission {
    id: string;
    permissions: IPermission[];
}
