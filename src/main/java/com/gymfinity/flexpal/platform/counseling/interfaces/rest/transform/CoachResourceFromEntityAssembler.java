package com.gymfinity.flexpal.platform.counseling.interfaces.rest.transform;

import com.gymfinity.flexpal.platform.counseling.domain.model.aggregates.Coach;
import com.gymfinity.flexpal.platform.counseling.interfaces.rest.resources.CoachResource;

import java.util.Optional;

public class CoachResourceFromEntityAssembler {
    public static CoachResource toResourceFromEntity(Optional<Coach> coach) {
        return new CoachResource(coach.get().getId(), coach.get().getProfileId().profileId(), coach.get().getSpecialization());
    }
}