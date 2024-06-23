package com.gymfinity.flexpal.platform.counseling.interfaces.rest.resources;

public record CreateMemberResource(String firstName, String lastName, String email, String image, Long customizedPlanId, Long coachId, Long subscriptionId) {
}
