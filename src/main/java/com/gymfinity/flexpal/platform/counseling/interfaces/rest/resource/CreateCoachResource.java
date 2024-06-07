package com.gymfinity.flexpal.platform.counseling.interfaces.rest.resource;

import com.gymfinity.flexpal.platform.counseling.domain.model.valueobjects.CoachId;
import com.gymfinity.flexpal.platform.counseling.domain.model.valueobjects.ProfileId;

public record CreateCoachResource(String specialty,
                                  int lengthOfService,
                                  String firstName,
                                  String lastName,
                                  String email,
                                  String image,
                                  ProfileId profileId,
                                  CoachId coachId) {
}
