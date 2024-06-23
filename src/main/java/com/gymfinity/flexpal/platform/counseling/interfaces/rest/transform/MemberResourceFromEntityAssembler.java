package com.gymfinity.flexpal.platform.counseling.interfaces.rest.transform;

import com.gymfinity.flexpal.platform.counseling.domain.model.aggregates.Member;
import com.gymfinity.flexpal.platform.counseling.interfaces.rest.resources.MemberResource;

public class MemberResourceFromEntityAssembler {
    public static MemberResource toResourceFromEntity(Member member) {
        return new MemberResource(
            member.getId(),
            member.getProfileId().profileId(),
            member.getSubscriptionId().subscriptionId(),
            member.getCustomizedPlan().getId(),
            member.getCoachId().getId()
        );
    }
}
