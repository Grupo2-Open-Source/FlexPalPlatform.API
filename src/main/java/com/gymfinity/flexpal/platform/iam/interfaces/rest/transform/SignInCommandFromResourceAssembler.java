package com.gymfinity.flexpal.platform.iam.interfaces.rest.transform;

import com.gymfinity.flexpal.platform.iam.domain.model.commands.SignInCommand;
import com.gymfinity.flexpal.platform.iam.interfaces.rest.resources.SignInResource;

public class SignInCommandFromResourceAssembler {
    public static SignInCommand toCommandFromResource(SignInResource resource) {
        return new SignInCommand(resource.username(), resource.password(), resource.firstName(), resource.lastName(), resource.email());
    }
}
