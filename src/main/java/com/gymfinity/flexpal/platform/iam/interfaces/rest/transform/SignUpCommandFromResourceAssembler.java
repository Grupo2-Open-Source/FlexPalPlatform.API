package com.gymfinity.flexpal.platform.iam.interfaces.rest.transform;

import com.gymfinity.flexpal.platform.iam.domain.model.commands.SignUpCommand;
import com.gymfinity.flexpal.platform.iam.domain.model.entities.Role;
import com.gymfinity.flexpal.platform.iam.interfaces.rest.resources.SignUpResource;

import java.util.ArrayList;

public class SignUpCommandFromResourceAssembler {
    public static SignUpCommand toCommandFromResource(SignUpResource resource) {
        var roles = resource.roles() != null ? resource.roles().stream().map(
                name -> Role.toRoleFromName(name)).toList() : new ArrayList<Role>();

        return new SignUpCommand(resource.username(), resource.password(), resource.firstName(), resource.lastName(), resource.email(), roles);
    }
}
