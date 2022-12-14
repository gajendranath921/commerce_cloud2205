/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
export interface IWorkflow {
    createVersion: boolean;
    description: string;
    isAvailableForCurrentPrincipal: boolean;
    status: string;
    workflowCode: string;
}
