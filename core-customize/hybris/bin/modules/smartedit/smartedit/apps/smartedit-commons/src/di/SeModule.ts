/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
/* forbiddenNameSpaces angular.module:false */
import { functionsUtils } from '@smart/utils';
import * as angular from 'angular';
import * as lo from 'lodash';
import { diNameUtils } from './DINameUtils';

import {
    SeBaseProvider,
    SeClassProvider,
    SeComponentConstructor,
    SeConstructor,
    SeDirectiveConstructor,
    SeFactory,
    SeFactoryProvider,
    SeFilterConstructor,
    SeModuleConstructor,
    SeModuleDefinition,
    SeProvider,
    SeValueProvider
} from './types';

const MultiProviderMap: {
    [key: string]: string[];
} = {};

/**
 * **Deprecated since 1905.**
 *
 * Class level typescript {@link http://www.typescriptlang.org/docs/handbook/decorators.html decorator factory}
 * used to declare a Smartedit module from a Dependency injection standpoint.
 *
 * To create a configurable module, create a static method returning an SeModuleWithProvider object. The module
 * can then be imported by a parent module returning the SeModuleWithProvider object from the static method.
 * @deprecated
 */
export const SeModule = function (definition: SeModuleDefinition) {
    return function <T extends SeModuleConstructor>(moduleConstructor: T): T {
        const seModuleName = diNameUtils.buildName(moduleConstructor);
        const angularInstance = getAngular();
        const allImports: string[] = [];

        if (definition.imports) {
            definition.imports.forEach((importStatement, index) => {
                const moduleName = handleImportStatement(
                    seModuleName,
                    importStatement,
                    angularInstance,
                    index
                );
                if (allImports.indexOf(moduleName) > -1) {
                    throw new Error(
                        `module ${moduleName} is imported more than once into ${seModuleName}`
                    );
                }
                allImports.push(moduleName);
            });
        }

        const module = angularInstance.module(seModuleName, allImports);

        if (definition.providers) {
            addArrayOfProvidersToModule(module, definition.providers);
        }

        if (definition.declarations) {
            definition.declarations.forEach((declaration) => {
                if ((declaration as SeFilterConstructor).filterName) {
                    addFilterToModule(module, declaration as SeFilterConstructor);
                } else {
                    addFullComponentGraphToModule(module, declaration);
                }
            });
        }

        if (definition.config) {
            module.config(definition.config);
        }

        if (definition.initialize) {
            module.run(definition.initialize);
        }

        moduleConstructor.moduleName = module.name;
        return moduleConstructor;
    };
};

function handleImportStatement(seModuleName, importStatement, angularInstance, index): string {
    const throwUnAnnotatedModuleError = (seModule: SeModuleConstructor): never => {
        const importedModule = diNameUtils.buildName(seModule);
        throw new Error(
            `${importedModule} module was imported into ${seModuleName} module but doesn't seem to have been @SeModule annotated`
        );
    };

    function handleDefaultCondition(): void {
        if (!(importStatement && importStatement.seModule)) {
            throw new Error(
                `the import statement ${importStatement} at index ${index} added to ${seModuleName} is neither a legacy string nor an SeModuleConstructor`
            );
        }

        if (!importStatement.seModule.moduleName) {
            throwUnAnnotatedModuleError(importStatement.seModule);
        }

        const moduleWithProvidersName = diNameUtils.buildName(importStatement.seModule);
        const moduleWithProviders = angularInstance.module(moduleWithProvidersName);

        moduleName = moduleWithProviders.name;

        if (importStatement.providers) {
            addArrayOfProvidersToModule(moduleWithProviders, importStatement.providers);
        }
    }

    let moduleName: string;
    switch (typeof importStatement) {
        case 'string':
            moduleName = importStatement;
            break;
        case 'function':
            moduleName = importStatement.moduleName;
            if (!moduleName) {
                throwUnAnnotatedModuleError(importStatement);
            }
            break;
        default:
            handleDefaultCondition();
            break;
    }
    return moduleName;
}

