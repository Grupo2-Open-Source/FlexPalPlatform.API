package com.gymfinity.flexpal.platform.profiles.interfaces.rest;

import com.gymfinity.flexpal.platform.profiles.domain.model.aggregates.Profile;
import com.gymfinity.flexpal.platform.profiles.domain.model.queries.GetAllProfilesQuery;
import com.gymfinity.flexpal.platform.profiles.domain.model.queries.GetProfileByIdQuery;
import com.gymfinity.flexpal.platform.profiles.domain.services.ProfileCommandService;
import com.gymfinity.flexpal.platform.profiles.domain.services.ProfileQueryService;
import com.gymfinity.flexpal.platform.profiles.interfaces.rest.resources.CreateProfileResource;
import com.gymfinity.flexpal.platform.profiles.interfaces.rest.resources.ProfileResource;
import com.gymfinity.flexpal.platform.profiles.interfaces.rest.transform.CreateProfileCommandFromResourceAssembler;
import com.gymfinity.flexpal.platform.profiles.interfaces.rest.transform.ProfileSourceFromEntityAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/v1/profiles")
public class ProfileController {
    private final ProfileCommandService profileCommandService;
    private final ProfileQueryService profileQueryService;

    public ProfileController(ProfileCommandService profileCommandService, ProfileQueryService profileQueryService){
        this.profileCommandService = profileCommandService;
        this.profileQueryService = profileQueryService;
    }

    @PostMapping
    public ResponseEntity<ProfileResource> createProfile(@RequestBody CreateProfileResource resource){
        Optional<Profile> profileResource = profileCommandService.
                handle(CreateProfileCommandFromResourceAssembler.toCommandFromSource(resource));

        return profileResource.map(profile -> new ResponseEntity<>(
                ProfileSourceFromEntityAssembler.toResourceFromEntity(profile), CREATED)).
                orElseGet(()-> ResponseEntity.badRequest().build());
    }

    @GetMapping
    private ResponseEntity<List<ProfileResource>> getAllProfile() {
        var getAllProfiles = new GetAllProfilesQuery();
        var profiles = profileQueryService.handle(getAllProfiles);

        var profilesResources = profiles.stream().map(
                ProfileSourceFromEntityAssembler::toResourceFromEntity).toList();

        return ResponseEntity.ok(profilesResources);
    }

    @GetMapping(value= "/{profileId}")
    public ResponseEntity<ProfileResource> getProfileById(@PathVariable Long profileId) {
        var getProfileByIdQuery = new GetProfileByIdQuery(profileId);
        var profile = profileQueryService.handle(getProfileByIdQuery);
        if (profile.isEmpty()) return ResponseEntity.badRequest().build();
        var profileResource = ProfileSourceFromEntityAssembler.toResourceFromEntity(profile.get());
        return ResponseEntity.ok(profileResource);
    }
}
