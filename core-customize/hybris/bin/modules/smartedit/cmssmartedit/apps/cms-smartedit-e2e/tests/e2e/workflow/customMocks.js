/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
// Constants
const WorkflowActionType = {
    START: 'START',
    NORMAL: 'NORMAL',
    END: 'END'
};

const WorkflowStatus = {
    FINISHED: 'finished',
    RUNNING: 'running'
};

const WorkflowActionStatus = {
    PENDING: 'PENDING',
    IN_PROGRESS: 'IN_PROGRESS',
    COMPLETED: 'COMPLETED'
};

const workflowActions = [
    createAction('Action1', WorkflowActionType.NORMAL, WorkflowActionStatus.COMPLETED, true),
    createAction('Action2', WorkflowActionType.NORMAL, WorkflowActionStatus.IN_PROGRESS, true),
    createAction('Action3', WorkflowActionType.NORMAL, WorkflowActionStatus.IN_PROGRESS, false),
    createAction('Action4', WorkflowActionType.END, WorkflowActionStatus.PENDING, true)
];

angular
    .module('customMocksModule', ['backendMocksUtilsModule'])
    .run(function (backendMocksUtils, httpBackendService) {
        mockItems();
        mockPermissions(httpBackendService);
        mockCustomPageStatus(backendMocksUtils);
        mockCustomWorkflow(httpBackendService);
        mockAnotherPageStaus(backendMocksUtils);
        setupWorkflowTasks(httpBackendService);
    });

try {
    angular.module('smarteditloader').requires.push('customMocksModule');
} catch (e) {}
try {
    angular.module('smarteditcontainer').requires.push('customMocksModule');
} catch (e) {}

// help functions
function mockItems() {
    // Items
    var updatePageApprovalStatus = sessionStorage.getItem('updatePageApprovalStatus');
    if (updatePageApprovalStatus) {
        var pagesToUpdate = JSON.parse(updatePageApprovalStatus);
        var componentMocks = JSON.parse(sessionStorage.getItem('componentMocks'));

        var modifiedMocks = {
            componentItems: componentMocks.componentItems.map(function (item) {
                if (pagesToUpdate[item.uuid]) {
                    var updateInfo = pagesToUpdate[item.uuid];
                    item.approvalStatus = updateInfo.approvalStatus;
                    item.displayStatus = updateInfo.displayStatus;
                }

                return item;
            })
        };

        sessionStorage.setItem('componentMocks', JSON.stringify(modifiedMocks));
    }
}

function mockPermissions(httpBackendService) {
    // Permissions
    httpBackendService
        .whenPOST(
            /permissionswebservices\/v1\/permissions\/types\/search\?permissionNames=create,change,read,remove&types=(.*)/
        )
        .respond(function () {
            var typePermissions = JSON.parse(sessionStorage.getItem('workflowTypePermissions'));
            var defaultWorkflowPermissions = [
                {
                    key: 'read',
                    value: 'true'
                },
                {
                    key: 'change',
                    value: 'true'
                },
                {
                    key: 'create',
                    value: 'true'
                },
                {
                    key: 'remove',
                    value: 'true'
                }
            ];

            return [
                200,
                {
                    permissionsList: [
                        {
                            id: 'ContentPage',
                            permissions: [
                                {
                                    key: 'read',
                                    value: 'true'
                                },
                                {
                                    key: 'change',
                                    value: 'true'
                                },
                                {
                                    key: 'create',
                                    value: 'true'
                                },
                                {
                                    key: 'remove',
                                    value: 'true'
                                }
                            ]
                        },
                        {
                            id: 'Workflow',
                            permissions: typePermissions || defaultWorkflowPermissions
                        }
                    ]
                }
            ];
        });

    httpBackendService
        .whenPOST(
            /permissionswebservices\/v1\/permissions\/attributes\/search\?attributes=(.*)&permissionNames=change,read/
        )
        .respond(function () {
            var customAttributePermissions = Object.keys(sessionStorage)
                .filter(function (key) {
                    return key.startsWith('attributePermissions_');
                })
                .map(function (key) {
                    return JSON.parse(sessionStorage[key]);
                });

            return [
                200,
                {
                    permissionsList: customAttributePermissions
                }
            ];
        });
}

