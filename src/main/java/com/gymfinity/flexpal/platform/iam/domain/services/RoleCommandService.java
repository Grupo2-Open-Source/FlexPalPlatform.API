package com.gymfinity.flexpal.platform.iam.domain.services;


import com.gymfinity.flexpal.platform.iam.domain.model.commands.SeedRolesCommand;

public interface RoleCommandService {
    void handle(SeedRolesCommand command);
}
