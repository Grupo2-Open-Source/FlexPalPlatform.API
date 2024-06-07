package com.gymfinity.flexpal.platform.counseling.domain.model.aggregates;

import com.gymfinity.flexpal.platform.counseling.domain.model.commands.CreateMemberCommand;
import com.gymfinity.flexpal.platform.counseling.domain.model.valueobjects.MemberId;
import com.gymfinity.flexpal.platform.counseling.domain.model.valueobjects.ProfileId;
import com.gymfinity.flexpal.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Getter;
import org.apache.logging.log4j.util.Strings;

@Entity
public class Member extends AuditableAbstractAggregateRoot<Member> {

    @Embedded
    private ProfileId profileId;

    @Embedded
    @Column(name = "member_id")
    private MemberId memberId;

    @Getter
    private String objective;
    @Getter
    private String levelOfExperience;

    public Member(){
        this.profileId = new ProfileId();
        this.memberId = new MemberId();
        this.objective = Strings.EMPTY;
        this.levelOfExperience = Strings.EMPTY;
    }

    public Member(Long profileId) {
        this.profileId = new ProfileId(profileId);
    }

    public Member(CreateMemberCommand command){
        this();
        this.objective = command.objective();
        this.levelOfExperience = command.levelOfExperience();
    }


    public Member UpdateInformation(String objective, String levelOfExperience){
        this.objective = objective;
        this.levelOfExperience = levelOfExperience;
        return this;
    }

    public String getMemberId() { return this.memberId.memberId(); }
}