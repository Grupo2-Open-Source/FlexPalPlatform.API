package com.gymfinity.flexpal.platform.counseling.domain.model.aggregates;

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

    public CustomizedPlan(String exercise, String exerciseType, int sets, int reps, int weight, int restTime) {
        this.Routine = new RoutineItem(exercise, exerciseType, sets, reps, weight, restTime);
    }

    public CustomizedPlan(){}

    public String getRoutineItem(){
        return Routine.getRoutineItem();
    }
}
