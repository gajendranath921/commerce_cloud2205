/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { DataTableObject } from './dataTableObject';

describe('Data Table -', () => {
    beforeEach(() => {
        DataTableObject.Actions.navigate();
    });

    it('it renders correct number of headers', () => {
        DataTableObject.Assertions.hasCorrectHeadersCount(3);
    });

    it('it renders correct number of rows', () => {
        DataTableObject.Assertions.hasCorrectRowsCount(3);
    });

    it('renders correct number of component cells', () => {
        DataTableObject.Assertions.hasCorrectNgComponentsCount(3);
    });

    it('renders correct number of default cells', () => {
        DataTableObject.Assertions.cellExists('col_3_row_1');
        DataTableObject.Assertions.cellExists('col_3_row_2');
        DataTableObject.Assertions.cellExists('col_3_row_2');
    });
});
