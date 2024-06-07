package com.gymfinity.flexpal.platform.counseling.interfaces.rest.resource;

import com.gymfinity.flexpal.platform.counseling.domain.model.valueobjects.CoachId;
import com.gymfinity.flexpal.platform.counseling.domain.model.valueobjects.FoodInformationItem;
import com.gymfinity.flexpal.platform.counseling.domain.model.valueobjects.MemberId;
import com.gymfinity.flexpal.platform.counseling.domain.model.valueobjects.RoutineItem;

public record CreateCustomizedPlanResource(RoutineItem routineItem, FoodInformationItem foodInformationItem, CoachId coachId, MemberId memberId, Long id){
}
