package com.gymfinity.flexpal.platform.counseling.domain.model.commands;

import com.gymfinity.flexpal.platform.counseling.domain.model.valueobjects.CoachId;
import com.gymfinity.flexpal.platform.counseling.domain.model.valueobjects.FoodInformationItem;
import com.gymfinity.flexpal.platform.counseling.domain.model.valueobjects.MemberId;
import com.gymfinity.flexpal.platform.counseling.domain.model.valueobjects.RoutineItem;

public record CreateCustomizedPlanCommand(RoutineItem routineItem, FoodInformationItem foodInformationItem, CoachId coachId, MemberId memberId, Long id) {
}
