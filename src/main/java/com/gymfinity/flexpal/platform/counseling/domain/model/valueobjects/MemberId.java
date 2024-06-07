package com.gymfinity.flexpal.platform.counseling.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public record MemberId(String memberId) {

    public MemberId() {
        this(UUID.randomUUID().toString());
    }

    public MemberId {
        if (memberId == null) {
            throw new IllegalArgumentException("MemberId cannot be null");
        }
    }
}