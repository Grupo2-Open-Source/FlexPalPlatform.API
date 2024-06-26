package com.gymfinity.flexpal.platform.professionalsmanagement.interfaces;

import com.gymfinity.flexpal.platform.professionalsmanagement.domain.model.aggregates.CoachProfessional;
import com.gymfinity.flexpal.platform.professionalsmanagement.domain.model.queries.GetAllCoachesProfessionalsQuery;
import com.gymfinity.flexpal.platform.professionalsmanagement.domain.model.queries.GetCoachProfessionalByIdQuery;
import com.gymfinity.flexpal.platform.professionalsmanagement.domain.services.CoachProfessionalCommandService;
import com.gymfinity.flexpal.platform.professionalsmanagement.domain.services.CoachProfessionalQueryService;
import com.gymfinity.flexpal.platform.professionalsmanagement.interfaces.resources.CoachProfessionalResource;
import com.gymfinity.flexpal.platform.professionalsmanagement.interfaces.resources.CreateCoachProfessionalResource;
import com.gymfinity.flexpal.platform.professionalsmanagement.interfaces.transform.CoachProfessionalResourceFromEntityAssembler;
import com.gymfinity.flexpal.platform.professionalsmanagement.interfaces.transform.CreateCoachProfessionalCommandFromResourceAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/v1/coach-professional")
public class CoachProfessionalController {
    private final CoachProfessionalCommandService coachProfessionalCommandService;
    private final CoachProfessionalQueryService coachProfessionalQueryService;

    public CoachProfessionalController(CoachProfessionalCommandService coachProfessionalCommandService,
                                       CoachProfessionalQueryService coachProfessionalQueryService) {
        this.coachProfessionalCommandService = coachProfessionalCommandService;
        this.coachProfessionalQueryService = coachProfessionalQueryService;
    }

    @PostMapping
    public ResponseEntity<CoachProfessionalResource> createCoachProfessional(
            @RequestBody CreateCoachProfessionalResource resource) {
        Optional<CoachProfessional> coachProfessionalResource = coachProfessionalCommandService
                .handle(CreateCoachProfessionalCommandFromResourceAssembler.toCommandFromResource(resource));

        return coachProfessionalResource.flatMap(coachProfessional ->
                Optional.of(new ResponseEntity<>(
                        CoachProfessionalResourceFromEntityAssembler.toResourceFromEntity(coachProfessional), CREATED)))
                .orElseGet(()->ResponseEntity.badRequest().build());

    }

    @GetMapping
    private ResponseEntity<List<CoachProfessionalResource>> getAllCoachProfessional() {
        var getAllCoachProfessionals = new GetAllCoachesProfessionalsQuery();
        var coachProfessional = coachProfessionalQueryService.handle(getAllCoachProfessionals);

        var coachProfessionalsResources = coachProfessional.stream().map(
                CoachProfessionalResourceFromEntityAssembler:: toResourceFromEntity).toList();

        return ResponseEntity.ok(coachProfessionalsResources);
    }

    @GetMapping(value= "/{coachId}")
    public ResponseEntity<CoachProfessionalResource> getCoachProfessionalById(@PathVariable Long coachId) {
        var getCoachProfessionalByIdQuery = new GetCoachProfessionalByIdQuery(coachId);
        var coachProfessional = coachProfessionalQueryService.handle(getCoachProfessionalByIdQuery);
        if (coachProfessional.isEmpty()) return ResponseEntity.notFound().build();
        var coachProfessionalResource = CoachProfessionalResourceFromEntityAssembler
                .toResourceFromEntity(coachProfessional.get());
        return ResponseEntity.ok(coachProfessionalResource);
    }
}
