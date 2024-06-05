package com.gymfinity.flexpal.platform.counseling.domain.aggregates;

import com.gymfinity.flexpal.platform.counseling.domain.valueobjects.CoachId;
import com.gymfinity.flexpal.platform.counseling.domain.valueobjects.ProfileId;
import com.gymfinity.flexpal.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Getter;

@Entity
public class Coach extends AuditableAbstractAggregateRoot<Coach> {

    @Embedded
    @Column(name = "coach_id")
    private CoachId coachId;

    @Embedded
    private ProfileId profileId;

    public Coach(){
        this.coachId = new CoachId();
    }
}
