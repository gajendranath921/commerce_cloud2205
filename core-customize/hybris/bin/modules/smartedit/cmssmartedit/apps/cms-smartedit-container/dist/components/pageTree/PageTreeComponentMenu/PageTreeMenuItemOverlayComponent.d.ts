import { Injector } from '@angular/core';
import { IContextualMenuButton } from 'smarteditcommons';
import { ParentMenu } from './ParentMenu';
export declare class PageTreeMenuItemOverlayComponent {
    private readonly data;
    private readonly parent;
    private readonly injector;
    componentInjector: Injector;
    constructor(data: {
        item: IContextualMenuButton;
    }, parent: ParentMenu, injector: Injector);
    ngOnInit(): void;
    get item(): IContextualMenuButton;
    private createComponentInjector;
}
