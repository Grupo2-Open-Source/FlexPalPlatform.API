package com.gymfinity.flexpal.platform.subscriptions.application.internal.queryServices;

import com.gymfinity.flexpal.platform.subscriptions.domain.model.aggregates.Subscription;
import com.gymfinity.flexpal.platform.subscriptions.domain.model.commands.CreateSubscriptionCommand;
import com.gymfinity.flexpal.platform.subscriptions.domain.model.queries.GetAllSubscriptionsQuery;
import com.gymfinity.flexpal.platform.subscriptions.domain.model.queries.GetSubscriptionByIdQuery;
import com.gymfinity.flexpal.platform.subscriptions.domain.services.SubscriptionCommandService;
import com.gymfinity.flexpal.platform.subscriptions.domain.services.SubscriptionQueryService;
import com.gymfinity.flexpal.platform.subscriptions.infrastructure.persistence.jpa.repositories.SubscriptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionQueryServiceImpl implements SubscriptionQueryService {
    private final SubscriptionRepository subscriptionRepository;

    public SubscriptionQueryServiceImpl(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    @Override
    public Optional<Subscription> handle(GetSubscriptionByIdQuery query) {
        return Optional.empty();
    }

    @Override
    public List<Subscription> handle(GetAllSubscriptionsQuery query) {
        return subscriptionRepository.findAll();
    }
}

