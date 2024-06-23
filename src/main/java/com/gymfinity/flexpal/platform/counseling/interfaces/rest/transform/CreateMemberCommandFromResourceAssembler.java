package com.gymfinity.flexpal.platform.counseling.interfaces.rest.transform;

import com.gymfinity.flexpal.platform.counseling.domain.model.commands.CreateMemberCommand;
import com.gymfinity.flexpal.platform.counseling.interfaces.rest.resources.CreateMemberResource;

public class CreateMemberCommandFromResourceAssembler {
    public static CreateMemberCommand toCommandFromResource(CreateMemberResource resource) {
        return new CreateMemberCommand(
            resource.firstName(),
            resource.lastName(),
            resource.email(),
            resource.image(),
            resource.customizedPlanId(),
            resource.coachId(),
            resource.subscriptionId()
        );
    }
}
