package com.gymfinity.flexpal.platform.counseling.interfaces.rest.controllers;

import com.gymfinity.flexpal.platform.counseling.domain.model.aggregates.Coach;
import com.gymfinity.flexpal.platform.counseling.domain.services.CoachCommandService;
import com.gymfinity.flexpal.platform.counseling.domain.services.CoachQueryService;
import com.gymfinity.flexpal.platform.counseling.interfaces.rest.resource.CreateCoachResource;
import com.gymfinity.flexpal.platform.counseling.interfaces.rest.transform.CreateCoachCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("api/v1/coaches")
@Tag(name= "Coaches", description = "Operations related to coaches")
public class CoachController {
    private final CoachCommandService coachCommandService;
    private final CoachQueryService coachQueryService;

    public CoachController(CoachCommandService coachCommandService, CoachQueryService coachQueryService){
        this.coachCommandService = coachCommandService;
        this.coachQueryService = coachQueryService;
    }

//    @Operation(summary = "Create a new coach")
//    @PostMapping
//    public ResponseEntity<CoachReso> createCoach(@RequestBody CreateCoachResource resource) {
//        Optional<Coach> coachResource = coachCommandService
//                .handle(CreateCoachCommandFromResourceAssembler.toCommandFromSource(resource));
//
//        DeveloperSourceFromEntityAssembler CoachSourceFromEntityAssembler;
//        return coachResource.map(coach -> new ResponseEntity<>(
//                CoachSourceFromEntityAssembler.toResourceFromSource(coach), CREATED))
//                .orElseGet(()-> ResponseEntity.badRequest().build());
//    }
}

//package com.gymfinity.flexpal.platform.home.interfaces.rest.controllers;
//
//import com.acme.fromzeroapi.home.domain.model.aggregates.Developer;
//import com.acme.fromzeroapi.home.domain.model.queries.GetAllDevelopersQuery;
//import com.acme.fromzeroapi.home.domain.model.queries.GetDeveloperByCountryQuery;
//import com.acme.fromzeroapi.home.domain.model.queries.GetDeveloperByIdQuery;
//import com.acme.fromzeroapi.home.domain.model.queries.GetDeveloperBySpecialityQuery;
//import com.acme.fromzeroapi.home.domain.services.DeveloperCommandService;
//import com.acme.fromzeroapi.home.domain.services.DeveloperQueryService;
//import com.acme.fromzeroapi.home.interfaces.rest.resources.CreateDeveloperResource;
//import com.acme.fromzeroapi.home.interfaces.rest.resources.DeveloperResource;
//import com.acme.fromzeroapi.home.interfaces.rest.transform.CreateDeveloperCommandFromResourceAssembler;
//import com.acme.fromzeroapi.home.interfaces.rest.transform.DeveloperSourceFromEntityAssembler;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.springframework.http.HttpStatus.CREATED;
//
//@RestController
//@RequestMapping("api/v1/developers")
//@Tag(name= "Developers", description = "Operations related to developers")
//public class DeveloperController {
//
//    private final DeveloperCommandService developerCommandService;
//    private final DeveloperQueryService developerQueryService;
//
//    public DeveloperController(DeveloperCommandService developerCommandService, DeveloperQueryService developerQueryService){
//        this.developerCommandService = developerCommandService;
//        this.developerQueryService = developerQueryService;
//    }
//
//    @Operation(summary = "Create a new developers")
//    @PostMapping
//    public ResponseEntity<DeveloperResource> createDeveloper(@RequestBody CreateDeveloperResource resource) {
//        Optional<Developer> desarrolladorResource = developerCommandService
//                .handle(CreateDeveloperCommandFromResourceAssembler.toCommandFromSource(resource));
//
//        return desarrolladorResource.map(desarrollador -> new ResponseEntity<>(
//                DeveloperSourceFromEntityAssembler.toResourceFromSource(desarrollador), CREATED))
//                .orElseGet(()->ResponseEntity.badRequest().build());
//    }
//
//    @Operation(summary = "Get all developers")
//    @GetMapping
//    private ResponseEntity<List<DeveloperResource>> getAllDesarrolladores(){
//        var getAllDesarrolladores = new GetAllDevelopersQuery();
//        var desarrolladores = developerQueryService.handle(getAllDesarrolladores);
//
//        var desarrolladoresResources = desarrolladores.stream().map(
//                DeveloperSourceFromEntityAssembler::toResourceFromSource).toList();
//
//        return ResponseEntity.ok(desarrolladoresResources);
//    }
//
//    @Operation(summary = "Get a developer by id")
//    @GetMapping("/{developerId}")
//    public ResponseEntity<DeveloperResource> getDeveloperById(@PathVariable Long developerId) {
//        var getDeveloperByIdQuery = new GetDeveloperByIdQuery(developerId);
//        var developer = developerQueryService.handle(getDeveloperByIdQuery);
//        if (developer.isEmpty()) return ResponseEntity.badRequest().build();
//        var developerResource = DeveloperSourceFromEntityAssembler.toResourceFromSource(developer.get());
//        return ResponseEntity.ok(developerResource);
//    }
//
//    @Operation(summary = "Get developer by country")
//    @GetMapping("/country/{country}")
//    public ResponseEntity<List<DeveloperResource>> getDeveloperByCountry(@PathVariable String country){
//        var getDeveloperByCountryQuery = new GetDeveloperByCountryQuery(country);
//        var developer = developerQueryService.handle(getDeveloperByCountryQuery);
//        if(developer.isEmpty()) return ResponseEntity.badRequest().build();
//        var developerResource = developer.stream().map(
//                DeveloperSourceFromEntityAssembler::toResourceFromSource).toList();
//        return ResponseEntity.ok(developerResource);
//    }
//
//    @Operation(summary = "Get developer by speciality")
//    @GetMapping("/speciality/{specialties}")
//    public ResponseEntity<DeveloperResource> getDeveloperBySpeciality(@PathVariable String specialties){
//        var getDeveloperBySpecialityQuery = new GetDeveloperBySpecialityQuery(specialties);
//        var developer = developerQueryService.handle(getDeveloperBySpecialityQuery);
//        if(developer.isEmpty()) return ResponseEntity.badRequest().build();
//        var developerResource = DeveloperSourceFromEntityAssembler.toResourceFromSource(developer.get());
//        return ResponseEntity.ok(developerResource);
//    }
//}