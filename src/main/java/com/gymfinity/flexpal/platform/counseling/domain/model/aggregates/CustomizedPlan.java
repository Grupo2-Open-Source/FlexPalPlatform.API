package com.gymfinity.flexpal.platform.counseling.domain.model.aggregates;

import com.gymfinity.flexpal.platform.counseling.domain.model.commands.CreateCustomizedPlanCommand;
import com.gymfinity.flexpal.platform.counseling.domain.model.valueobjects.CoachId;
import com.gymfinity.flexpal.platform.counseling.domain.model.valueobjects.FoodInformationItem;
import com.gymfinity.flexpal.platform.counseling.domain.model.valueobjects.MemberId;
import com.gymfinity.flexpal.platform.counseling.domain.model.valueobjects.RoutineItem;
import com.gymfinity.flexpal.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;

@Entity
public class CustomizedPlan extends AuditableAbstractAggregateRoot<CustomizedPlan> {
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "exercise", column = @Column(name = "routine_name")),
            @AttributeOverride(name = "exerciseType", column = @Column(name = "routine_type")),
            @AttributeOverride(name = "sets", column = @Column(name = "routine_sets")),
            @AttributeOverride(name = "reps", column = @Column(name = "routine_reps")),
            @AttributeOverride(name = "weight", column = @Column(name = "routine_weight")),
            @AttributeOverride(name = "restTime", column = @Column(name = "routine_rest_time"))})
    private RoutineItem Routine;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "foodName", column = @Column(name = "food_name")),
            @AttributeOverride(name = "foodType", column = @Column(name = "food_type")),
            @AttributeOverride(name = "calories", column = @Column(name = "food_calories")),
            @AttributeOverride(name = "mealTime", column = @Column(name = "food_meal_time"))
    })
    private FoodInformationItem FoodInformation;

    @Embedded
    private CoachId coachId;

    @Embedded
    private MemberId memberId;

    public CustomizedPlan(CreateCustomizedPlanCommand command) {
        this.Routine = command.routineItem();
        this.FoodInformation = command.foodInformationItem();
        this.coachId = command.coachId();
        this.memberId = command.memberId();
    }

    public CustomizedPlan(){}

    public String getRoutineItem(){
        return Routine.getRoutineItem();
    }

    public String getFoodInformationItem(){ return FoodInformation.getFoodInformationItem(); }
}
