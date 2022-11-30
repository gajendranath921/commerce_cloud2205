import { ChangeDetectorRef, OnInit } from '@angular/core';
import { ModalRef } from '@fundamental-ngx/core';
import { CMSRestriction } from 'cmscommons';
import { CmsitemsRestService } from 'smarteditcommons';
export declare class RestrictionsModalComponent implements OnInit {
    private modalRef;
    private cmsitemsRestService;
    private cdr;
    restrictions: CMSRestriction[];
    constructor(modalRef: ModalRef, cmsitemsRestService: CmsitemsRestService, cdr: ChangeDetectorRef);
    ngOnInit(): Promise<void>;
}
