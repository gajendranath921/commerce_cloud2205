import { RestServiceFactory, TypedMap } from '@smart/utils';
export declare class SettingsService {
    private readonly restService;
    constructor(restServicefactory: RestServiceFactory);
    load(): Promise<TypedMap<string | boolean | string[]>>;
    get(key: string): Promise<string>;
    getBoolean(key: string): Promise<boolean>;
    getStringList(key: string): Promise<string[]>;
}