function mockCustomPageStatus(backendMocksUtils) {
    // Custom Page status
    if (sessionStorage.getItem('customDisplayStatus')) {
        backendMocksUtils.getBackendMock('componentGETMock').respond(function (method, url) {
            var uuid = /cmsitems\/(.*)/.exec(url)[1];
            var displayStatus = sessionStorage.getItem('customDisplayStatus');

            var item = JSON.parse(sessionStorage.getItem('componentMocks')).componentItems.find(
                function (cmpItem) {
                    return cmpItem.uuid === uuid;
                }
            );
            if (uuid === 'homepage') {
                item.displayStatus = displayStatus;
            }

            return [200, item];
        });
    }
}

function mockCustomWorkflow(httpBackendService) {
    // Custom Workflow
    httpBackendService
        .whenGET(
            /\/cmswebservices\/v1\/catalogs\/.*\/versions\/.*\/workflows\?attachment=.*?&currentPage=0&pageSize=1&statuses=running,paused/
        )
        .respond(function () {
            var removeActiveWorkflow = sessionStorage.getItem('removeActiveWorkflow');
            var workflows = [];

            if (!removeActiveWorkflow || !JSON.parse(removeActiveWorkflow)) {
                var numberOfWorkflowsToReturn = JSON.parse(
                    sessionStorage.getItem('numberOfWorkflowsToReturn')
                );
                var workflowsAvailableForCurrentPrincipal = sessionStorage.getItem(
                    'workflowsAvailableForCurrentPrincipal'
                )
                    ? JSON.parse(sessionStorage.getItem('workflowsAvailableForCurrentPrincipal'))
                    : true;

                numberOfWorkflowsToReturn =
                    numberOfWorkflowsToReturn === null ? 1 : numberOfWorkflowsToReturn;
                for (var i = 0; i < numberOfWorkflowsToReturn; i++) {
                    workflows.push({
                        createVersion: false,
                        description: '',
                        isAvailableForCurrentPrincipal: workflowsAvailableForCurrentPrincipal,
                        status: 'RUNNING',
                        workflowCode: '000001J' + i
                    });
                }
            }

            return [
                200,
                {
                    pagination: {
                        count: 1,
                        page: 0,
                        totalCount: 0,
                        totalPages: 0
                    },
                    workflows: workflows
                }
            ];
        });

    httpBackendService
        .whenPOST(/\/cmswebservices\/v1\/catalogs\/.*\/versions\/.*\/workflows\/.*\/operations/)
        .respond(function (method, url, data) {
            var dataObject = angular.fromJson(data);

            var actionFound = workflowActions.find(function (action) {
                return action.code === dataObject.actionCode;
            });

            if (!actionFound) {
                return [
                    404,
                    {
                        errors: [
                            {
                                message: 'No workflow action item found for code',
                                type: 'UnknownIdentifierError'
                            }
                        ]
                    }
                ];
            }

            // Changing the actions status in response to the decision made.
            var index = workflowActions.findIndex(function (action) {
                return action.code === dataObject.actionCode;
            });
            workflowActions.splice(
                index,
                1,
                createAction(
                    'Action2',
                    WorkflowActionType.NORMAL,
                    WorkflowActionStatus.COMPLETED,
                    true
                )
            );

            var index2 = workflowActions.findIndex(function (action) {
                return action.code === 'Action4';
            });
            workflowActions.splice(
                index2,
                1,
                createAction(
                    'Action4',
                    WorkflowActionType.END,
                    WorkflowActionStatus.IN_PROGRESS,
                    true
                )
            );

            var updatedWorkflowStatus = WorkflowStatus.RUNNING;
            if (actionFound.actionType === WorkflowActionType.END) {
                updatedWorkflowStatus = WorkflowStatus.FINISHED;
                sessionStorage.setItem('numberOfWorkflowsToReturn', 0);
            }

            return [
                200,
                {
                    type: 'cmsWorkflowWsDTO',
                    isAvailableForCurrentPrincipal: true,
                    status: updatedWorkflowStatus,
                    workflowCode: '000001J'
                }
            ];
        });

    httpBackendService
        .whenGET(/\/cmswebservices\/v1\/catalogs\/.*\/versions\/.*\/workflows\/.*\/actions$/)
        .respond(function (method, url) {
            var workflowCode = url.match(/\/workflows\/([\w-]+)\/actions/)[1];

            return [
                200,
                {
                    actions: workflowActions,
                    workflowCode: workflowCode
                }
            ];
        });
}

