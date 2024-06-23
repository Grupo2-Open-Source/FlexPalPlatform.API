package com.gymfinity.flexpal.platform.counseling.interfaces.rest.transform;

import com.gymfinity.flexpal.platform.counseling.domain.model.commands.UpdateCoachCommand;
import com.gymfinity.flexpal.platform.counseling.interfaces.rest.resources.UpdateCoachResource;

public class UpdateCoachCommandFromResourceAssembler {
    public static UpdateCoachCommand toCommandFromResource(Long coachId, UpdateCoachResource resource) {
        return new UpdateCoachCommand(
            coachId,
            resource.firstName(),
            resource.lastName(),
            resource.email(),
            resource.image(),
            resource.specialization()
        );
    }
}
