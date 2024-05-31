package com.gymfinity.flexpal.platform.profiles.application.internal.commandservices;

import com.gymfinity.flexpal.platform.profiles.domain.model.aggregates.Profile;
import com.gymfinity.flexpal.platform.profiles.domain.model.commands.CreateProfileCommand;
import com.gymfinity.flexpal.platform.profiles.domain.services.ProfileCommandService;
import com.gymfinity.flexpal.platform.profiles.infrastructure.persistence.jpa.repositories.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileCommandServiceImpl implements ProfileCommandService {

    private final ProfileRepository profileRepository;

    public ProfileCommandServiceImpl(ProfileRepository profileRepository){
        this.profileRepository = profileRepository;
    }

    @Override
    public Optional<Profile> handle(CreateProfileCommand command) {

        var profile = new Profile(command);
        var createdProfile = profileRepository.save(profile);
        return Optional.of(createdProfile);
    }
}
