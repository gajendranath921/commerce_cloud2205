/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { Cloneable, FunctionsUtils } from '@smart/utils';
import * as angular from 'angular';
import { SeInjectable } from 'smarteditcommons/di';

interface ServiceConfig {
    name: string;
    exclude: string[];
    include: string[];
}

interface DelegateFunction<T> {
    name: keyof T;
    fn: (...args: any[]) => any;
}

interface FunctionExecutionData {
    serviceName: string;
    functionName: string;
    arguments: Cloneable;
    result: any;
}

/**
 * @internal
 * @ignore
 */
interface InstrumentationConfig {
    globalExcludedRecipes?: string[];
    globalIncludedRecipes?: string[];
    globalExcludedFunctions?: string[];
    globalIncludedFunctions?: string[];
    defaultExcludeModules?: string[];
    modules: string[];
    $provide: angular.auto.IProvideService;
}

/**
 * @internal
 * @ignore
 */
@SeInjectable()
class Instrumentation {
    private _FUNCTION_EXECUTION_DATA: { [key: string]: FunctionExecutionData } = {};
    private readonly _DECORATED_MODULES: any[] = [];
    private readonly _DEFAULT_LEVEL = 10;
    private readonly alreadyBrowsed: string[] = [];
    private readonly functionsUtils: FunctionsUtils = new FunctionsUtils();

    constructor(private readonly readObjectStructure: (arg: Cloneable) => Cloneable) {}

    execute(config: InstrumentationConfig, _LEVEL: number, isRoot: boolean): void {
        const LEVEL = _LEVEL || this._DEFAULT_LEVEL;

        if (config.modules === undefined) {
            return;
        }

        this._logFunctionArgumentsAndReturnValue = this._logFunctionArgumentsAndReturnValue.bind(
            this
        );
        this._getServiceConfig = this._getServiceConfig.bind(this);
        this._getIterableDelegate = this._getIterableDelegate.bind(this);
        this._getDelegateFunctions = this._getDelegateFunctions.bind(this);
        this._extractComponentBindings = this._extractComponentBindings.bind(this);
        this._extractDirectiveBindings = this._extractDirectiveBindings.bind(this);

        config.modules.forEach((moduleName: string) => {
            this.alreadyBrowsed.push(moduleName);

            if (!isRoot) {
                if (
                    this._DECORATED_MODULES.indexOf(moduleName) > -1 ||
                    !moduleName.endsWith('Module')
                ) {
                    return;
                }
            }

            this._DECORATED_MODULES.push(moduleName);
            /* forbiddenNameSpaces angular.module:false */
            const module = angular.module(moduleName);
            (module as any)._invokeQueue.forEach((invoke: [string, string, [string]]) => {
                this._handleInvokeQueue(invoke, this, config, moduleName);
            });

            if (LEVEL > 0) {
                const NEW_LEVEL = LEVEL - 1;
                module.requires.forEach((_moduleName: string) => {
                    this._loopModueRequires(_moduleName, config, NEW_LEVEL);
                });
            }
        });
    }

    private _loopModueRequires(_moduleName, config, NEW_LEVEL): void {
        if (
            this.alreadyBrowsed.indexOf(_moduleName) === -1 &&
            config.defaultExcludeModules.indexOf(_moduleName) === -1 &&
            _moduleName.indexOf('Mock') === -1
        ) {
            this.execute(
                {
                    globalExcludedRecipes: config.globalExcludedRecipes,
                    globalIncludedRecipes: config.globalIncludedRecipes,
                    globalExcludedFunctions: config.globalExcludedFunctions,
                    globalIncludedFunctions: config.globalIncludedFunctions,
                    modules: [_moduleName],
                    $provide: config.$provide,
                    defaultExcludeModules: config.defaultExcludeModules
                },
                NEW_LEVEL,
                false
            );
        }
    }

    private _handleOriginal(
        iterableDelegate: any,
        original: DelegateFunction<(...param: any[]) => any>,
        context: any,
        recipeName: string
    ): void {
        if (iterableDelegate[original.name].__DECORATED__) {
            return;
        }
        const self = context;
        const isEmpty = self.functionsUtils.isEmpty(original.fn);
        if (isEmpty) {
            iterableDelegate[original.name] = function (): any {
                'proxyFunction';
                const result = original.fn.apply(this, ...arguments);
                self._logFunctionArgumentsAndReturnValue(
                    recipeName,
                    original.name,
                    arguments,
                    result
                );
                return result;
            };
        } else {
            iterableDelegate[original.name] = function (): any {
                const result = original.fn.apply(this, ...arguments);
                self._logFunctionArgumentsAndReturnValue(
                    recipeName,
                    original.name,
                    arguments,
                    result
                );
                return result;
            };
        }
        iterableDelegate[original.name].__DECORATED__ = true;
    }

