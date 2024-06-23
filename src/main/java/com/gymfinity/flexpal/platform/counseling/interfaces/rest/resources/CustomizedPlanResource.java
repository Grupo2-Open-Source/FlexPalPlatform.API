package com.gymfinity.flexpal.platform.counseling.interfaces.rest.resources;

public record CustomizedPlanResource(Long id, String name, int coachId, int memberId, String goal, String benefits, String plan) {
}
