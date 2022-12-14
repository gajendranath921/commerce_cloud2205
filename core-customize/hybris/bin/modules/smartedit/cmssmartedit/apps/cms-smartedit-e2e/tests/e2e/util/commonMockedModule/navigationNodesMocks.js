/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
/* jshint unused:false, undef:false */
angular
    .module('navigationNodeMocks', ['yLoDashModule', 'componentMocks'])

    .service('navigationNodePUT', function (
        httpBackendService,
        lodash,
        navigationNodeNodes,
        navigationNodeEntries
    ) {
        // Following line can be removed once this issue is fixed: https://github.com/angular/angular.js/issues/16702
        // node_modules/angular-mocks/angular-mocks.js#1707
        window.isDefined = angular.isDefined;
        httpBackendService.matchLatestDefinitionEnabled(true);

        var nodes = navigationNodeNodes;
        var entries = navigationNodeEntries;

        function get400Error() {
            return [
                400,
                {
                    errors: [
                        {
                            message:
                                'this field has error of type 1. Field: [itemId]. position: [0].',
                            subject: 'entries',
                            type: 'ValidationError'
                        },
                        {
                            message:
                                'this field has error of type 2. Field: [itemSuperType]. position: [0].',
                            subject: 'entries',
                            type: 'ValidationError'
                        },
                        {
                            message:
                                'this field has error of type 3. Field: [itemId]. position: [2].',
                            subject: 'entries',
                            type: 'ValidationError'
                        }
                    ]
                }
            ];
        }

        function handleBoundry(destinationPosition, node, destinationParentUid) {
            var upperBoundry;
            var lowerBoundry;
            if (destinationPosition <= node.position) {
                // move up
                upperBoundry = node.position;
                lowerBoundry = destinationPosition;
                lodash.forEach(nodes, function (_node) {
                    if (
                        _node.parentUid === destinationParentUid &&
                        _node.position >= lowerBoundry &&
                        _node.position <= upperBoundry
                    ) {
                        _node.position++;
                    }
                });
                return;
            }

            // move down
            upperBoundry = destinationPosition;
            lowerBoundry = node.position;
            lodash.forEach(nodes, function (_node) {
                if (
                    _node.parentUid === destinationParentUid &&
                    _node.position >= lowerBoundry &&
                    _node.position <= upperBoundry
                ) {
                    _node.position--;
                }
            });
        }
        httpBackendService
            .whenPUT(/\/cmswebservices\/v1\/sites\/.*\/cmsitems\/((?!\/).)*$/)
            .respond(function (method, url, data, headers) {
                var payload = JSON.parse(data);

                if (payload.name.indexOf('entriesErrors') > -1) {
                    return get400Error();
                }

                var node = lodash.find(nodes, {
                    uid: payload.uid
                });

                // START replacing entries
                entries = entries.filter(function (entry) {
                    return entry.navigationNodeUid !== node.uid;
                });
                (payload.entries || []).forEach(function (entry) {
                    entry.navigationNodeUid = node.uid;
                });
                Array.prototype.push.apply(entries, payload.entries);
                // END replacing entries

                var destinationParentUid = payload.parentUid;
                var sourceParentUid = node.parentUid;
                var destinationPosition = payload.position;

                if (destinationParentUid !== sourceParentUid) {
                    lodash.forEach(nodes, function (_node) {
                        if (_node.parentUid === sourceParentUid && _node.position > node.position) {
                            _node.position--;
                        }
                        if (
                            _node.parentUid === destinationParentUid &&
                            _node.position >= destinationPosition
                        ) {
                            _node.position++;
                        }
                    });
                } else {
                    handleBoundry(destinationPosition, node, destinationParentUid);
                }

                node.position = destinationPosition;
                node.parentUid = destinationParentUid;
                node.children = payload.children;
                nodes = lodash.sortBy(nodes, 'position');

                /**
                 * Updating location of node within parent node
                 */
                var currentLocationInMockNodes = nodes.findIndex(function (nodeInMocks) {
                    return payload.uuid === nodeInMocks.uuid;
                });
                nodes.splice(currentLocationInMockNodes, 1);
                nodes.splice(currentLocationInMockNodes, 0, payload);

                return [200, node];
            });
    })
    .run(function (
        httpBackendService,
        parseQuery,
        lodash,
        navigationNodePOST,
        navigationNodeNodes,
        navigationNodeEntries,
        navigationNodePUT
    ) {
        var nodes = navigationNodeNodes;
        var entries = navigationNodeEntries;

        var fetchAncestors = function (parentUid) {
            var parent = nodes.find(function (element) {
                return element.uid === parentUid && element.uid !== 'root';
            });
            if (parent) {
                return [parent].concat(fetchAncestors(parent.parentUid));
            }

            return [];
        };

        var fecthAllByParentId = function (_nodes, parentUID) {
            // otherwise find all with parentUid instead
            return [
                200,
                {
                    navigationNodes: _nodes
                        .filter(function (node) {
                            return node.parentUid === parentUID;
                        })
                        .map(function (node) {
                            return appendEntriesToNode(node);
                        })
                        .sort(function (a, b) {
                            return a.position - b.position;
                        })
                }
            ];
        };

        var fetchChildren = function (_nodes, parent) {
            var children = parent.children.map(function (childUuid) {
                return _nodes.find(function (n) {
                    return n.uuid === childUuid;
                });
            });
            return [
                200,
                {
                    navigationNodes: children
                }
            ];
        };

        httpBackendService
            .whenGET(/\/cmswebservices\/v1\/sites\/.*\/cmsitems\/((?!\/).)*$/)
            .respond(function (method, url, data, headers) {
                var uuid = /cmsitems\/(.*)/.exec(url)[1];
                var _nodes = lodash.cloneDeep(nodes);
                var node = _nodes.filter(function (element) {
                    return element.uuid === uuid;
                })[0];

                appendEntriesToNode(node);

                return [200, node];
            });

        httpBackendService
            .whenGET(/sites\/.*\/catalogs\/.*\/versions\/.*\/navigations\/([^\/]+)/)
            .respond(function (method, url, data, headers) {
                var uid = /sites\/.*\/catalogs\/.*\/versions\/.*\/navigations\/(.+)/.exec(url)[1];
                var _nodes = lodash.cloneDeep(nodes);
                var node = _nodes.filter(function (element) {
                    return element.uid === uid;
                })[0];

                appendEntriesToNode(node);

                return [200, node];
            });

        httpBackendService
            .whenGET(/sites\/.*\/catalogs\/.*\/versions\/.*\/navigations/)
            .respond(function (method, url, data, headers) {
                var query = parseQuery(url);
                var parentUID = query.parentUid;
                var uid = query.ancestorTrailFrom;
                var _nodes = lodash.cloneDeep(nodes);

                if (parentUID && !uid) {
                    var parent = _nodes.find(function (node) {
                        return node.uid === parentUID;
                    });
                    // to te fetch child nodes from parents "children"
                    if (parent && parent.children && parent.children.length) {
                        return fetchChildren(_nodes, parent);
                    } else {
                        return fecthAllByParentId(_nodes, parentUID);
                    }
                } else if (!parentUID && uid) {
                    return [
                        200,
                        {
                            breadcrumb: fetchAncestors(uid)
                        }
                    ];
                } else {
                    return [];
                }
            });

        httpBackendService
            .whenPOST(/sites\/.*\/catalogs\/.*\/versions\/.*\/navigations/)
            .respond(function (method, url, data, headers) {
                return navigationNodePOST(data);
            });

        httpBackendService
            .whenDELETE(/\/cmswebservices\/v1\/sites\/.*\/cmsitems\/CMSNavigationNode-4/)
            .respond(function (method, url, data, headers) {
                var uuid = 'CMSNavigationNode-4';
                nodes = nodes.filter(function (node) {
                    return node.uuid !== uuid;
                });
                // remove all "children" refereences to this deleted node
                nodes.forEach(function (n) {
                    n.children = (n.children || []).filter(function (nn) {
                        return nn !== uuid;
                    });
                });
                return [
                    200,
                    {
                        navigationNodes: nodes
                    }
                ];
            });

        function appendEntriesToNode(node) {
            var _entries = lodash.cloneDeep(entries);
            var entryArray = _entries
                .filter(function (entry) {
                    return entry.navigationNodeUid === node.uid;
                })
                .map(function (entry) {
                    delete entry.navigationNodeUid;
                    delete entry.uid;
                    return entry;
                })
                .sort(function (a, b) {
                    return a.position - b.position;
                });

            node.entries = entryArray;
            return node;
        }
    });
try {
    angular.module('smarteditloader').requires.push('navigationNodeMocks');
} catch (e) {}
try {
    angular.module('smarteditcontainer').requires.push('navigationNodeMocks');
} catch (e) {}
