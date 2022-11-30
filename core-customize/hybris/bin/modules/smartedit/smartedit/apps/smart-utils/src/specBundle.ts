/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
/* eslint-disable */

/**
 * Entry file for unit tests.
 */

import 'zone.js';
import 'core-js/features/reflect';

function importAll(requireContext: any) {
    requireContext.keys().forEach(function (key: string) {
        requireContext(key);
    });
}

importAll(require.context('./', true, /spec.ts$/));
