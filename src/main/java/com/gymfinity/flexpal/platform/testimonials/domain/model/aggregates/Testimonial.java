package com.gymfinity.flexpal.platform.testimonials.domain.model.aggregates;

import com.gymfinity.flexpal.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import com.gymfinity.flexpal.platform.testimonials.domain.model.valueobjects.ProfileId;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Testimonial extends AuditableAbstractAggregateRoot<Testimonial> {

    private String testimonial;

    @Embedded
    private ProfileId profileId;

    public Testimonial() { this.testimonial = ""; }

    public Testimonial(Long profileId, String testimonial) {
        this();
        this.profileId = new ProfileId(profileId);
        this.testimonial = testimonial;
    }
}
