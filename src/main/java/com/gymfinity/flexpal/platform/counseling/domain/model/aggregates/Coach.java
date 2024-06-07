package com.gymfinity.flexpal.platform.counseling.domain.model.aggregates;

import com.gymfinity.flexpal.platform.counseling.domain.model.commands.CreateCoachCommand;
import com.gymfinity.flexpal.platform.counseling.domain.model.valueobjects.CoachId;
import com.gymfinity.flexpal.platform.counseling.domain.model.valueobjects.ProfileId;
import com.gymfinity.flexpal.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Getter;
import org.apache.logging.log4j.util.Strings;

@Entity
public class Coach extends AuditableAbstractAggregateRoot<Coach> {

    @Embedded
    @Column(name = "coach_id")
    private CoachId coachId;

    @Embedded
    private ProfileId profileId;

    @Getter
    private String specialty;
    @Getter
    private int lengthOfService;

    public Coach(){
        this.profileId = new ProfileId();
        this.coachId = new CoachId();
        this.specialty = Strings.EMPTY;
        this.lengthOfService = 0;
    }

    public Coach(Long profileId) {
        this.profileId = new ProfileId(profileId);
    }

    public Coach(ProfileId profileId, String specialty, int lengthOfService){
        this();
        this.profileId = profileId;
        this.specialty = specialty;
        this.lengthOfService = lengthOfService;
    }

    public Coach(CreateCoachCommand command){
        this();
        this.specialty = command.specialty();
        this.lengthOfService = command.lengthOfService();
    }

    public Coach UpdateInformation(String specialty, int lengthOfService){
        this.specialty = specialty;
        this.lengthOfService = lengthOfService;
        return this;
    }

    public String getCoachId() { return this.coachId.coachId(); }

}