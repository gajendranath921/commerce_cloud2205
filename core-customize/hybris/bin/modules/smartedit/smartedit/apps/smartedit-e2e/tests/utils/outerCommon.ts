/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
export const buildDecoratorName = (prefix: string, id: string, type: string, index: number) => {
    return prefix + '-' + id + '-' + type + '-' + index;
};
