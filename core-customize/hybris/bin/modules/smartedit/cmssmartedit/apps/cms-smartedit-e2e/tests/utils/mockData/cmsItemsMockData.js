/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
/* jshint unused:false, undef:false */
var LABEL_ADD_EDIT_ADDRESS = 'add-edit-address';
unit.mockData.cmsItems = {};
unit.mockData.cmsItems.componentItems = [
    {
        typeCode: 'ContentPage',
        itemtype: 'ContentPage',
        uid: 'somepage1uid',
        uuid: 'somepage1uuid',
        label: LABEL_ADD_EDIT_ADDRESS,
        restrictions: ['someRestriction1Uuid', 'someRestriction2Uuid']
    },
    {
        typeCode: 'SomeCMSRestriction1',
        itemtype: 'SomeCMSRestriction1',
        uid: 'someRestriction1Uid',
        uuid: 'someRestriction1Uuid',
        label: LABEL_ADD_EDIT_ADDRESS
    },
    {
        typeCode: 'SomeCMSRestriction2',
        itemtype: 'SomeCMSRestriction2',
        uid: 'someRestriction2Uid',
        uuid: 'someRestriction2Uuid',
        label: LABEL_ADD_EDIT_ADDRESS
    }
];
