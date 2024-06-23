package com.gymfinity.flexpal.platform.counseling.application.internal.commandservices;

import com.gymfinity.flexpal.platform.counseling.application.internal.outboundservices.acl.ExternalProfileService;
import com.gymfinity.flexpal.platform.counseling.domain.model.aggregates.Member;
import com.gymfinity.flexpal.platform.counseling.domain.model.commands.CreateMemberCommand;
import com.gymfinity.flexpal.platform.counseling.domain.services.commandservices.MemberCommandService;
import com.gymfinity.flexpal.platform.counseling.infrastructure.persistence.jpa.repositories.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberCommandServiceImpl implements MemberCommandService {

    private final MemberRepository memberRepository;
    private final ExternalProfileService externalProfileService;

    public MemberCommandServiceImpl(MemberRepository memberRepository, ExternalProfileService externalProfileService) {
        this.memberRepository = memberRepository;
        this.externalProfileService = externalProfileService;
    }

    @Override
    public Optional<Member> handle(CreateMemberCommand command) {
        var profileId =externalProfileService.fetchProfileIdByEmail(command.email());

        if (profileId.isEmpty()) {
            profileId = externalProfileService.createProfile(command.firstName(), command.lastName(), command.email(), command.image());
        } else {
            memberRepository.findByProfileId(profileId.get()).ifPresent(member -> {
                throw new IllegalArgumentException("Member already exists");
            });
        }

        if (profileId.isEmpty()) throw new IllegalArgumentException("Unable to create profile");

        var member = new Member(profileId.get());
        memberRepository.save(member);
        return Optional.of(member);
    }
}
