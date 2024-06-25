package com.gymfinity.flexpal.platform.iam.application.internal.outboundservices.acl;

import com.gymfinity.flexpal.platform.profiles.interfaces.acl.ProfilesContextFacade;
import org.springframework.stereotype.Service;


@Service
public class ExternalProfileServices {

    private final ProfilesContextFacade profilesContextFacade;

    public ExternalProfileServices(ProfilesContextFacade profilesContextFacade) {
        this.profilesContextFacade = profilesContextFacade;
    }

    public void createProfile(String firstName, String lastName, String email) {
        profilesContextFacade.createProfile(firstName, lastName, email, "image.png");
    }
}
