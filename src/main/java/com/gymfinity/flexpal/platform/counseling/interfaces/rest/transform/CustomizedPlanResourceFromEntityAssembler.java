package com.gymfinity.flexpal.platform.counseling.interfaces.rest.transform;

import com.gymfinity.flexpal.platform.counseling.domain.model.aggregates.CustomizedPlan;
import com.gymfinity.flexpal.platform.counseling.interfaces.rest.resources.CustomizedPlanResource;

import java.util.Optional;

public class CustomizedPlanResourceFromEntityAssembler {
    public static CustomizedPlanResource toResourceFromEntity(Optional<CustomizedPlan> customizedPlan) {
        return new CustomizedPlanResource(
            customizedPlan.get().getId(),
            customizedPlan.get().getName(),
            customizedPlan.get().getCoachId(),
            customizedPlan.get().getMemberId(),
            customizedPlan.get().getGoal(),
            customizedPlan.get().getBenefits(),
            customizedPlan.get().getPlan()
        );
    }
}
