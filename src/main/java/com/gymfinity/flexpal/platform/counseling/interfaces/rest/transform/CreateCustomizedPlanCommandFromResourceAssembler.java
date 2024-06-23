package com.gymfinity.flexpal.platform.counseling.interfaces.rest.transform;

import com.gymfinity.flexpal.platform.counseling.domain.model.commands.CreateCustomizePlanCommand;
import com.gymfinity.flexpal.platform.counseling.interfaces.rest.resources.CreateCustomizedPlanResource;

public class CreateCustomizedPlanCommandFromResourceAssembler {
    public static CreateCustomizePlanCommand toCommandFromResource(CreateCustomizedPlanResource resource) {
        return new CreateCustomizePlanCommand(
            resource.name(),
            resource.coachId(),
            resource.memberId(),
            resource.goal(),
            resource.benefits(),
            resource.plan()
        );
    }
}
