import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { PersonalizationsmarteditCommonsComponentsModule } from 'personalizationcommons';
import {
    TooltipModule,
    L10nPipeModule,
    L10nService,
    moduleUtils,
    SeTranslationModule
} from 'smarteditcommons';
import { ShowActionListComponent } from './ShowActionList/ShowActionListComponent';
@NgModule({
    imports: [
        CommonModule,
        TooltipModule,
        L10nPipeModule,
        SeTranslationModule.forChild(),
        PersonalizationsmarteditCommonsComponentsModule
    ],
    providers: [],
    declarations: [ShowActionListComponent],
    entryComponents: [ShowActionListComponent],
    exports: [ShowActionListComponent]
})
export class ShowActionListModule {}