    private _handleDefaultInvoke(
        invoke: [string, string, [string]],
        context: any,
        config: InstrumentationConfig,
        moduleName: string
    ): void {
        const moduleConfig = this._getServiceConfig(moduleName);
        // FIXME: necessary to concat?
        const serviceExcludeFunctions = moduleConfig.exclude.concat(
            config.globalExcludedFunctions || []
        );
        const serviceIncludeFunctions = moduleConfig.include.concat(
            config.globalIncludedFunctions || []
        );
        const args = invoke[2];
        const recipeName = args[0];
        const functionName = invoke[1];

        try {
            if (
                !context._isEligible(
                    recipeName,
                    config.globalExcludedRecipes,
                    config.globalIncludedRecipes
                )
            ) {
                context.warn('not eligible recipe : ' + recipeName);
                return;
            }

            config.$provide.decorator(recipeName, ($delegate: (...param: any[]) => any) => {
                const iterableDelegate = context._getIterableDelegate($delegate);
                const originals: DelegateFunction<
                    (...param: any[]) => any
                >[] = context._getDelegateFunctions(
                    iterableDelegate,
                    serviceExcludeFunctions,
                    serviceIncludeFunctions
                );

                originals.forEach((original) => {
                    this._handleOriginal(iterableDelegate, original, context, recipeName);
                });
                return $delegate;
            });
        } catch (e) {
            context.error(e);
            context.warn(
                `Warning-No-Service-Exists:  ${recipeName} of type ${functionName} , moduleName: ${moduleName}`
            );
        }
    }

    private _handleInvokeQueue(
        invoke: [string, string, [string]],
        context: any,
        config: InstrumentationConfig,
        moduleName: string
    ): void {
        const functionName = invoke[1];
        if (['factory', 'component', 'service', 'directive'].indexOf(functionName) <= -1) {
            return;
        }

        const args = invoke[2];
        switch (functionName) {
            case 'component':
                context._extractComponentBindings(args);
                break;
            case 'directive':
                context._extractDirectiveBindings(args);
                break;
            default:
                this._handleDefaultInvoke(invoke, context, config, moduleName);
        }
    }

    private _getServiceConfig(service: string): ServiceConfig {
        return typeof service === 'string'
            ? {
                  name: service,
                  exclude: [],
                  include: []
              }
            : service;
    }

    private _getIterableDelegate<T extends (...args: any[]) => any>($delegate: T): any {
        return $delegate.prototype ? $delegate.prototype : $delegate;
    }

    private _matches(name: string, nameRegex: string): boolean {
        return new RegExp(nameRegex, 'gi').test(name);
    }

    private _getDelegateFunctions<T extends (...args: any[]) => any>(
        $delegate: T,
        serviceExcludeFunctions: string[],
        serviceIncludeFunctions: string[]
    ): DelegateFunction<T>[] {
        const result = [];

        for (const fnName in $delegate) {
            if (
                typeof $delegate[fnName] === 'function' &&
                this._isEligible(fnName, serviceExcludeFunctions, serviceIncludeFunctions)
            ) {
                result.push({
                    name: fnName,
                    fn: ($delegate[fnName] as any) as (...args: any[]) => any
                });
            }
        }
        return result;
    }

    private _isEligible(recipeName: string, excludes: string[], includes: string[]): boolean {
        return (
            (!includes.length || !!includes.find(this._matches.bind(this, recipeName))) &&
            (!excludes.length || !excludes.find(this._matches.bind(this, recipeName)))
        );
    }

    private _resultIsPromise(result: angular.IPromise<any>): boolean {
        return !!result && ((result as any).$$state !== undefined || !!result.then);
    }

    private _keyExists(key: string): boolean {
        if (this._FUNCTION_EXECUTION_DATA[key] !== undefined) {
            return true;
        }
        return false;
    }

    private _extractComponentBindings(args: any[]): void {
        const componentName = args[0];
        const bindVariables = args[1].bindings;
        this._logDirectiveResult(componentName, bindVariables);
    }

    private _extractDirectiveBindings(args: any[]): void {
        const directiveName = args[0];
        try {
            const secondAttribute = args[1];
            let directiveConfig = null;
            if (typeof secondAttribute === 'function') {
                directiveConfig = secondAttribute();
            } else if (secondAttribute instanceof Array) {
                directiveConfig = secondAttribute[secondAttribute.length - 1]();
            }
            if (directiveConfig) {
                const scope = directiveConfig.scope;
                const bindToController = directiveConfig.bindToController;
                this._logDirectiveResult(directiveName, undefined, scope, bindToController);
            }
        } catch (e) {
            this._logDirectiveResult(directiveName);
        }
    }

