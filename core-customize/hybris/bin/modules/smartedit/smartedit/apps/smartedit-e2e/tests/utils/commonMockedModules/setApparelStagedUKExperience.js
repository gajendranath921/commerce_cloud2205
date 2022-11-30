/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
angular.module('setApparelStagedUKExperience', []).run(function (sharedDataService) {
    sharedDataService.set('experience', {
        siteDescriptor: {
            uid: 'apparel-uk'
        },
        catalogDescriptor: {
            catalogId: 'apparel-ukContentCatalog',
            catalogVersion: 'Staged'
        }
    });
});
angular.module('smarteditcontainer').requires.push('setApparelStagedUKExperience');
