/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
module.exports = function() {
    return {
        targets: ['prefix', 'paths'],
        config: function(data, conf) {
            return {
                prefix: {
                    ignored: [],
                    expected: []
                },
                paths: {
                    files: [],
                    properties: []
                }
            };
        }
    };
};
