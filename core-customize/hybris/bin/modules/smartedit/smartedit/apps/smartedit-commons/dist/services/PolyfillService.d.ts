import { BrowserService } from '@smart/utils';
import { TestModeService } from './TestModeService';
export declare class PolyfillService {
    private readonly browserService;
    private readonly testModeService;
    constructor(browserService: BrowserService, testModeService: TestModeService);
    isEligibleForEconomyMode(): boolean;
    isEligibleForExtendedView(): boolean;
    isEligibleForThrottledScrolling(): boolean;
}
