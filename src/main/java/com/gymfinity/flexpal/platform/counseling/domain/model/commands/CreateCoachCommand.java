package com.gymfinity.flexpal.platform.counseling.domain.model.commands;

public record CreateCoachCommand(String firstName, String lastName, String email, String image, String specialization) {

}
