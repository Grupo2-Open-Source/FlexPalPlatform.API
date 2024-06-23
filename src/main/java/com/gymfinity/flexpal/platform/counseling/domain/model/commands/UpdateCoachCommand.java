package com.gymfinity.flexpal.platform.counseling.domain.model.commands;

public record UpdateCoachCommand(Long coachId, String firstName, String lastName, String email, String image, String specialization) {
}
