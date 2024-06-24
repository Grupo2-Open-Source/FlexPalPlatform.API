package com.gymfinity.flexpal.platform.subscriptions.interfaces.rest;

import com.gymfinity.flexpal.platform.subscriptions.domain.model.aggregates.Subscription;
import com.gymfinity.flexpal.platform.subscriptions.domain.model.queries.GetAllSubscriptionsQuery;
import com.gymfinity.flexpal.platform.subscriptions.domain.services.SubscriptionCommandService;
import com.gymfinity.flexpal.platform.subscriptions.domain.services.SubscriptionQueryService;
import com.gymfinity.flexpal.platform.subscriptions.interfaces.rest.resources.CreateSubscriptionResource;
import com.gymfinity.flexpal.platform.subscriptions.interfaces.rest.resources.SubscriptionResource;
import com.gymfinity.flexpal.platform.subscriptions.interfaces.rest.transform.CreateSubscriptionCommandFromResourceAssembler;
import com.gymfinity.flexpal.platform.subscriptions.interfaces.rest.transform.SubscriptionResourceFromEntityAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("subscription")
public class SubscriptionController {
    private final SubscriptionCommandService subscriptionCommandService;
    private final SubscriptionQueryService subscriptionQueryService;

    public SubscriptionController(SubscriptionCommandService subscriptionCommandService, SubscriptionQueryService subscriptionQueryService){
        this.subscriptionCommandService = subscriptionCommandService;
        this.subscriptionQueryService = subscriptionQueryService;
    }

    @PostMapping
    public ResponseEntity<SubscriptionResource> createProfile(@RequestBody CreateSubscriptionResource resource) {
        Optional<Subscription> subscriptionResource = subscriptionCommandService
                .handle(CreateSubscriptionCommandFromResourceAssembler.toCommandFromResource(resource));

        return subscriptionResource.flatMap(subscription ->
                        Optional.of(new ResponseEntity<>(
                                SubscriptionResourceFromEntityAssembler.toResourceFromEntity(subscription), CREATED)))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping
    private ResponseEntity<List<SubscriptionResource>> getAllSubscriptions() {
        var getAllSubscriptions = new GetAllSubscriptionsQuery();
        var subscriptions = subscriptionQueryService.handle(getAllSubscriptions);

        var profilesResources = subscriptions.stream().map(
                SubscriptionResourceFromEntityAssembler:: toResourceFromEntity).toList();

        return ResponseEntity.ok(profilesResources);
    }
}