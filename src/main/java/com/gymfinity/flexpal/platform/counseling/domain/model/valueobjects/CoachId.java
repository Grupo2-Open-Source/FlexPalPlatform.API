package com.gymfinity.flexpal.platform.counseling.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public record CoachId(String coachId) {

    public CoachId() {
        this(UUID.randomUUID().toString());
    }

    public CoachId {
        if (coachId == null) {
            throw new IllegalArgumentException("CoachId cannot be null");
        }
    }
}