package com.gymfinity.flexpal.platform.counseling.interfaces.rest.resources;

public record UpdateMemberResource(String firstName, String lastName, String email, String image, Long customizedPlanId, Long coachId, Long subscriptionId) {
}
