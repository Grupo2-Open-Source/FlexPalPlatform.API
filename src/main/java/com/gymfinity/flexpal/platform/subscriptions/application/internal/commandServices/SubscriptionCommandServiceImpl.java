package com.gymfinity.flexpal.platform.subscriptions.application.internal.commandServices;

import com.gymfinity.flexpal.platform.subscriptions.domain.model.aggregates.Subscription;
import com.gymfinity.flexpal.platform.subscriptions.domain.model.commands.CreateSubscriptionCommand;
import com.gymfinity.flexpal.platform.subscriptions.domain.services.SubscriptionCommandService;
import com.gymfinity.flexpal.platform.subscriptions.infrastructure.persistence.jpa.repositories.SubscriptionRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubscriptionCommandServiceImpl implements SubscriptionCommandService{
    private final SubscriptionRepository subscriptionRepository;

    public SubscriptionCommandServiceImpl(SubscriptionRepository subscriptionRepository){
        this.subscriptionRepository = subscriptionRepository;
    }

    @Override
    public Optional<Subscription> handle(CreateSubscriptionCommand command) {
        float price = command.price();
        String services = command.services();

        var subscription = new Subscription(price, services);
        var createdSubscription = subscriptionRepository.save(subscription);
        return Optional.of(createdSubscription);
    }

}

