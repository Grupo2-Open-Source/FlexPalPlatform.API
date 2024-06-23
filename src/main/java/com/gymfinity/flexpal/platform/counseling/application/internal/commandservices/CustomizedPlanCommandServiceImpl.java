package com.gymfinity.flexpal.platform.counseling.application.internal.commandservices;

import com.gymfinity.flexpal.platform.counseling.domain.model.aggregates.CustomizedPlan;
import com.gymfinity.flexpal.platform.counseling.domain.model.commands.CreateCustomizePlanCommand;
import com.gymfinity.flexpal.platform.counseling.domain.services.commandservices.CustomizedPlanCommandService;
import com.gymfinity.flexpal.platform.counseling.infrastructure.persistence.jpa.repositories.CustomizedPlanRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomizedPlanCommandServiceImpl implements CustomizedPlanCommandService {

    private final CustomizedPlanRepository customizedPlanRepository;

    public CustomizedPlanCommandServiceImpl(CustomizedPlanRepository customizedPlanRepository) {
        this.customizedPlanRepository = customizedPlanRepository;
    }

    @Override
    public Optional<CustomizedPlan> handle(CreateCustomizePlanCommand command) {
        var customizedPlan = new CustomizedPlan(command);
        customizedPlanRepository.save(customizedPlan);
        return Optional.of(customizedPlan);
    }
}