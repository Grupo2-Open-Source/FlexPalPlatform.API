package com.gymfinity.flexpal.platform.subscriptions.domain.model.aggregates;

import com.gymfinity.flexpal.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;

@Entity
public class Subscription extends AuditableAbstractAggregateRoot<Subscription> {

    private float price;
    private String services;

    public Subscription(float price, String services) {
        this.price = price;
        this.services = services;
    }

    public Subscription()  {
        this(0, null);
    }


    public float getPrice() {
        return price;
    }

    public String getServices() {
        return services;
    }
}