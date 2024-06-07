package com.gymfinity.flexpal.platform.counseling.application.commandservices;

import com.gymfinity.flexpal.platform.counseling.domain.model.aggregates.Member;
import com.gymfinity.flexpal.platform.counseling.domain.model.commands.CreateMemberCommand;
import com.gymfinity.flexpal.platform.counseling.domain.services.MemberCommandService;
import com.gymfinity.flexpal.platform.counseling.infrastructure.persistence.jpa.repositories.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberCommandServiceImpl implements MemberCommandService {
    private final MemberRepository memberRepository;

    public MemberCommandServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Optional<Member> handle(CreateMemberCommand command) {
        var member = new Member(command);
        var createdMember = memberRepository.save(member);
        return Optional.of(createdMember);
    }
}
