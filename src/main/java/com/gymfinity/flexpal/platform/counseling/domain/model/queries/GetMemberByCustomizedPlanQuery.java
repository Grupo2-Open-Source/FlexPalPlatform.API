package com.gymfinity.flexpal.platform.counseling.domain.model.queries;

import com.gymfinity.flexpal.platform.counseling.domain.model.aggregates.CustomizedPlan;

public record GetMemberByCustomizedPlanQuery(CustomizedPlan customizedPlanId) {
}
