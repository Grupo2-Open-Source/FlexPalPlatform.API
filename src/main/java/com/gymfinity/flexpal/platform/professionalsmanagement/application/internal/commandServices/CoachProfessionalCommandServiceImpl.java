package com.gymfinity.flexpal.platform.professionalsmanagement.application.internal.commandServices;

import com.gymfinity.flexpal.platform.counseling.domain.model.aggregates.Coach;
import com.gymfinity.flexpal.platform.professionalsmanagement.domain.model.aggregates.CoachProfessional;
import com.gymfinity.flexpal.platform.professionalsmanagement.domain.model.commands.CreateCoachProfessionalCommand;
import com.gymfinity.flexpal.platform.professionalsmanagement.domain.services.CoachProfessionalCommandService;
import com.gymfinity.flexpal.platform.professionalsmanagement.infrastructure.persistence.jpa.repositories.CoachProfessionalRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CoachProfessionalCommandServiceImpl implements CoachProfessionalCommandService {

    private final CoachProfessionalRepository coachProfessionalRepository;

    public CoachProfessionalCommandServiceImpl(CoachProfessionalRepository coachProfessionalRepository) {
        this.coachProfessionalRepository = coachProfessionalRepository;
    }

    @Override
    public Optional<CoachProfessional> handle(CreateCoachProfessionalCommand command) {

        var coach = new CoachProfessional(command.firstName(), command.lastName(), command.phrase(), command.email());
        var createdCoach = coachProfessionalRepository.save(coach);
        return Optional.of(createdCoach);
    }
}
