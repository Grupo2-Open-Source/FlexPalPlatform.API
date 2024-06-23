package com.gymfinity.flexpal.platform.counseling.application.internal.outboundservices.acl;

import com.gymfinity.flexpal.platform.counseling.domain.model.valueobjects.ProfileId;
import com.gymfinity.flexpal.platform.profiles.interfaces.acl.ProfilesContextFacade;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExternalProfileService {
    private final ProfilesContextFacade profilesContextFacade;

    public ExternalProfileService(ProfilesContextFacade profilesContextFacade) {
        this.profilesContextFacade = profilesContextFacade;
    }

    public Optional<ProfileId> fetchProfileIdByEmail(String email) {
        var profileId = profilesContextFacade.fetchProfileIdByEmail(email);
        if (profileId == 0L) return Optional.empty();
        return Optional.of(new ProfileId(profileId));
    }

    public Optional<ProfileId> createProfile(String firstName, String lastName, String email, String image){
        var profileId = profilesContextFacade.createProfile(firstName, lastName, email, image);
        if (profileId == 0L) return Optional.empty();
        return Optional.of(new ProfileId(profileId));
    }
}
