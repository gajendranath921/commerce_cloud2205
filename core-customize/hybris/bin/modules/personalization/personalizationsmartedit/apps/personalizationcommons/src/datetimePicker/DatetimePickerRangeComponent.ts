/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import {
    AfterViewInit,
    Component,
    Input,
    Inject,
    OnChanges,
    Output,
    SimpleChanges,
    EventEmitter,
    ViewChild,
    ElementRef,
    ChangeDetectionStrategy,
    ChangeDetectorRef
} from '@angular/core';
import { Datetimepicker, SetOptions } from 'eonasdan-bootstrap-datetimepicker';
import moment from 'moment';
import { BrowserService, DATE_CONSTANTS, YJQUERY_TOKEN } from 'smarteditcommons';
import { PersonalizationsmarteditDateUtils } from '../utils/PersonalizationsmarteditDateUtils';

// TODO: consider refactoring eonasdan-bootstrap-datetimepicker datetimepicker to Fundamental NGX Datetime Picker
@Component({
    selector: 'datetime-picker-range',
    templateUrl: './DatetimePickerRangeComponent.html',
    changeDetection: ChangeDetectionStrategy.OnPush
})
export class DatetimePickerRangeComponent implements AfterViewInit, OnChanges {
    @ViewChild('datePickerRangeFrom', { static: false })
    datePickerRangeFrom: ElementRef<HTMLDivElement>;

    @ViewChild('datePickerRangeTo', { static: false })
    datePickerRangeTo: ElementRef<HTMLDivElement>;

    @Input() dateFrom: string;
    @Input() dateTo: string;
    @Input() isEditable: boolean;

    @Output() dateFromChange: EventEmitter<string>;
    @Output() dateToChange: EventEmitter<string>;

    public readonly placeholderText: string;
    public isFromDateValid: boolean;
    public isToDateValid: boolean;
    public isEndDateInThePast: boolean;

    private readonly datetimePickerConfig: SetOptions;

    constructor(
        private readonly personalizationsmarteditDateUtils: PersonalizationsmarteditDateUtils,
        private readonly browserService: BrowserService,
        private readonly cdr: ChangeDetectorRef,
        @Inject(YJQUERY_TOKEN) private readonly yjQuery: JQueryStatic
    ) {
        this.dateFromChange = new EventEmitter();
        this.dateToChange = new EventEmitter();

        this.placeholderText = 'personalization.commons.datetimepicker.placeholder';
        this.isFromDateValid = false;
        this.isToDateValid = false;
        this.isEndDateInThePast = false;

        this.datetimePickerConfig = {
            format: DATE_CONSTANTS.MOMENT_FORMAT,
            showClear: true,
            showClose: true,
            useCurrent: false,
            keepInvalid: true, // Will cause the date picker to not revert or overwrite invalid dates.
            widgetPositioning: {
                horizontal: 'right',
                vertical: 'bottom'
            },
            locale: this.getLocaleForDatetimePicker()
        };
    }

    ngAfterViewInit(): void {
        if (this.isEditable) {
            this.initActions();
            this.initInputValues();
        }
    }

    ngOnChanges(changes: SimpleChanges): void {
        const dateFromChange = changes.dateFrom;
        const dateToChange = changes.dateTo;

        if (dateFromChange && !dateFromChange.isFirstChange() && this.isEditable) {
            this.setDateFrom(dateFromChange.currentValue);
        }

        if (dateToChange && !dateToChange.isFirstChange() && this.isEditable) {
            this.setDateTo(dateToChange.currentValue);
        }
    }

    dateFromInputOnKeyup(event: KeyboardEvent): void {
        this.validateDateFrom((event.target as HTMLInputElement).value);
    }

    dateToInputOnKeyup(event: KeyboardEvent): void {
        this.validateDateTo((event.target as HTMLInputElement).value);
    }

    private validateDateFrom(dateFrom: string): void {
        this.isFromDateValid = this.personalizationsmarteditDateUtils.isDateValidOrEmpty(dateFrom);
    }

    private validateDateTo(dateTo: string): void {
        const dateToValid = this.personalizationsmarteditDateUtils.isDateValidOrEmpty(dateTo);
        if (dateToValid) {
            this.isToDateValid = true;
            this.isEndDateInThePast = this.personalizationsmarteditDateUtils.isDateInThePast(
                dateTo
            );
        } else {
            this.isToDateValid = false;
            this.isEndDateInThePast = false;
        }
    }

