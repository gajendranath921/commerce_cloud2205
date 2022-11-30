/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
module.exports = function() {
    return {
        config: function(data, conf) {
            conf.dest = 'jsTests/e2e/storefront.html';
            return conf;
        }
    };
};
