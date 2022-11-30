/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { TypedMap } from '../typedMap.entity';
export interface IWorkflowTemplate {
    code: string;
    name: TypedMap<string>;
}
