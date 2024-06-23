package com.gymfinity.flexpal.platform.counseling.domain.services.queryservices;

import com.gymfinity.flexpal.platform.counseling.domain.model.aggregates.CustomizedPlan;
import com.gymfinity.flexpal.platform.counseling.domain.model.queries.GetAllCustomizedPlansQuery;
import com.gymfinity.flexpal.platform.counseling.domain.model.queries.GetCustomizedPlanByIdQuery;

import java.util.List;
import java.util.Optional;

public interface CustomizedPlanQueryService {
    List<CustomizedPlan> handle(GetAllCustomizedPlansQuery query);

    Optional<CustomizedPlan> handle(GetCustomizedPlanByIdQuery query);
}