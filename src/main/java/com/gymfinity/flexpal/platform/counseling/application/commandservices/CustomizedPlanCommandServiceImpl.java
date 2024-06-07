package com.gymfinity.flexpal.platform.counseling.application.commandservices;

import com.gymfinity.flexpal.platform.counseling.domain.model.aggregates.CustomizedPlan;
import com.gymfinity.flexpal.platform.counseling.domain.model.commands.CreateCustomizedPlanCommand;
import com.gymfinity.flexpal.platform.counseling.domain.services.CustomizedPlanCommandService;
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
    public Optional<CustomizedPlan> handle(CreateCustomizedPlanCommand command) {
        var customizedPlan = new CustomizedPlan(command);
        var createdCustomizedPlan = customizedPlanRepository.save(customizedPlan);
        return Optional.of(createdCustomizedPlan);
    }
}
