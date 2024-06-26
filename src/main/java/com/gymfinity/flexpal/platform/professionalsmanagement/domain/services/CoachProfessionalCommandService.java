package com.gymfinity.flexpal.platform.professionalsmanagement.domain.services;

import com.gymfinity.flexpal.platform.counseling.domain.model.aggregates.Coach;
import com.gymfinity.flexpal.platform.professionalsmanagement.domain.model.aggregates.CoachProfessional;
import com.gymfinity.flexpal.platform.professionalsmanagement.domain.model.commands.CreateCoachProfessionalCommand;

import java.util.Optional;

public interface CoachProfessionalCommandService {

    Optional<CoachProfessional> handle(CreateCoachProfessionalCommand command);
}
