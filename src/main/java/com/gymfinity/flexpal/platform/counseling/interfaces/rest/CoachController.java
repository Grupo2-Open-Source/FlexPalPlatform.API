package com.gymfinity.flexpal.platform.counseling.interfaces.rest;

import com.gymfinity.flexpal.platform.counseling.domain.model.queries.GetAllCoachesQuery;
import com.gymfinity.flexpal.platform.counseling.domain.model.queries.GetCoachByIdQuery;
import com.gymfinity.flexpal.platform.counseling.domain.services.commandservices.CoachCommandService;
import com.gymfinity.flexpal.platform.counseling.domain.services.queryservices.CoachQueryService;
import com.gymfinity.flexpal.platform.counseling.interfaces.rest.resources.CoachResource;
import com.gymfinity.flexpal.platform.counseling.interfaces.rest.resources.CreateCoachResource;
import com.gymfinity.flexpal.platform.counseling.interfaces.rest.resources.UpdateCoachResource;
import com.gymfinity.flexpal.platform.counseling.interfaces.rest.transform.CoachResourceFromEntityAssembler;
import com.gymfinity.flexpal.platform.counseling.interfaces.rest.transform.CreateCoachCommandFromResourceAssembler;
import com.gymfinity.flexpal.platform.counseling.interfaces.rest.transform.UpdateCoachCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/coaches")
@Tag(name = "Coaches", description = "Coach Management Endpoints")
public class CoachController {
    private final CoachCommandService coachCommandService;
    private final CoachQueryService coachQueryService;

    public CoachController(CoachCommandService coachCommandService, CoachQueryService coachQueryService) {
        this.coachCommandService = coachCommandService;
        this.coachQueryService = coachQueryService;
    }

    @PostMapping
    //@PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<CoachResource> createCoach(@RequestBody CreateCoachResource resource) {
        var createCoachCommand = CreateCoachCommandFromResourceAssembler.toCommandFromResource(resource);
        var coachId = coachCommandService.handle(createCoachCommand);
        if (coachId.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var getCoachByIdQuery = new GetCoachByIdQuery(coachId.get().getId());
        var coach = coachQueryService.handle(getCoachByIdQuery);
        if (coach.isPresent()) {
            var coachResource = CoachResourceFromEntityAssembler.toResourceFromEntity(coach.get());
            return ResponseEntity.ok(coachResource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "/{coachId}")
    public ResponseEntity<CoachResource> getCoachById(@PathVariable Long coachId) {
        var getCoachByIdQuery = new GetCoachByIdQuery(coachId);
        var coach = coachQueryService.handle(getCoachByIdQuery);
        if (coach.isPresent()) {
            var coachResource = CoachResourceFromEntityAssembler.toResourceFromEntity(coach.get());
            return ResponseEntity.ok(coachResource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<CoachResource>> getAllCoaches(){
        var getAllCoachesQuery = new GetAllCoachesQuery();
        var coaches = coachQueryService.handle(getAllCoachesQuery);
        var coachResources = coaches.stream().map(CoachResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(coachResources);
    }

    @PutMapping(value = "/{coachId}")
    public ResponseEntity<CoachResource> updateCoach(@PathVariable Long coachId, @RequestBody UpdateCoachResource updateCoachResource){
        var updateCoachCommand = UpdateCoachCommandFromResourceAssembler.toCommandFromResource(coachId,updateCoachResource);
        var coach = coachCommandService.handle(updateCoachCommand);
        if (coach.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        var coachResource = CoachResourceFromEntityAssembler.toResourceFromEntity(coach.get());
        return ResponseEntity.ok(coachResource);
    }

}
