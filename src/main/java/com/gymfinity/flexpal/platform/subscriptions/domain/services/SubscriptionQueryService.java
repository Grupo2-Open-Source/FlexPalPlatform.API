package com.gymfinity.flexpal.platform.subscriptions.domain.services;

import com.gymfinity.flexpal.platform.subscriptions.domain.model.aggregates.Subscription;
import com.gymfinity.flexpal.platform.subscriptions.domain.model.queries.GetAllSubscriptionsQuery;
import com.gymfinity.flexpal.platform.subscriptions.domain.model.queries.GetSubscriptionByIdQuery;

import java.util.List;
import java.util.Optional;

public interface SubscriptionQueryService {
    Optional<Subscription> handle(GetSubscriptionByIdQuery query);
    List<Subscription> handle(GetAllSubscriptionsQuery query);
}
