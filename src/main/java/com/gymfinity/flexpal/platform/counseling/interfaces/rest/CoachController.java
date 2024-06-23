package com.gymfinity.flexpal.platform.counseling.interfaces.rest;

import com.gymfinity.flexpal.platform.counseling.domain.model.queries.GetCoachByIdQuery;
import com.gymfinity.flexpal.platform.counseling.domain.services.commandservices.CoachCommandService;
import com.gymfinity.flexpal.platform.counseling.domain.services.queryservices.CoachQueryService;
import com.gymfinity.flexpal.platform.counseling.interfaces.rest.resources.CoachResource;
import com.gymfinity.flexpal.platform.counseling.interfaces.rest.resources.CreateCoachResource;
import com.gymfinity.flexpal.platform.counseling.interfaces.rest.transform.CoachResourceFromEntityAssembler;
import com.gymfinity.flexpal.platform.counseling.interfaces.rest.transform.CreateCoachCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<CoachResource> createCoach(@RequestBody CreateCoachResource resource) {
        var createCoachCommand = CreateCoachCommandFromResourceAssembler.toCommandFromResource(resource);
        var coachId = coachCommandService.handle(createCoachCommand);
        if (coachId.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var getCoachByIdQuery = new GetCoachByIdQuery(coachId.get().getId());
        var coach = coachQueryService.handle(getCoachByIdQuery);
        var coachResource = CoachResourceFromEntityAssembler.toResourceFromEntity(coach);
        return ResponseEntity.ok(coachResource);
    }

    @GetMapping(value = "/{coachId}")
    public ResponseEntity<CoachResource> getCoachById(@PathVariable Long coachId) {
        var getCoachByIdQuery = new GetCoachByIdQuery(coachId);
        var coach = coachQueryService.handle(getCoachByIdQuery);
        if (coach.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var coachResource = CoachResourceFromEntityAssembler.toResourceFromEntity(coach);
        return ResponseEntity.ok(coachResource);
    }
}
