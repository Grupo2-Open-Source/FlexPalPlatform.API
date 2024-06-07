package com.gymfinity.flexpal.platform.counseling.application.queryservices;

import com.gymfinity.flexpal.platform.counseling.domain.model.aggregates.Member;
import com.gymfinity.flexpal.platform.counseling.domain.model.queries.GetAllMembersQuery;
import com.gymfinity.flexpal.platform.counseling.domain.model.queries.GetMemberByIdQuery;
import com.gymfinity.flexpal.platform.counseling.domain.model.queries.GetMembersByLevelOfExperienceQuery;
import com.gymfinity.flexpal.platform.counseling.domain.model.queries.GetMembersByObjectiveQuery;
import com.gymfinity.flexpal.platform.counseling.domain.services.MemberQueryService;
import com.gymfinity.flexpal.platform.counseling.infrastructure.persistence.jpa.repositories.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberQueryServiceImpl implements MemberQueryService {
    private final MemberRepository memberRepository;

    public MemberQueryServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Optional<Member> handle(GetMemberByIdQuery query) {
        return memberRepository.findByMemberId(query.Id());
    }

    @Override
    public List<Member> handle(GetMembersByObjectiveQuery query) {
        return memberRepository.findByObjective(query.objective());
    }

    @Override
    public List<Member> handle(GetMembersByLevelOfExperienceQuery query) {
        return memberRepository.findByLevelOfExperience(query.levelOfExperience());
    }

    @Override
    public List<Member> handle(GetAllMembersQuery query) {
        return memberRepository.findAllMembers();
    }
}
