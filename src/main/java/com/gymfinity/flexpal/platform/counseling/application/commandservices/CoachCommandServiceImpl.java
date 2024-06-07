package com.gymfinity.flexpal.platform.counseling.application.commandservices;

import com.gymfinity.flexpal.platform.counseling.domain.model.aggregates.Coach;
import com.gymfinity.flexpal.platform.counseling.domain.model.commands.CreateCoachCommand;
import com.gymfinity.flexpal.platform.counseling.domain.services.CoachCommandService;
import com.gymfinity.flexpal.platform.counseling.infrastructure.persistence.jpa.repositories.CoachRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CoachCommandServiceImpl implements CoachCommandService {

    private final CoachRepository coachRepository;

    public CoachCommandServiceImpl(CoachRepository coachRepository) {
        this.coachRepository = coachRepository;
    }

    @Override
    public Optional<Coach> handle(CreateCoachCommand command) {
        var coach = new Coach(command);
        var createdCoach = coachRepository.save(coach);
        return Optional.of(createdCoach);
    }
}