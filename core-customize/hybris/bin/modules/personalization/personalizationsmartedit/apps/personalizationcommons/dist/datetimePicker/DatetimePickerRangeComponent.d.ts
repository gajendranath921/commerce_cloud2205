/// <reference types="angular" />
/// <reference types="jquery" />
import { AfterViewInit, OnChanges, SimpleChanges, EventEmitter, ElementRef, ChangeDetectorRef } from '@angular/core';
import { BrowserService } from 'smarteditcommons';
import { PersonalizationsmarteditDateUtils } from '../utils/PersonalizationsmarteditDateUtils';
export declare class DatetimePickerRangeComponent implements AfterViewInit, OnChanges {
    private readonly personalizationsmarteditDateUtils;
    private readonly browserService;
    private readonly cdr;
    private readonly yjQuery;
    datePickerRangeFrom: ElementRef<HTMLDivElement>;
    datePickerRangeTo: ElementRef<HTMLDivElement>;
    dateFrom: string;
    dateTo: string;
    isEditable: boolean;
    dateFromChange: EventEmitter<string>;
    dateToChange: EventEmitter<string>;
    readonly placeholderText: string;
    isFromDateValid: boolean;
    isToDateValid: boolean;
    isEndDateInThePast: boolean;
    private readonly datetimePickerConfig;
    constructor(personalizationsmarteditDateUtils: PersonalizationsmarteditDateUtils, browserService: BrowserService, cdr: ChangeDetectorRef, yjQuery: JQueryStatic);
    ngAfterViewInit(): void;
    ngOnChanges(changes: SimpleChanges): void;
    dateFromInputOnKeyup(event: KeyboardEvent): void;
    dateToInputOnKeyup(event: KeyboardEvent): void;
    private validateDateFrom;
    private validateDateTo;
    private setDateFrom;
    private setDateTo;
    private getMinOrMaxDateForDatetimePicker;
    private initActions;
    private initInputValues;
    private getLocaleForDatetimePicker;
    private getMinToDate;
    private getFromPickerNode;
    private getFromDatetimePicker;
    private getToPickerNode;
    private getToDatetimePicker;
}
