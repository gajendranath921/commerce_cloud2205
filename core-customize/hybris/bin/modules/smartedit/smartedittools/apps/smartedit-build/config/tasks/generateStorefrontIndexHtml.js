/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
module.exports = function(grunt) {
    /**
     * @ngdoc overview
     * @name generateStorefrontIndexHtml(T)
     * @description
     * # generateStorefrontIndexHtml Task
     * generateStorefrontIndexHtml is a task that creates a dummystorefront html page that can be wired as storefront
     * location for e2e httpBackendService mocks.
     *
     * The dummystorefront API is still a work in progress, so stay tuned for more details on this.
     *
     * # Configuration
     * ```js
     * {
     *    <target>: {
     *      dest: string,        // the output path/filename of the generated dummystorefront
     *      layoutAlias: string, // (optional) alias of a registered storefront layout
     *      delayAlias: string,  // (optional) alias of a registered delay strategy
     *      renderAlias: string, // (optional) alias of a registered render strategy
     *      scripts: string[]    // (optional) Array of javascript files to include in the <head>
     *    }
     * }
     *
     * ```
     */

    const path = require('path');

    const disclaimer = `
<!--========================================-->
<!-- !!!!!!!!!!!!! WARNING !!!!!!!!!!!!!!!! -->
<!-- this file is generated, DO NOT EDIT!   -->
<!--========================================-->
`;

    const taskName = 'generateStorefrontIndexHtml';
    const taskDescription =
        'Generates a index.html file for the dummy storefront that will load custom extensions layouts, delays, and render strategies';

    const fs = require('fs-extra');
    const LOGGER = require('../grunt-utils/taskLogger')(grunt, taskName, taskDescription);

    const templateFile =
        global.smartedit.bundlePaths.bundleRoot +
        '/config/grunt-utils/dummystorefront.index.tpl.html';

    grunt.registerTask(taskName, taskDescription, function() {
        LOGGER.startTask();

        var gruntConfig = grunt.config.get(taskName);

        var templateContents = fs.readFileSync(templateFile, 'utf-8');

        if (!gruntConfig.dest) {
            grunt.fail.fatal(`${taskName} - No destination specified in config.`);
        }

        var bundleRootRelativePath = path.relative(
            path.resolve(path.dirname(gruntConfig.dest)),
            global.smartedit.bundlePaths.bundleRoot
        );

        var scripts = '';
        if (gruntConfig.scripts && gruntConfig.scripts.length) {
            scripts = `$script(${JSON.stringify(gruntConfig.scripts).replace(
                /,/g,
                ',\n'
            )}, 'bundle');`;
        }
        templateContents = disclaimer.concat(templateContents);
        templateContents = templateContents.replace(
            /BUNDLE_ROOT_PLACEHOLDER/g,
            bundleRootRelativePath
        );
        templateContents = templateContents.replace(/SCRIPTS_PLACEHOLDER/g, scripts);
        templateContents = templateContents.replace(
            /LAYOUT_ALIAS_PLACEHOLDER/g,
            gruntConfig.layoutAlias
        );
        templateContents = templateContents.replace(
            /DELAY_ALIAS_PLACEHOLDER/g,
            gruntConfig.delayAlias
        );
        templateContents = templateContents.replace(
            /RENDER_ALIAS_PLACEHOLDER/g,
            gruntConfig.renderAlias
        );

        LOGGER.info(`Writing to: ${gruntConfig.dest}`);
        fs.outputFileSync(gruntConfig.dest, templateContents);

        LOGGER.endTask();
    });
};
