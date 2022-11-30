import { IExperience, IExperienceService, SeDowngradeService } from 'smarteditcommons';

@SeDowngradeService()
export class PersonalizationsmarteditPreviewService {
    constructor(protected experienceService: IExperienceService) {}

    public removePersonalizationDataFromPreview(): Promise<IExperience> {
        return this.updatePreviewTicketWithVariations([]);
    }

    public async updatePreviewTicketWithVariations(variations: any): Promise<IExperience> {
        const experience = await this.experienceService.getCurrentExperience();
        if (!experience) {
            return undefined;
        }
        if (JSON.stringify(experience.variations) === JSON.stringify(variations)) {
            return undefined;
        }
        experience.variations = variations;
        await this.experienceService.setCurrentExperience(experience);
        return this.experienceService.updateExperience();
    }
}
