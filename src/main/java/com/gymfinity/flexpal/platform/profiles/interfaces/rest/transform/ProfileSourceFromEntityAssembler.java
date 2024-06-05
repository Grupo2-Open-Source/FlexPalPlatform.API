package com.gymfinity.flexpal.platform.profiles.interfaces.rest.transform;

import com.gymfinity.flexpal.platform.profiles.domain.model.aggregates.Profile;
import com.gymfinity.flexpal.platform.profiles.interfaces.rest.resources.ProfileResource;

public class ProfileSourceFromEntityAssembler {
    public static ProfileResource toResourceFromEntity(Profile entity) {
        return new ProfileResource(entity.getId(), entity.getFirstName(), entity.getLastName(), entity.getEmailAddress(), entity.getUrlImage());
    }
}
