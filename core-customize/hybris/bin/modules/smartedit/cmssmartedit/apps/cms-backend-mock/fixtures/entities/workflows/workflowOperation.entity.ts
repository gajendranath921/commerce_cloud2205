/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
export interface IWorkflowOperation {
    actionCode: string;
    comment: string;
    createVersion: boolean;
    decisionCode: string;
    label: string;
    operation: string;
}
