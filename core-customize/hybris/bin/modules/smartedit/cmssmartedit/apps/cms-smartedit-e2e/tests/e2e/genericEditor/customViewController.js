/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
/* jshint unused:false, undef:false */
angular
    .module('customViewModule', [
        'templateCacheDecoratorModule',
        'cmssmarteditContainerTemplates',
        'genericEditorModule'
    ])
    .controller('customViewController', function (genericEditorModalService) {
        this.thesmarteditComponentType = 'TypeWithMedia';
        this.thesmarteditComponentId = 'componentWithMedia';

        this.typeWithMediaContainer = 'TypeWithMediaContainer';
        this.componentWithMediaContainer = 'componentWithMediaContainer';

        this.componentToValidateId = 'componentToValidateId';
        this.componentToValidateType = 'componentToValidateType';

        this.navigationComponent = 'navigationComponent';
        this.navigationComponentType = 'NavigationComponentType';

        this.structureApi = 'cmswebservices/v1/types/:smarteditComponentType';
        this.displaySubmit = true;
        this.displayCancel = true;

        this.structureForBasic = [
            {
                cmsStructureType: 'ShortString',
                qualifier: 'name',
                i18nKey: 'type.Item.name.name'
            },
            {
                cmsStructureType: 'Date',
                qualifier: 'creationtime',
                i18nKey: 'type.AbstractItem.creationtime.name',
                editable: false
            },
            {
                cmsStructureType: 'Date',
                qualifier: 'modifiedtime',
                i18nKey: 'type.AbstractItem.modifiedtime.name',
                editable: false
            }
        ];

        this.structureForVisibility = [
            {
                cmsStructureType: 'Boolean',
                qualifier: 'visible',
                i18nKey: 'type.AbstractCMSComponent.visible.name'
            }
        ];

        this.structureForAdmin = [
            {
                cmsStructureType: 'ShortString',
                qualifier: 'uid',
                i18nKey: 'type.Item.uid.name'
            },
            {
                cmsStructureType: 'ShortString',
                qualifier: 'pk',
                i18nKey: 'type.AbstractItem.pk.name',
                editable: false
            }
        ];

        // TODO: When this file is in TS CONTEXT_SITE_ID should be imported from resourceLocationsConstants.ts (cms-commons)
        var CONTEXT_SITE_ID = 'CURRENT_CONTEXT_SITE_ID';
        this.contentApi = '/cmswebservices/v1/sites/' + CONTEXT_SITE_ID + '/cmsitems';

        this.content = {
            cloneComponent: false
        };

        this.openCMSLinkComponentEditor = function () {
            var payload = {
                componentId: 'cmsLinkComponentId',
                componentUuid: 'cmsLinkComponentId',
                componentType: 'CMSLinkComponent',
                title: 'type.CMSLinkComponent.name'
            };
            return genericEditorModalService.open(payload);
        };
    });
angular.module('smarteditcontainer').requires.push('customViewModule');
