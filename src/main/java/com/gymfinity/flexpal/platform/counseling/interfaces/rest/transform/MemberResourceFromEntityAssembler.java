package com.gymfinity.flexpal.platform.counseling.interfaces.rest.transform;

import com.gymfinity.flexpal.platform.counseling.domain.model.aggregates.Member;
import com.gymfinity.flexpal.platform.counseling.interfaces.rest.resources.MemberResource;

import java.util.Optional;

public class MemberResourceFromEntityAssembler {
    public static MemberResource toResourceFromEntity(Optional<Member> member) {
        return new MemberResource(
            member.get().getId(),
            member.get().getProfileId().profileId(),
            member.get().getSubscriptionId().subscriptionId(),
            member.get().getCustomizedPlan().getId(),
            member.get().getCoachId().getId()
        );
    }
}
