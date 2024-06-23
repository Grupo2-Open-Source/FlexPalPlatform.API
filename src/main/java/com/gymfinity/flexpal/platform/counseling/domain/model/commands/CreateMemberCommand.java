package com.gymfinity.flexpal.platform.counseling.domain.model.commands;

public record CreateMemberCommand(String firstName, String lastName, String email, String image, Long customizedPlanId, Long coachId, Long subscriptionId) {
}