    private _logFunctionArgumentsAndReturnValue(
        serviceName: string,
        functionName: string,
        _args: IArguments,
        result: any | angular.IPromise<any>
    ): angular.IPromise<any> {
        const successCallback = (res: any): Promise<any> => {
            try {
                this._FUNCTION_EXECUTION_DATA[key] = {
                    serviceName,
                    functionName,
                    arguments: args,
                    result: {
                        promiseValue: this.readObjectStructure(res)
                    }
                };
                this.warn(angular.toJson(this._FUNCTION_EXECUTION_DATA[key]));
            } catch (e) {
                this.error('COULD NOT STRINGIFY');
            }
            return Promise.resolve(res);
        };

        const failCallback = (reason: Error): Promise<Error> => {
            this.error('ERROR WHILE RESOLVING RESULT: ' + reason);
            this._FUNCTION_EXECUTION_DATA[key] = {
                serviceName,
                functionName,
                arguments: args,
                result: { promiseValue: reason }
            };
            this.warn(angular.toJson(this._FUNCTION_EXECUTION_DATA[key]));
            return Promise.reject(reason);
        };

        const args = this.readObjectStructure(Array.prototype.slice.call(_args));

        let key: string = null;
        try {
            const argsJson = angular.toJson(args);
            key = `${serviceName} ~ ${functionName} ~ ${argsJson}`;
        } catch (e) {
            this.error('COULD NOT GENERATE KEY');
            return result;
        }

        if (this._keyExists(key)) {
            return result;
        }

        this._FUNCTION_EXECUTION_DATA[key] = {} as FunctionExecutionData;

        if (this._resultIsPromise(result)) {
            return result.then(successCallback, failCallback);
        }

        this._FUNCTION_EXECUTION_DATA[key] = {
            serviceName,
            functionName,
            arguments: args,
            result: this.readObjectStructure(result)
        };
        try {
            this.warn(angular.toJson(this._FUNCTION_EXECUTION_DATA[key]));
        } catch (e) {
            this.error('COULD NOT STRINGIFY');
        }
        return result;
    }

    private _logDirectiveResult(
        directiveName: string,
        bindings?: string[],
        scope?: angular.IScope,
        bindToController?: { [boundProperty: string]: string }
    ): void {
        this.warn(
            angular.toJson({
                directiveName,
                bindings,
                scope,
                bindToController
            })
        );
    }

    private warn(message: string): void {
        // eslint-disable-next-line no-console
        console.warn(message);
    }

    private error(message: string): void {
        // eslint-disable-next-line no-console
        console.error(message);
    }
}

function getItemFromSessionStorage(name: string): Cloneable {
    try {
        return window.sessionStorage.getItem(name);
    } catch (e) {
        /*
         * would fail if:
         * - sessionStorage is not implemented
         * - accessing sessionStorage is forbidden in CORS because of default "Block third-party cookies" settings in chrome
         */
        return null;
    }
}

/** @internal */
export const instrument = (
    $provide: any,
    readObjectStructure: (arg: Cloneable) => Cloneable,
    TOP_LEVEL_MODULE_NAME: string
): any => {
    'ngInject';

    if (getItemFromSessionStorage('isInstrumented') === 'true') {
        new Instrumentation(readObjectStructure).execute(
            {
                globalExcludedRecipes: [
                    'assetsService',
                    'configurationExtractorService',
                    'experienceService'
                ],
                globalIncludedRecipes: [
                    '^.*Interface$',
                    '^.*Service$',
                    '^.*Helper$',
                    '^.*Hanlder$',
                    '^.*Editor$',
                    '^I.*$',
                    '^.*Decorator$',
                    '^.*Directive$',
                    '^.*Registry$',
                    '^.*Listener$',
                    '^.*Resource$',
                    '^.*Populator$',
                    '^.*Constants$',
                    '^.*Factory$',
                    '^.*Facade$',
                    '^.*Interceptor$',
                    '^.*Manager$',
                    '^.*Class$',
                    '^.*Strategy',
                    '^.*Predicate',
                    '^.*Retry',
                    '^.*Gateway'
                ],
                globalExcludedFunctions: ['^_.*$', '^\\$', 'lodash', 'yjQuery'],
                globalIncludedFunctions: ['^.*$'], // this regex helps to exclude private function prefixed with "_"
                defaultExcludeModules: [
                    'ycmssmarteditModule',
                    'ui.bootstrap',
                    'ui.select',
                    'yjQuery',
                    'instrumentModule',
                    'ui.tree',
                    'treeModule' // contains fetchChildren function that extracts dom objects that contains circular structure
                ],

                modules: [TOP_LEVEL_MODULE_NAME],
                $provide
            },
            15,
            true
        );
    }
};
