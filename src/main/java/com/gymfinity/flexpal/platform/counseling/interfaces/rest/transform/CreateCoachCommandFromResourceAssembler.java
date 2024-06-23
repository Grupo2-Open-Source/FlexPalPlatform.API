package com.gymfinity.flexpal.platform.counseling.interfaces.rest.transform;

import com.gymfinity.flexpal.platform.counseling.domain.model.commands.CreateCoachCommand;
import com.gymfinity.flexpal.platform.counseling.interfaces.rest.resources.CreateCoachResource;

public class CreateCoachCommandFromResourceAssembler {
    public static CreateCoachCommand toCommandFromResource(CreateCoachResource resource) {
        return new CreateCoachCommand(
            resource.firstName(),
            resource.lastName(),
            resource.email(),
            resource.image(),
            resource.specialization()
        );
    }
}
