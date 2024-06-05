package com.gymfinity.flexpal.platform.subscriptions.interfaces.rest.transform;

import com.gymfinity.flexpal.platform.subscriptions.domain.model.aggregates.Subscription;
import com.gymfinity.flexpal.platform.subscriptions.interfaces.rest.resources.SubscriptionResource;

public class SubscriptionResourceFromEntityAssembler {

    public static SubscriptionResource toResourceFromEntity(Subscription entity) {
        return new SubscriptionResource(entity.getId(), entity.getPrice(), entity.getServices());
    }
}