function addArrayOfProvidersToModule(module: angular.IModule, providers: SeProvider[]): void {
    providers.forEach((provider: SeProvider, index: number) => {
        const moduleName = module.name;

        if (!provider) {
            throw new Error(
                `At the time a provider at index ${index} was added to module ${moduleName},
				it was undefined, this is probably due to the path in your typescript import statement
				referencing a barrel file of an alias defined in a higher layer, consider using a relative path instead.`
            );
        }

        if (
            (provider as SeBaseProvider).provide &&
            !(provider as SeValueProvider).useValue &&
            !(provider as SeClassProvider).useClass &&
            !(provider as SeFactoryProvider).useFactory
        ) {
            throw new Error(
                `At the time a provider named ${
                    (provider as SeBaseProvider).provide
                } was added to module ${moduleName}
		        did not provide an instance of SeValueProvider, SeClassProvider, or FactoryProvider.`
            );
        }

        if ((provider as SeValueProvider | SeFactoryProvider | SeClassProvider).multi) {
            provider = provider as SeValueProvider | SeFactoryProvider | SeClassProvider;
            addMultiProviderToModule(module, provider);
        } else {
            addProviderToModule(module, provider);
        }
    });
}

function addProviderToModule(module: angular.IModule, provider: SeProvider): void {
    if ((provider as SeValueProvider).useValue) {
        provider = provider as SeValueProvider;
        module.constant(provider.provide, provider.useValue);
        return;
    }

    if ((provider as SeClassProvider).useClass) {
        provider = provider as SeClassProvider;
        module.service(provider.provide, provider.useClass);
        return;
    }

    if ((provider as SeFactoryProvider).useFactory) {
        addSeFactoryProviderToModule(module, provider);
        return;
    }

    provider = provider as SeFactory | SeConstructor;
    const serviceName = diNameUtils.buildServiceName(provider);
    module.service(serviceName, provider);
}

function addSeFactoryProviderToModule(module: angular.IModule, provider: SeProvider): void {
    provider = provider as SeFactoryProvider;
    const isNgAnnotated = Array.isArray(provider.useFactory) || provider.useFactory.$inject;
    if (isNgAnnotated && provider.deps) {
        throw Error(`At the time a provider ${provider.provide} uses ngInject annotations and 
        SeFactoryProvider.deps at the same time. Please use one or the other.`);
    }

    const dependencies = provider.deps
        ? provider.deps.map((dependency: SeConstructor | SeFactory | string) =>
              typeof dependency === 'string' ? dependency : diNameUtils.buildServiceName(dependency)
          )
        : [];

    // In current framework, this is only needed for case of multi and for uglify ready di
    module.factory(
        provider.provide,
        isNgAnnotated ? provider.useFactory : [...dependencies, provider.useFactory]
    );
}

function addMultiProviderToModule(
    module: angular.IModule,
    provider: SeValueProvider | SeClassProvider | SeFactoryProvider
): void {
    const multiProviderMapName = module.name + provider.provide;
    let dependencies = MultiProviderMap[multiProviderMapName];

    if (!dependencies) {
        dependencies = [];
    }

    const multiProviderInstance = multiProviderMapName + lo.uniqueId();

    dependencies.push(multiProviderInstance);
    MultiProviderMap[multiProviderMapName] = dependencies;

    const useFactory = function (): any {
        return [].slice.call(arguments);
    };

    addProviderToModule(module, { ...provider, provide: multiProviderInstance });
    addProviderToModule(module, {
        provide: provider.provide,
        useFactory,
        deps: dependencies
    });
}

function addFilterToModule(module: angular.IModule, filterConstructor: SeFilterConstructor): void {
    module.filter(filterConstructor.filterName, filterConstructor.transform);
}

function addFullComponentGraphToModule(
    module: angular.IModule,
    component: SeDirectiveConstructor | SeComponentConstructor
): void {
    const definition = component.definition;
    if (!definition) {
        const componentConstructorName = functionsUtils.getConstructorName(component);
        throw new Error(
            `${componentConstructorName} component was imported into ${module.name} module but doesn't seem to have been @SeComponent or @SeDirective annotated`
        );
    }

    if (component.providers) {
        addArrayOfProvidersToModule(module, component.providers);
    }

    const componentName = (component as SeComponentConstructor).componentName;
    const directivename = (component as SeDirectiveConstructor).directiveName;

    if (componentName) {
        module.component(componentName, definition as angular.IComponentOptions);

        delete component.definition;

        const entryComponents = (component as SeComponentConstructor).entryComponents;
        if (entryComponents) {
            entryComponents.forEach((entryComponent: any) => {
                addFullComponentGraphToModule(module, entryComponent);
            });
        }
        delete (component as SeComponentConstructor).entryComponents;
    } else if (directivename) {
        module.directive(directivename, () => definition as angular.IDirective);
    }
}

// For testing purposes.
(SeModule as any).getAngular = function (): ng.IAngularStatic {
    return angular;
};

function getAngular(): any {
    return (SeModule as any).getAngular();
}
