package com.gymfinity.flexpal.platform.counseling.domain.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record CustomizedPlanId(Long customizedPlanId) {
public CustomizedPlanId{
        if (customizedPlanId == null) {
            throw new IllegalArgumentException("CustomizedPlanId cannot be null");
        }
        if (customizedPlanId < 0) {
            throw new IllegalArgumentException("CustomizedPlanId cannot be negative");
        }
    }
    public CustomizedPlanId() {
        this(0L);
    }
}
