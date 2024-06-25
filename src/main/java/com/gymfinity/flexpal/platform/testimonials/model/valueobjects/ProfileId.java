package com.gymfinity.flexpal.platform.testimonials.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record ProfileId(Long profileId) {
    public ProfileId {
        if (profileId < 0) {
            throw new IllegalArgumentException("Profile profileId cannot be negative");
        }
    }

    public ProfileId() {
        this(0L);
    }
}