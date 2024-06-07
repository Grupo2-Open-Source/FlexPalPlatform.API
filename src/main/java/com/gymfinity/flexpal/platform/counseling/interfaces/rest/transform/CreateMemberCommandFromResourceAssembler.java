package com.gymfinity.flexpal.platform.counseling.interfaces.rest.transform;

import com.gymfinity.flexpal.platform.counseling.domain.model.commands.CreateMemberCommand;
import com.gymfinity.flexpal.platform.counseling.interfaces.rest.resource.CreateMemberResource;

public class CreateMemberCommandFromResourceAssembler {
    public static CreateMemberCommand toCommandFromSource(CreateMemberResource resource){
         return new CreateMemberCommand(resource.objective(),
                                       resource.levelOfExperience(),
                                       resource.firstName(),
                                       resource.lastName(),
                                       resource.email(),
                                       resource.image(),
                                       resource.memberId(),
                                       resource.profileId());
    }
}
