package com.gymfinity.flexpal.platform.counseling.application.queryservices;

import com.gymfinity.flexpal.platform.counseling.domain.model.aggregates.CustomizedPlan;
import com.gymfinity.flexpal.platform.counseling.domain.model.queries.GetAllCustomizedPlansQuery;
import com.gymfinity.flexpal.platform.counseling.domain.model.queries.GetCustomizedPlanByIdQuery;
import com.gymfinity.flexpal.platform.counseling.domain.services.CustomizedPlanQueryService;
import com.gymfinity.flexpal.platform.counseling.infrastructure.persistence.jpa.repositories.CustomizedPlanRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomizedPlanQueryServiceImpl implements CustomizedPlanQueryService {
    private final CustomizedPlanRepository customizedPlanRepository;

    public CustomizedPlanQueryServiceImpl(CustomizedPlanRepository customizedPlanRepository) {
        this.customizedPlanRepository = customizedPlanRepository;
    }

    @Override
    public Optional<CustomizedPlan> handle(GetCustomizedPlanByIdQuery query) {
        return customizedPlanRepository.findByPlanId(query.Id());
    }

    @Override
    public List<CustomizedPlan> handle(GetAllCustomizedPlansQuery query) {
        return customizedPlanRepository.findAllPlans();
    }
}
