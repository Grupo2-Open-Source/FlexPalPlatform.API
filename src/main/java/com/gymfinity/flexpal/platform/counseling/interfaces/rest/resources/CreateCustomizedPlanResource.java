package com.gymfinity.flexpal.platform.counseling.interfaces.rest.resources;

public record CreateCustomizedPlanResource(String name, int coachId, int memberId, String goal, String benefits, String plan) {
}
