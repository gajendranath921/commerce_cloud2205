/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
const base = require('../../smartedit-build/config/webpack/webpack.ext.karma.smartedit.config');

const {
    compose
} = require('../../smartedit-build/builders');

const {
    smarteditKarma
} = require('./webpack.shared.config');

module.exports = compose(
    smarteditKarma()
)(base);
