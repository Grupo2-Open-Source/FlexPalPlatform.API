package com.gymfinity.flexpal.platform.counseling.interfaces.rest.resource;

import com.gymfinity.flexpal.platform.counseling.domain.model.valueobjects.MemberId;
import com.gymfinity.flexpal.platform.counseling.domain.model.valueobjects.ProfileId;

public record CreateMemberResource(String objective,
                                   String levelOfExperience,
                                   String firstName,
                                   String lastName,
                                   String email,
                                   String image,
                                   MemberId memberId,
                                   ProfileId profileId){
}
