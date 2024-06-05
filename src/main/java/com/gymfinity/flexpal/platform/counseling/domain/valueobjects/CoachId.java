package com.gymfinity.flexpal.platform.counseling.domain.valueobjects;

import java.util.UUID;

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