function mockAnotherPageStaus(backendMocksUtils) {
    // Custom Page status
    if (sessionStorage.getItem('customDisplayStatus')) {
        backendMocksUtils.getBackendMock('componentGETMock').respond(function (method, url) {
            var uuid = /cmsitems\/(.*)/.exec(url)[1];
            var displayStatus = sessionStorage.getItem('customDisplayStatus');

            var item = JSON.parse(sessionStorage.getItem('componentMocks')).componentItems.find(
                function (cmpItem) {
                    return cmpItem.uuid === uuid;
                }
            );
            if (uuid === 'homepage') {
                item.displayStatus = displayStatus;
            }

            return [200, item];
        });
    }
}
function setupWorkflowTasks(httpBackendService) {
    var ACTION_REVIEW_PAGE = 'Review Page';
    var workflowTasks = [
        {
            action: {
                code: 'code1',
                description: { en: 'desc1' },
                name: { en: 'Publish Page' },
                startedAgoInMillis: 7573,
                status: 'IN_PROGRESS'
            },
            attachments: [
                {
                    catalogId: 'apparelContentCatalog',
                    catalogName: { en: 'Apparel Content Catalog' },
                    catalogVersion: 'Staged',
                    pageUid: 'homepage',
                    pageName: 'Homepage'
                }
            ]
        },
        {
            action: {
                code: 'code2',
                description: { en: 'desc2' },
                name: { en: ACTION_REVIEW_PAGE },
                startedAgoInMillis: 430580111,
                status: 'IN_PROGRESS'
            },
            attachments: [
                {
                    catalogId: 'apparel-ukContentCatalog',
                    catalogName: { en: 'Apparel UK Content Catalog' },
                    catalogVersion: 'Staged',
                    pageUid: 'homepage',
                    pageName: 'Homepage'
                }
            ]
        },
        {
            action: {
                code: 'code2',
                description: { en: 'desc2' },
                name: { en: ACTION_REVIEW_PAGE },
                startedAgoInMillis: 430580111,
                status: 'IN_PROGRESS'
            },
            attachments: [
                {
                    catalogId: 'apparel-deContentCatalog',
                    catalogName: { en: 'Apparel DE Content Catalog' },
                    catalogVersion: 'Staged',
                    pageUid: 'homepage',
                    pageName: 'Homepage'
                }
            ]
        },
        {
            action: {
                code: 'code2',
                description: { en: 'desc2' },
                name: { en: ACTION_REVIEW_PAGE },
                startedAgoInMillis: 430580111,
                status: 'IN_PROGRESS'
            },
            attachments: [
                {
                    catalogId: 'apparelContentCatalog',
                    catalogName: { en: 'Apparel Content Catalog' },
                    catalogVersion: 'Staged',
                    pageUid: 'homepage',
                    pageName: 'Homepage'
                }
            ]
        }
    ];

    httpBackendService
        .whenGET(/\/cmssmarteditwebservices\/v1\/inbox\/workflowtasks\?currentPage=.*&pageSize=.*/)
        .respond(function () {
            if (JSON.parse(sessionStorage.getItem('updateWorkflowInbox'))) {
                workflowTasks.shift();
            }

            return [
                200,
                {
                    pagination: {
                        count: workflowTasks.length,
                        page: 0,
                        totalCount: workflowTasks.length,
                        totalPages: 1
                    },
                    tasks: workflowTasks
                }
            ];
        });
}

function createAction(code, type, status, isCurrentUserParticipant) {
    return {
        actionType: type,
        code: code,
        decisions: [
            {
                code: code + 'Approve',
                description: { en: 'Approve For ' + code },
                name: { en: 'Approve' }
            },
            {
                code: code + 'Reject',
                description: { en: 'Reject For ' + code },
                name: { en: 'Reject' }
            }
        ],
        description: { en: 'This is ' + code },
        isCurrentUserParticipant: isCurrentUserParticipant,
        startedAgoInMillis: 86841180,
        name: { en: code },
        status: status
    };
}
