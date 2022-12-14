/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { TypedMap } from '../typedMap.entity';
export interface IWorkflowAction {
    actionType: string;
    code: string;
    decisions: {
        code: string;
        description: TypedMap<string>;
        name: TypedMap<string>;
    }[];
    description: TypedMap<string>;
    isCurrentUserParticipant: boolean;
    startedAgoInMillis: number;
    name: TypedMap<string>;
    status: string;
}
