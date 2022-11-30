import { Component } from '@angular/core';
@Component({
    selector: 'context-menu-delete-action',
    template: `<div id="confirmationModalDescription">
        {{ 'personalization.modal.deleteaction.content' | translate }}
    </div>`
})
export class ContextMenuDeleteActionComponent {}
