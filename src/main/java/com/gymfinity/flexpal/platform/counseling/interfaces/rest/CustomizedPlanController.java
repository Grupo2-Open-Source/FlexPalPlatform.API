package com.gymfinity.flexpal.platform.counseling.interfaces.rest;

import com.gymfinity.flexpal.platform.counseling.domain.model.queries.GetAllCustomizedPlansQuery;
import com.gymfinity.flexpal.platform.counseling.domain.model.queries.GetCustomizedPlanByIdQuery;
import com.gymfinity.flexpal.platform.counseling.domain.services.commandservices.CustomizedPlanCommandService;
import com.gymfinity.flexpal.platform.counseling.domain.services.queryservices.CustomizedPlanQueryService;
import com.gymfinity.flexpal.platform.counseling.interfaces.rest.resources.CreateCustomizedPlanResource;
import com.gymfinity.flexpal.platform.counseling.interfaces.rest.resources.CustomizedPlanResource;
import com.gymfinity.flexpal.platform.counseling.interfaces.rest.transform.CreateCustomizedPlanCommandFromResourceAssembler;
import com.gymfinity.flexpal.platform.counseling.interfaces.rest.transform.CustomizedPlanResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/customized-plans")
@Tag(name = "Customized Plans", description = "Customized Plan Management Endpoints")
public class CustomizedPlanController {

    private final CustomizedPlanCommandService customizedPlanCommandService;
    private final CustomizedPlanQueryService customizedPlanQueryService;

    public CustomizedPlanController(CustomizedPlanCommandService customizedPlanCommandService, CustomizedPlanQueryService customizedPlanQueryService) {
        this.customizedPlanCommandService = customizedPlanCommandService;
        this.customizedPlanQueryService = customizedPlanQueryService;
    }

    @PostMapping
    public ResponseEntity<CustomizedPlanResource> createCustomizedPlan(@RequestBody CreateCustomizedPlanResource resource) {

        var createCustomizedPlanCommand = CreateCustomizedPlanCommandFromResourceAssembler.toCommandFromResource(resource);
        var customizedPlanId = customizedPlanCommandService.handle(createCustomizedPlanCommand);
        if (customizedPlanId.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var getCustomizedPlanByIdQuery = new GetCustomizedPlanByIdQuery(customizedPlanId.get().getId());
        var customizedPlan = customizedPlanQueryService.handle(getCustomizedPlanByIdQuery);
        if (customizedPlan.isPresent()) {
            var customizedPlanResource = CustomizedPlanResourceFromEntityAssembler.toResourceFromEntity(customizedPlan.get());
            return ResponseEntity.ok(customizedPlanResource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "/{customizedPlanId}")
    public ResponseEntity<CustomizedPlanResource> getCustomizedPlanById(@PathVariable Long customizedPlanId) {
        var getCustomizedPlanByIdQuery = new GetCustomizedPlanByIdQuery(customizedPlanId);
        var customizedPlan = customizedPlanQueryService.handle(getCustomizedPlanByIdQuery);
        if (customizedPlan.isPresent()) {
            var customizedPlanResource = CustomizedPlanResourceFromEntityAssembler.toResourceFromEntity(customizedPlan.get());
            return ResponseEntity.ok(customizedPlanResource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<CustomizedPlanResource>> getAllCustomizedPlans() {
        var getAllCustomizedPlansQuery = new GetAllCustomizedPlansQuery();
        var customizedPlans = customizedPlanQueryService.handle(getAllCustomizedPlansQuery);
        var customizedPlanResources = customizedPlans.stream().map(CustomizedPlanResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(customizedPlanResources);
    }
}
