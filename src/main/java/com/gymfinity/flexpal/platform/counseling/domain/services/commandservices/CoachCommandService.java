package com.gymfinity.flexpal.platform.counseling.domain.services.commandservices;

import com.gymfinity.flexpal.platform.counseling.domain.model.aggregates.Coach;
import com.gymfinity.flexpal.platform.counseling.domain.model.commands.CreateCoachCommand;
import com.gymfinity.flexpal.platform.counseling.domain.model.commands.UpdateCoachCommand;

import java.util.Optional;

public interface CoachCommandService {
    Optional<Coach> handle(CreateCoachCommand command);

    Optional<Coach> handle(UpdateCoachCommand command);
}
