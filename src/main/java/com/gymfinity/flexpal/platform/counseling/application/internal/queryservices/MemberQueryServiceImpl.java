package com.gymfinity.flexpal.platform.counseling.application.internal.queryservices;

import com.gymfinity.flexpal.platform.counseling.domain.model.aggregates.Member;
import com.gymfinity.flexpal.platform.counseling.domain.model.queries.*;
import com.gymfinity.flexpal.platform.counseling.domain.services.queryservices.MemberQueryService;
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
    public List<Member> handle(GetAllMembersQuery query) {
        return memberRepository.findAll();
    }

    @Override
    public Optional<Member> handle(GetMemberByIdQuery query) {
        return memberRepository.findById(query.memberId());
    }

    @Override
    public Optional<Member> handle(GetMemberByCustomizedPlanQuery query) {
        return memberRepository.findByCustomizedPlan(query.customizedPlanId());
    }

    @Override
    public Optional<Member> handle(GetMemberByNameQuery query) {
        return memberRepository.findByName(query.memberName());
    }

    @Override
    public Optional<Member> handle(GetMemberByEmailQuery query) {
        return memberRepository.findByEmail(query.memberEmail());
    }
}
