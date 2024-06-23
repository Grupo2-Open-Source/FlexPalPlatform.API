package com.gymfinity.flexpal.platform.counseling.domain.services.commandservices;

import com.gymfinity.flexpal.platform.counseling.domain.model.aggregates.Member;
import com.gymfinity.flexpal.platform.counseling.domain.model.commands.CreateMemberCommand;

import java.util.Optional;

public interface MemberCommandService {
    Optional<Member> handle(CreateMemberCommand command);
}
