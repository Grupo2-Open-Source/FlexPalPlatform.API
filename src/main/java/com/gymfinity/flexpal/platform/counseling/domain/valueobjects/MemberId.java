package com.gymfinity.flexpal.platform.counseling.domain.valueobjects;

import java.util.UUID;

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