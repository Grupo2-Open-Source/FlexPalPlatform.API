package com.gymfinity.flexpal.platform.counseling.domain.services;

import com.gymfinity.flexpal.platform.counseling.domain.model.aggregates.Member;
import com.gymfinity.flexpal.platform.counseling.domain.model.queries.GetAllMembersQuery;
import com.gymfinity.flexpal.platform.counseling.domain.model.queries.GetMemberByIdQuery;
import com.gymfinity.flexpal.platform.counseling.domain.model.queries.GetMembersByLevelOfExperienceQuery;
import com.gymfinity.flexpal.platform.counseling.domain.model.queries.GetMembersByObjectiveQuery;

import java.util.List;
import java.util.Optional;

public interface MemberQueryService {
    Optional<Member> handle(GetMemberByIdQuery query);

    List<Member> handle(GetMembersByObjectiveQuery query);

    List<Member> handle(GetMembersByLevelOfExperienceQuery query);

    List<Member> handle(GetAllMembersQuery query);
}