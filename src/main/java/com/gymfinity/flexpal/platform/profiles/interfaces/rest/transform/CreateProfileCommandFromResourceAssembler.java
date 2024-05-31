package com.gymfinity.flexpal.platform.profiles.interfaces.rest.transform;

import com.gymfinity.flexpal.platform.profiles.domain.model.commands.CreateProfileCommand;
import com.gymfinity.flexpal.platform.profiles.interfaces.rest.resources.CreateProfileResource;

public class CreateProfileCommandFromResourceAssembler {

    public static CreateProfileCommand toCommandFromSource(CreateProfileResource resource) {
        return new CreateProfileCommand(resource.firstName(), resource.lastName(), resource.email(), resource.image());
    }
}
