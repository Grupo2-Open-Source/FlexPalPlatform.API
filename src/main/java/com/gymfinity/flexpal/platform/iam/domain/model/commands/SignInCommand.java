package com.gymfinity.flexpal.platform.iam.domain.model.commands;

public record SignInCommand(String username,
                            String password,
                            String firstName,
                            String lastName,
                            String email) {
}
