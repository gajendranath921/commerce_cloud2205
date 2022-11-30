/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
/* jshint unused:false, undef:false */
var SOME_DESCRIPTION = 'some description';
unit.mockData.restrictions = {
    restrictions: [
        {
            uid: 'timeRestrictionIdA',
            name: 'Some Time restriction A',
            typeCode: 'CMSTimeRestriction',
            description: SOME_DESCRIPTION
        },
        {
            uid: 'timeRestrictionIdB',
            name: 'another time B',
            typeCode: 'CMSTimeRestriction',
            description: SOME_DESCRIPTION
        },
        {
            uid: 'catalogRestrictionIdH',
            name: 'Some User restriction 1',
            typeCode: 'CMSCatalogRestriction',
            description: SOME_DESCRIPTION
        },
        {
            uid: 'userRestrictionIdI',
            name: 'User restriction 2',
            typeCode: 'CMSUserRestriction',
            description: SOME_DESCRIPTION
        }
    ]
};
