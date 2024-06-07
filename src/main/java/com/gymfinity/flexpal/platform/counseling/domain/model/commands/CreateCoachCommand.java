package com.gymfinity.flexpal.platform.counseling.domain.model.commands;

import com.gymfinity.flexpal.platform.counseling.domain.model.valueobjects.CoachId;
import com.gymfinity.flexpal.platform.counseling.domain.model.valueobjects.ProfileId;

public record CreateCoachCommand(String specialty, int lengthOfService, String firstName, String lastName, String email, CoachId coachId, ProfileId profileId) {
}