import { MediaService } from '../services';
export declare class MediasController {
    private readonly mediaService;
    constructor(mediaService: MediaService);
    findMedias(query: any): {
        media: import("../../fixtures/entities/media").IMedia[];
        pagination: {};
    };
}
