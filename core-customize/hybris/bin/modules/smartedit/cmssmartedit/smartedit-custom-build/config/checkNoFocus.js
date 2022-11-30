/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
module.exports = function() {
    return {
        config: function(data, conf) {
            return {
                pattern: ['jsTests/**/*.js', 'jsTests/**/*.ts']
            };
        }
    };
};
