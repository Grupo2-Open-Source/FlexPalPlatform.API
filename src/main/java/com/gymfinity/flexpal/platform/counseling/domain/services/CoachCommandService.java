package com.gymfinity.flexpal.platform.counseling.domain.services;

import com.gymfinity.flexpal.platform.counseling.domain.model.aggregates.Coach;
import com.gymfinity.flexpal.platform.counseling.domain.model.commands.CreateCoachCommand;

import java.util.Optional;

public interface CoachCommandService {
    Optional<Coach> handle(CreateCoachCommand command);
}