    private setDateFrom(dateFrom: string): void {
        this.validateDateFrom(dateFrom);

        const fromDatetimePicker = this.getFromDatetimePicker();
        const toDatetimePicker = this.getToDatetimePicker();
        if (
            this.personalizationsmarteditDateUtils.isDateStrFormatValid(
                dateFrom,
                DATE_CONSTANTS.MOMENT_FORMAT
            )
        ) {
            toDatetimePicker.minDate(this.getMinToDate(dateFrom));
            fromDatetimePicker.date(dateFrom);
        } else {
            toDatetimePicker.minDate(moment());
        }
    }

    private setDateTo(dateTo: string): void {
        this.validateDateTo(dateTo);

        const fromDatetimePicker = this.getFromDatetimePicker();
        const toDatetimePicker = this.getToDatetimePicker();
        if (
            this.personalizationsmarteditDateUtils.isDateStrFormatValid(
                dateTo,
                DATE_CONSTANTS.MOMENT_FORMAT
            )
        ) {
            fromDatetimePicker.maxDate(this.getMinOrMaxDateForDatetimePicker(dateTo));
            toDatetimePicker.date(moment(new Date(dateTo)));
        } else if (dateTo === '') {
            fromDatetimePicker.maxDate(false);
        }
    }

    /**
     * Returns moment date for valid date string.
     * When false is returned, maxDate(false) or minDate(false), no restrictions will be applied.
     */
    private getMinOrMaxDateForDatetimePicker(date: string): moment.Moment | boolean {
        try {
            return moment(new Date(date));
        } catch (err) {
            return false;
        }
    }

    private initActions(): void {
        this.getFromPickerNode()
            .datetimepicker(this.datetimePickerConfig)
            .on('dp.update dp.hide dp.change', (event: any): void => {
                let dateFrom = this.personalizationsmarteditDateUtils.formatDate(
                    event.date,
                    undefined
                );
                if (
                    this.personalizationsmarteditDateUtils.isDateValidOrEmpty(dateFrom) &&
                    this.personalizationsmarteditDateUtils.isDateValidOrEmpty(this.dateTo) &&
                    !this.personalizationsmarteditDateUtils.isDateRangeValid(dateFrom, this.dateTo)
                ) {
                    dateFrom = this.dateTo;
                }
                this.dateFrom = dateFrom;
                this.dateFromChange.emit(this.dateFrom);
            });

        this.getToPickerNode()
            .datetimepicker(this.datetimePickerConfig)
            .on('dp.update dp.hide dp.change', (event: any): void => {
                let dateTo = this.personalizationsmarteditDateUtils.formatDate(
                    event.date,
                    undefined
                );
                if (
                    this.personalizationsmarteditDateUtils.isDateValidOrEmpty(dateTo) &&
                    this.personalizationsmarteditDateUtils.isDateValidOrEmpty(this.dateFrom) &&
                    !this.personalizationsmarteditDateUtils.isDateRangeValid(this.dateFrom, dateTo)
                ) {
                    dateTo = this.dateFrom;
                }
                this.dateTo = dateTo;
                this.dateToChange.emit(this.dateTo);
            });

        this.getToDatetimePicker().minDate(moment());
    }

    private initInputValues(): void {
        if (this.dateFrom) {
            this.setDateFrom(this.dateFrom);
        } else {
            this.isFromDateValid = true; // don't display the errror message when the field is empty on initialize
        }

        if (this.dateTo) {
            this.setDateTo(this.dateTo);
        } else {
            this.isToDateValid = true; // don't display the errror message when the field is empty on initialize
        }
        this.cdr.detectChanges();
    }

    private getLocaleForDatetimePicker(): string {
        return this.browserService.getBrowserLocale().split('-')[0];
    }

    private getMinToDate(date: string): moment.Moment | boolean {
        if (!this.personalizationsmarteditDateUtils.isDateInThePast(date)) {
            return this.getMinOrMaxDateForDatetimePicker(date);
        } else {
            return moment();
        }
    }

    private getFromPickerNode(): JQuery<HTMLDivElement> {
        return this.yjQuery(this.datePickerRangeFrom.nativeElement);
    }

    private getFromDatetimePicker(): Datetimepicker {
        return this.getFromPickerNode().datetimepicker().data('DateTimePicker');
    }

    private getToPickerNode(): JQuery<HTMLDivElement> {
        return this.yjQuery(this.datePickerRangeTo.nativeElement);
    }

    private getToDatetimePicker(): Datetimepicker {
        return this.getToPickerNode().datetimepicker().data('DateTimePicker');
    }
}
