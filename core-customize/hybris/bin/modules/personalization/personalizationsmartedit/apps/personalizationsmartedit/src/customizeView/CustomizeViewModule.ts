import { NgModule } from '@angular/core';
import { servicesModule } from 'personalizationsmartedit/service/servicesModule';
import { CustomizeViewServiceProxy } from './CustomizeViewServiceInnerProxy';

@NgModule({
    imports: [servicesModule],
    providers: [CustomizeViewServiceProxy]
})
export class CustomizeViewModule {}
