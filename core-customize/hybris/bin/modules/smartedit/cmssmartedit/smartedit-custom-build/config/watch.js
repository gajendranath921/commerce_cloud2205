/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
module.exports = function () {
    const GRUNT_FILE = 'Gruntfile.js';
    const FEATURE_PATH = 'web/features/**/*';
    const JSTEST_PATH = 'jsTests';
    return {
        targets: ['e2e', 'test', 'dev', 'pack', 'ngdocs'],
        config: function (data, conf) {
            return {
                e2e: {
                    files: [GRUNT_FILE, FEATURE_PATH, JSTEST_PATH],
                    tasks: ['e2e'],
                    options: {
                        atBegin: true
                    }
                },
                test: {
                    files: [GRUNT_FILE, FEATURE_PATH, JSTEST_PATH],
                    tasks: ['test'],
                    options: {
                        atBegin: true
                    }
                },
                dev: {
                    files: [GRUNT_FILE, FEATURE_PATH, 'jsTests/**/*'],
                    tasks: ['dev'],
                    options: {
                        atBegin: true
                    }
                },
                pack: {
                    files: [GRUNT_FILE, FEATURE_PATH, JSTEST_PATH],
                    tasks: ['package'],
                    options: {
                        atBegin: true
                    }
                },
                ngdocs: {
                    files: [FEATURE_PATH],
                    tasks: ['ngdocs'],
                    options: {
                        atBegin: true
                    }
                }
            };
        }
    };
};
