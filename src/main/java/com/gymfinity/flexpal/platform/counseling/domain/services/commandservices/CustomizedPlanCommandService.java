package com.gymfinity.flexpal.platform.counseling.domain.services.commandservices;

import com.gymfinity.flexpal.platform.counseling.domain.model.aggregates.CustomizedPlan;
import com.gymfinity.flexpal.platform.counseling.domain.model.commands.CreateCustomizePlanCommand;

import java.util.Optional;

public interface CustomizedPlanCommandService {
    Optional<CustomizedPlan> handle(CreateCustomizePlanCommand command);
}
