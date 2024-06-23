package com.gymfinity.flexpal.platform.counseling.domain.model.commands;

public record CreateCustomizePlanCommand(String name, int coachId, int memberId, String goal, String benefits, String plan) {
}
