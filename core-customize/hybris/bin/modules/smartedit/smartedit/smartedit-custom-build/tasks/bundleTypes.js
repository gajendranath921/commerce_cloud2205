/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
/* jshint esversion: 6 */
module.exports = function (grunt) {
    const fs = require('fs-extra');
    /**
     * bundles types to be exposed to extensions of smartedit
     */
    grunt.registerTask('bundleTypes', 'bundles types to be exposed', function (target) {
        grunt.log.writeln(
            `bundling types to be exposed for ${target}`,
            'concat:' + target + 'Types'
        );

        const fileName =
            global.smartedit.bundlePaths.bundleRoot + '/@types/' + target + '/index.d.ts';
        // removing import statements
        let content = fs.readFileSync(fileName, 'utf-8');

        content = content
            .replace(/import .*$/gm, '')
            .replace(/export {.*$/gm, '')
            .replace(/export declare(.+)/gm, 'export$1') //because A 'declare' modifier cannot be used in an already ambient context.
            .replace(/export abstract(.+)/gm, 'export$1') //because A 'declare' modifier cannot be used in an already ambient context.
            .replace(/protected.*$/gm, '')
            .replace(/private.*$/gm, '');
        /* last 2 statements to remove protected and private members with a risk though as per https://github.com/Microsoft/TypeScript/issues/1867:
         * "It's absolutely necessary to have privates in generated .d.ts files.
         * Otherwise you could derive from that class, declare a private of your own with the same name,
         * and unknowingly stomp on your base class's private variable value.
         * That failure mode would be very, very difficult to debug."
         */

        // surrounding by smarteditcommons module declaration
        content = '// ******************************************************* \n' + content;
        content = '// Do not modify this file -- YOUR CHANGES WILL BE ERASED! \n' + content;
        content = '// This file is automatically generated \n' + content;
        content = '// ******************************************************* \n' + content;
        content = "declare module '" + target + "' {\n" + content;
        content = "import * as angular from 'angular';\n" + content;
        content = content + '\n}';

        fs.outputFileSync(fileName, content);
    });
};
