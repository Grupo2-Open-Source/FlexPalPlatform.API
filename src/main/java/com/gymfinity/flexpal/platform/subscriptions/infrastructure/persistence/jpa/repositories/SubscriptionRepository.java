package com.gymfinity.flexpal.platform.subscriptions.infrastructure.persistence.jpa.repositories;

import com.gymfinity.flexpal.platform.subscriptions.domain.model.aggregates.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

    List<Subscription> findAll();

}