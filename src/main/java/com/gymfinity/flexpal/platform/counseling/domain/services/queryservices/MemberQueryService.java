package com.gymfinity.flexpal.platform.counseling.domain.services.queryservices;

import com.gymfinity.flexpal.platform.counseling.domain.model.aggregates.Member;
import com.gymfinity.flexpal.platform.counseling.domain.model.queries.*;

import java.util.List;
import java.util.Optional;

public interface MemberQueryService {
    List<Member> handle(GetAllMembersQuery query);

    Optional<Member> handle(GetMemberByIdQuery query);

    Optional<Member> handle(GetMemberByCustomizedPlanQuery query);

    Optional<Member> handle(GetMemberByProfileIdQuery query);
}