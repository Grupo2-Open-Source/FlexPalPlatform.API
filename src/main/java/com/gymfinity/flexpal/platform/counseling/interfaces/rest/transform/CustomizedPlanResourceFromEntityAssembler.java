package com.gymfinity.flexpal.platform.counseling.interfaces.rest.transform;

import com.gymfinity.flexpal.platform.counseling.domain.model.aggregates.CustomizedPlan;
import com.gymfinity.flexpal.platform.counseling.interfaces.rest.resources.CustomizedPlanResource;

public class CustomizedPlanResourceFromEntityAssembler {
    public static CustomizedPlanResource toResourceFromEntity(CustomizedPlan customizedPlan) {
        return new CustomizedPlanResource(
            customizedPlan.getId(),
            customizedPlan.getName(),
            customizedPlan.getCoachId(),
            customizedPlan.getMemberId(),
            customizedPlan.getGoal(),
            customizedPlan.getBenefits(),
            customizedPlan.getPlan()
        );
    }
}
