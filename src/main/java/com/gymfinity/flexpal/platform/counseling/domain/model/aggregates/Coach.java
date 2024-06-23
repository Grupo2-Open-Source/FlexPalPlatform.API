package com.gymfinity.flexpal.platform.counseling.domain.model.aggregates;

import com.gymfinity.flexpal.platform.counseling.domain.model.valueobjects.ProfileId;
import com.gymfinity.flexpal.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Coach extends AuditableAbstractAggregateRoot<Coach> {

    private String specialization;

    @Embedded
    private ProfileId profileId;

    @OneToMany(mappedBy = "coach")
    private List<Member> members; // lista de miembros (opcional)

    public Coach() {
        this.specialization = "";
    }

    public Coach(ProfileId profileId, String specialization) {
        this();
        this.profileId = profileId;
        this.specialization = specialization;
    }

    public Coach(Long profileId, String specialization) {
        this();
        this.profileId = new ProfileId(profileId);
        this.specialization = specialization;
    }

    public Coach updateInformation(String name, String email, String specialization) {
        this.specialization = specialization;
        return this;
    }

}