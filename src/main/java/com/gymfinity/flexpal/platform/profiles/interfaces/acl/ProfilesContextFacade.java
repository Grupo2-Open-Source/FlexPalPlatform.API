package com.gymfinity.flexpal.platform.profiles.interfaces.acl;

import com.gymfinity.flexpal.platform.profiles.domain.model.commands.CreateProfileCommand;
import com.gymfinity.flexpal.platform.profiles.domain.model.queries.GetProfileByEmailQuery;
import com.gymfinity.flexpal.platform.profiles.domain.model.valueobjects.EmailAddress;
import com.gymfinity.flexpal.platform.profiles.domain.services.ProfileCommandService;
import com.gymfinity.flexpal.platform.profiles.domain.services.ProfileQueryService;
import org.springframework.stereotype.Service;

@Service
public class ProfilesContextFacade {
    private final ProfileCommandService profilesCommandService;
    private final ProfileQueryService profilesQueryService;

    public ProfilesContextFacade(ProfileCommandService profilesCommandService, ProfileQueryService profilesQueryService) {
        this.profilesCommandService = profilesCommandService;
        this.profilesQueryService = profilesQueryService;
    }

    public Long createProfile(String firstName, String lastName, String email, String image){
        var createProfileCommand = new CreateProfileCommand(firstName, lastName, email, image);
        var profile = profilesCommandService.handle(createProfileCommand);
        if (profile.isEmpty()) return 0L;
        return profile.get().getId();
    }

    public Long fetchProfileIdByEmail(String email){
        var getProfileByEmailQuery = new GetProfileByEmailQuery(new EmailAddress(email));
        var profile = profilesQueryService.handle(getProfileByEmailQuery);
        if (profile.isEmpty()) return 0L;
        return profile.get().getId();
    }
}
