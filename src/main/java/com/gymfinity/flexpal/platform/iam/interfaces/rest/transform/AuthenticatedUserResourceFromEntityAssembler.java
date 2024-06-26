package com.gymfinity.flexpal.platform.iam.interfaces.rest.transform;

import com.gymfinity.flexpal.platform.iam.domain.model.aggregates.User;
import com.gymfinity.flexpal.platform.iam.interfaces.rest.resources.AuthenticatedUserResource;

public class AuthenticatedUserResourceFromEntityAssembler {
    public static AuthenticatedUserResource toResourceFromEntity(User user, String token) {
        return new AuthenticatedUserResource(user.getId(), user.getUsername(), token);
    }
}
