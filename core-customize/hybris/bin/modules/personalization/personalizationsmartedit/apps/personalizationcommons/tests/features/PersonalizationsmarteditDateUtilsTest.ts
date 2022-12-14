import { TranslateService } from '@ngx-translate/core';
import { PersonalizationsmarteditDateUtils } from 'personalizationcommons/utils';

describe('PersonalizationsmarteditDateUtils', () => {
    // ======= Injected mocks =======
    let translateService: jasmine.SpyObj<TranslateService>;

    // Service being tested
    let personalizationsmarteditDateUtils: PersonalizationsmarteditDateUtils;

    // === SETUP ===
    beforeEach(() => {
        translateService = jasmine.createSpyObj('translateService', ['instant']);
        personalizationsmarteditDateUtils = new PersonalizationsmarteditDateUtils(translateService);
    });

    it('Public API', () => {
        expect(personalizationsmarteditDateUtils.formatDate).toBeDefined();
        expect(personalizationsmarteditDateUtils.formatDateWithMessage).toBeDefined();
        expect(personalizationsmarteditDateUtils.isDateInThePast).toBeDefined();
        expect(personalizationsmarteditDateUtils.isDateValidOrEmpty).toBeDefined();
        expect(personalizationsmarteditDateUtils.isDateRangeValid).toBeDefined();
        expect(personalizationsmarteditDateUtils.isDateStrFormatValid).toBeDefined();
    });

    describe('formatDate', () => {
        it('should be defined', () => {
            expect(personalizationsmarteditDateUtils.formatDate).toBeDefined();
        });

        it('should return empty string if date parameter not passed', () => {
            expect(personalizationsmarteditDateUtils.formatDate(undefined, undefined)).toBe('');
            expect(personalizationsmarteditDateUtils.formatDate(undefined, 'YYYY-MM-DD')).toBe('');
        });

        it('should return date in format that was passed as argument', () => {
            const mockFormat = 'YYYY-MM-DD';
            const mockDate = '2010-11-20T12:12:12';
            const formattedDate = personalizationsmarteditDateUtils.formatDate(
                mockDate,
                mockFormat
            );
            expect(formattedDate).toMatch(/^(\d{4})\-(\d{2})\-(\d{2})$/);
        });
    });

    describe('isDateInThePast', () => {
        it('should be defined', () => {
            expect(personalizationsmarteditDateUtils.isDateInThePast).toBeDefined();
        });

        it('should return false if date parameter not passed', () => {
            expect(personalizationsmarteditDateUtils.isDateInThePast(undefined)).toBe(false);
        });

        it('should return true if date is in the past', () => {
            const dateInThePastStr = '11/20/10 12:12 AM';
            expect(personalizationsmarteditDateUtils.isDateInThePast(dateInThePastStr)).toBe(true);
        });

        it('should return false if date is in the future', () => {
            const dateInTheFutureStr = '11/20/40 12:12 AM';
            expect(personalizationsmarteditDateUtils.isDateInThePast(dateInTheFutureStr)).toBe(
                false
            );
        });
    });

    describe('isDateValidOrEmpty', () => {
        it('should be defined', () => {
            expect(personalizationsmarteditDateUtils.isDateValidOrEmpty).toBeDefined();
        });

        it('should return true if date parameter not passed', () => {
            expect(personalizationsmarteditDateUtils.isDateValidOrEmpty(undefined)).toBe(true);
        });

        it('should return true if date string is in right format', () => {
            const validDateStr = '11/20/10 12:12 AM';
            expect(personalizationsmarteditDateUtils.isDateInThePast(validDateStr)).toBe(true);
        });

        it('should return false if date string is not in date format', () => {
            const inValidDateStr = '312adwdafawdaw';
            expect(personalizationsmarteditDateUtils.isDateInThePast(inValidDateStr)).toBe(false);
        });
    });

    describe('isDateRangeValid', () => {
        it('should be defined', () => {
            expect(personalizationsmarteditDateUtils.isDateRangeValid).toBeDefined();
        });

        it('should return true if no dates were passed', () => {
            expect(personalizationsmarteditDateUtils.isDateRangeValid(undefined, undefined)).toBe(
                true
            );
        });

        it('should return true if only startdate are passed', () => {
            const startDateStr = '2010-11-20T12:12:12';
            expect(
                personalizationsmarteditDateUtils.isDateRangeValid(startDateStr, undefined)
            ).toBe(true);
        });

        it('should return true if only enddate are passed', () => {
            const endDateStr = '2010-11-20T12:12:12';
            expect(personalizationsmarteditDateUtils.isDateRangeValid(undefined, endDateStr)).toBe(
                true
            );
        });

        it('should return true if only startdate is before enddate are passed', () => {
            const startDateStr = '2010-11-20T12:12:12';
            const endDateStr = '2011-11-20T12:12:12';
            expect(
                personalizationsmarteditDateUtils.isDateRangeValid(startDateStr, endDateStr)
            ).toBe(true);
        });

        it('should return false if only startdate is after enddate are passed', () => {
            const startDateStr = '2011-11-20T12:12:12';
            const endDateStr = '2010-11-20T12:12:12';
            expect(
                personalizationsmarteditDateUtils.isDateRangeValid(startDateStr, endDateStr)
            ).toBe(false);
        });
    });

    describe('isDateStrFormatValid', () => {
        it('should be defined', () => {
            expect(personalizationsmarteditDateUtils.isDateStrFormatValid).toBeDefined();
        });

        it('should return true if no paremeters were passed', () => {
            expect(
                personalizationsmarteditDateUtils.isDateStrFormatValid(undefined, undefined)
            ).toBe(false);
        });

        it('should return true for valid format', () => {
            const dateStr = '2/3/17 1:12 AM';
            const format = 'M/D/YY h:mm A';

            expect(personalizationsmarteditDateUtils.isDateStrFormatValid(dateStr, format)).toBe(
                true
            );
        });

        it('should return false for invalid format', () => {
            const dateStr = '2/3';
            const format = 'M/D/YY h:mm A';

            expect(personalizationsmarteditDateUtils.isDateStrFormatValid(dateStr, format)).toBe(
                false
            );
        });
    });
});
