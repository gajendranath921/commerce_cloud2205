/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import * as angular from 'angular';

/**
 * Backwards compatibility for partners and downstream teams
 * The deprecated modules below were moved to smarteditServicesModule
 *
 * IMPORTANT: THE DEPRECATED MODULES WILL NOT BE AVAILABLE IN FUTURE RELEASES
 */
export function surpressDiErrorForDeprecated(): void {
    // TODO: remove after personalization team clean up legacy modules
    angular.module('alertServiceModule', ['legacySmarteditCommonsModule']);
    angular.module('smarteditServicesModule', []);
    angular.module('modalServiceModule', []);
    angular.module('functionsModule', []);
}

export const deprecate = (): void => {
    surpressDiErrorForDeprecated();
};
