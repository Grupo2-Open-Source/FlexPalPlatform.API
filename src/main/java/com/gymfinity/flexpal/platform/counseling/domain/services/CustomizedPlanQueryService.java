package com.gymfinity.flexpal.platform.counseling.domain.services;

import com.gymfinity.flexpal.platform.counseling.domain.model.aggregates.CustomizedPlan;
import com.gymfinity.flexpal.platform.counseling.domain.model.queries.GetAllCustomizedPlansQuery;
import com.gymfinity.flexpal.platform.counseling.domain.model.queries.GetCustomizedPlanByIdQuery;

import java.util.List;
import java.util.Optional;

public interface CustomizedPlanQueryService {

    Optional<CustomizedPlan> handle(GetCustomizedPlanByIdQuery query);

    List<CustomizedPlan> handle(GetAllCustomizedPlansQuery query);
}
