package com.gymfinity.flexpal.platform.counseling.domain.services;

import com.gymfinity.flexpal.platform.counseling.domain.model.aggregates.CustomizedPlan;
import com.gymfinity.flexpal.platform.counseling.domain.model.commands.CreateCustomizedPlanCommand;

import java.util.Optional;

public interface CustomizedPlanCommandService {
    Optional<CustomizedPlan> handle(CreateCustomizedPlanCommand command);
}
