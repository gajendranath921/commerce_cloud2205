/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { IFeature } from './IFeature';

export type IDecoratorDisplayCondition = (
    componentType: string,
    componentId: string
) => PromiseLike<boolean>;

/**
 * Interface for IDecorator and it acts as a payload passed to addDecorator method of featureService method to register a decorator as a feature.
 */
export interface IDecorator extends IFeature {
    displayCondition?: IDecoratorDisplayCondition;
}
