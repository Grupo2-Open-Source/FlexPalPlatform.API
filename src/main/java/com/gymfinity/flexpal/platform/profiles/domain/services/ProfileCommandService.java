package com.gymfinity.flexpal.platform.profiles.domain.services;

import com.gymfinity.flexpal.platform.profiles.domain.model.aggregates.Profile;
import com.gymfinity.flexpal.platform.profiles.domain.model.commands.CreateProfileCommand;

import java.util.Optional;


public interface ProfileCommandService {
    Optional<Profile> handle(CreateProfileCommand command);
}
