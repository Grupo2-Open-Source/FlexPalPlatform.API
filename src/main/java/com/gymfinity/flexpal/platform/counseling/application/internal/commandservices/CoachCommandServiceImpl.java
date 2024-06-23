package com.gymfinity.flexpal.platform.counseling.application.internal.commandservices;

import com.gymfinity.flexpal.platform.counseling.application.internal.outboundservices.acl.ExternalProfileService;
import com.gymfinity.flexpal.platform.counseling.domain.model.aggregates.Coach;
import com.gymfinity.flexpal.platform.counseling.domain.model.commands.CreateCoachCommand;
import com.gymfinity.flexpal.platform.counseling.domain.services.commandservices.CoachCommandService;
import com.gymfinity.flexpal.platform.counseling.infrastructure.persistence.jpa.repositories.CoachRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CoachCommandServiceImpl implements CoachCommandService {

    private final CoachRepository coachRepository;
    private final ExternalProfileService externalProfileService;

    public CoachCommandServiceImpl(CoachRepository coachRepository, ExternalProfileService externalProfileService) {
        this.coachRepository = coachRepository;
        this.externalProfileService = externalProfileService;
    }

    @Override
    public Optional<Coach> handle(CreateCoachCommand command) {
        var profileId = externalProfileService.fetchProfileIdByEmail(command.email());

        if (profileId.isEmpty()) {
            profileId = externalProfileService.createProfile(command.firstName(), command.lastName(), command.email(), command.image());
        } else {
            coachRepository.findByProfileId(profileId.get().profileId()).ifPresent(coach -> {
                throw new IllegalArgumentException("Coach already exists");
            });
        }

        if (profileId.isEmpty()) throw new IllegalArgumentException("Unable to create profile");

        var coach = new Coach(profileId.get().profileId(), command.specialization());
        coachRepository.save(coach);
        return Optional.of(coach);
    }
}