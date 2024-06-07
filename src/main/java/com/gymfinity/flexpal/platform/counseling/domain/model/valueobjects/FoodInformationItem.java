package com.gymfinity.flexpal.platform.counseling.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record FoodInformationItem(String foodName,
                                  String foodType,
                                  int calories,
                                  String mealTime) {

    public FoodInformationItem {
        if (foodName == null || foodName.isBlank()) {
            throw new IllegalArgumentException("Food name must not be null or blank");
        }

        if (foodType == null || foodType.isBlank()) {
            throw new IllegalArgumentException("Food type must not be null or blank");
        }

        if (calories <= 0) {
            throw new IllegalArgumentException("Calories must be greater than 0");
        }

        if (mealTime == null || mealTime.isBlank()) {
            throw new IllegalArgumentException("Meal time must not be null or blank");
        }
    }

    public String getFoodInformationItem(){
        return String.format("%s %s, %s, %s", foodName, foodType, calories, mealTime);
    }
}