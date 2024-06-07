package com.gymfinity.flexpal.platform.counseling.domain.model.commands;

import com.gymfinity.flexpal.platform.counseling.domain.model.aggregates.Member;
import com.gymfinity.flexpal.platform.counseling.domain.model.valueobjects.MemberId;
import com.gymfinity.flexpal.platform.counseling.domain.model.valueobjects.ProfileId;

public record CreateMemberCommand(String objective, String levelOfExperience, String firstName, String lastName, String email, String image, MemberId memberId, ProfileId profileId) {
}
