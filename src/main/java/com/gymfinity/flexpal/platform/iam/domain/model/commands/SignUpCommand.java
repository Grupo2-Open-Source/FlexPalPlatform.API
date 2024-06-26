package com.gymfinity.flexpal.platform.iam.domain.model.commands;

import com.gymfinity.flexpal.platform.iam.domain.model.entities.Role;

import java.util.List;

public record SignUpCommand(String username,
                            String password,
                            String firstName,
                            String lastName,
                            String email,
                            List<Role> roles) {
}
