package com.gymfinity.flexpal.platform.subscriptions.interfaces.acl;

import com.gymfinity.flexpal.platform.subscriptions.domain.model.commands.CreateSubscriptionCommand;
import com.gymfinity.flexpal.platform.subscriptions.domain.services.SubscriptionCommandService;
import com.gymfinity.flexpal.platform.subscriptions.domain.services.SubscriptionQueryService;
import com.gymfinity.flexpal.platform.subscriptions.interfaces.rest.transform.SubscriptionResourceFromEntityAssembler;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionsContextFacade {

    private final SubscriptionCommandService subscriptionCommandService;
    private final SubscriptionQueryService subscriptionQueryService;

    public SubscriptionsContextFacade(SubscriptionCommandService subscriptionCommandService, SubscriptionQueryService subscriptionQueryService) {
        this.subscriptionCommandService = subscriptionCommandService;
        this.subscriptionQueryService = subscriptionQueryService;
    }

    public Long createSubscription(float price, String services) {
        var createSubscriptionCommand = new CreateSubscriptionCommand(price, services);
        var subscription = subscriptionCommandService.handle(createSubscriptionCommand);
        if (subscription.isEmpty()) return 0L;
        return subscription.get().getId();
    }
}

