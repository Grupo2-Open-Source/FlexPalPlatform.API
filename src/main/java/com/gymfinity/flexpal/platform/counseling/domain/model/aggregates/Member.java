package com.gymfinity.flexpal.platform.counseling.domain.model.aggregates;

import com.gymfinity.flexpal.platform.counseling.domain.model.valueobjects.ProfileId;
import com.gymfinity.flexpal.platform.counseling.domain.model.valueobjects.SubscriptionId;
import com.gymfinity.flexpal.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Member extends AuditableAbstractAggregateRoot<Member> {

    @Embedded
    private ProfileId profileId;

    @ManyToOne
    @JoinColumn(name = "customized_plan_id")
    private CustomizedPlan customizedPlan;

    @ManyToOne
    @JoinColumn(name = "coach_id")
    private Coach coachId;

    @Embedded
    private SubscriptionId subscriptionId;

    public Member() {
        this.customizedPlan = null;
        this.coachId = null;
        this.subscriptionId = null;
    }

    public Member(ProfileId profileId) {
        this();
        this.profileId = profileId;
    }

    public Member(Long profileId) {
        this();
        this.profileId = new ProfileId(profileId);
    }

    public Member updateInformation(String name, String email, CustomizedPlan customizedPlan, Coach coach, SubscriptionId subscriptionId) {
        this.customizedPlan = customizedPlan;
        this.coachId = coach;
        this.subscriptionId = subscriptionId;
        return this;
    }
}