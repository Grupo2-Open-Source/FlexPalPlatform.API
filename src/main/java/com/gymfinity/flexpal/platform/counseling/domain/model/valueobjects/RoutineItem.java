package com.gymfinity.flexpal.platform.counseling.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record RoutineItem(String exercise,
                          String exerciseType,
                          int sets,
                          int reps,
                          int weight,
                          int restTime){
    public RoutineItem(){
        this(null, null, 0, 0, 0, 0);
    }

    public RoutineItem(String exercise, String exerciseType, int sets, int reps, int restTime){
        this(exercise, exerciseType, sets, reps, 0, restTime);
    }

    public String getRoutineItem(){
        return String.format("%s %s, %s, %s, %s, %s", exercise, exerciseType, sets, reps, weight, restTime);
    }

    public RoutineItem {
        if (exercise == null || exercise.isBlank()) {
            throw new IllegalArgumentException("Exercise must not be null or blank");
        }

        if  (exerciseType == null || exerciseType.isBlank()) {
            throw new IllegalArgumentException("Exercise type must not be null or blank");
        }

        if (sets == 0) {
            throw new IllegalArgumentException("Number of sets must not be null or blank");
        }

        if  (reps == 0) {
            throw new IllegalArgumentException("Number of reps must not be null or blank");
        }

        if  (weight == 0){
            throw new IllegalArgumentException("Weight must not be null or blank");
        }
        if (restTime == 0){
            throw new IllegalArgumentException("Rest time must not be null or blank");
        }
    }

}
