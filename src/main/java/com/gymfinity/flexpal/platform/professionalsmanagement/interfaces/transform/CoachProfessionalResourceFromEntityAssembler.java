package com.gymfinity.flexpal.platform.professionalsmanagement.interfaces.transform;

import com.gymfinity.flexpal.platform.professionalsmanagement.domain.model.aggregates.CoachProfessional;
import com.gymfinity.flexpal.platform.professionalsmanagement.interfaces.resources.CoachProfessionalResource;

public class CoachProfessionalResourceFromEntityAssembler {

    public static CoachProfessionalResource toResourceFromEntity(CoachProfessional entity) {
        return new CoachProfessionalResource(entity.getId(), entity.getFirstName(), entity.getLastName(),
                entity.getPhrase(), entity.getEmail());
    }

}
