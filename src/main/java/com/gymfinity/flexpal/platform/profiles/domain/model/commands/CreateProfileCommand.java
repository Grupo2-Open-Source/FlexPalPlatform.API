package com.gymfinity.flexpal.platform.profiles.domain.model.commands;

public record CreateProfileCommand(String firstName, String lastName, String email, String image) {
}
