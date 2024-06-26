package com.gymfinity.flexpal.platform.professionalsmanagement.interfaces.transform;

import com.gymfinity.flexpal.platform.professionalsmanagement.domain.model.commands.CreateCoachProfessionalCommand;
import com.gymfinity.flexpal.platform.professionalsmanagement.interfaces.resources.CreateCoachProfessionalResource;

public class CreateCoachProfessionalCommandFromResourceAssembler {
    public static CreateCoachProfessionalCommand toCommandFromResource(CreateCoachProfessionalResource resource) {
        return new CreateCoachProfessionalCommand(resource.firstName(), resource.lastName(), resource.phrase(),
                resource.email());
    }
}
