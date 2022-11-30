/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
// eslint-disable-next-line @typescript-eslint/ban-ts-comment
// @ts-ignore
import fetchMock from 'fetch-mock';

fetchMock.mock('path:/smartedit/settings', 200);
