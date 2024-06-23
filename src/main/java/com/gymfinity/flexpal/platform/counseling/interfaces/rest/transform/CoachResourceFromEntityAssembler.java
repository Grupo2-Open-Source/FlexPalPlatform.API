package com.gymfinity.flexpal.platform.counseling.interfaces.rest.transform;

import com.gymfinity.flexpal.platform.counseling.domain.model.aggregates.Coach;
import com.gymfinity.flexpal.platform.counseling.interfaces.rest.resources.CoachResource;

import java.util.stream.Collectors;

public class CoachResourceFromEntityAssembler {
    public static CoachResource toResourceFromEntity(Coach coach) {
        if (coach != null) {
            String members = coach.getMembers().stream().map(member -> member.getId().toString()).collect(Collectors.joining(", "));
            return new CoachResource(coach.getId(), coach.getProfileId().profileId(), members);
        } else {
            throw new RuntimeException("Coach not found");
        }
    }
}