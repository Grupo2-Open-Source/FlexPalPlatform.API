package com.gymfinity.flexpal.platform.counseling.interfaces.rest.transform;

import com.gymfinity.flexpal.platform.counseling.domain.model.commands.CreateCustomizedPlanCommand;
import com.gymfinity.flexpal.platform.counseling.domain.model.valueobjects.FoodInformationItem;
import com.gymfinity.flexpal.platform.counseling.domain.model.valueobjects.RoutineItem;
import com.gymfinity.flexpal.platform.counseling.interfaces.rest.resource.CreateCustomizedPlanResource;

public class CreateCustomizedPlanCommandFromResourceAssembler {
    public static CreateCustomizedPlanCommand fromResource(CreateCustomizedPlanResource resource) {
        return new CreateCustomizedPlanCommand(resource.routineItem(),
                                              resource.foodInformationItem(),
                                              resource.coachId(),
                                              resource.memberId(),
                                              resource.id());
                  }
}
