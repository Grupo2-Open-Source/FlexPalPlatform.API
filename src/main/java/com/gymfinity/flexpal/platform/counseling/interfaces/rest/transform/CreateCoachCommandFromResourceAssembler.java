package com.gymfinity.flexpal.platform.counseling.interfaces.rest.transform;

import com.gymfinity.flexpal.platform.counseling.domain.model.commands.CreateCoachCommand;
import com.gymfinity.flexpal.platform.counseling.interfaces.rest.resource.CreateCoachResource;

public class CreateCoachCommandFromResourceAssembler {
    public static CreateCoachCommand toCommandFromSource(CreateCoachResource resource){
         return new CreateCoachCommand(resource.specialty(),
                                       resource.lengthOfService(),
                                       resource.firstName(),
                                       resource.lastName(),
                                       resource.email(),
                                       resource.coachId(),
                                       resource.profileId());
    }
}
