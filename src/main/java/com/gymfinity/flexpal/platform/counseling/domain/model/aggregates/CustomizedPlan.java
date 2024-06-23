package com.gymfinity.flexpal.platform.counseling.domain.model.aggregates;

import com.gymfinity.flexpal.platform.counseling.domain.model.commands.CreateCustomizePlanCommand;
import com.gymfinity.flexpal.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class CustomizedPlan extends AuditableAbstractAggregateRoot<CustomizedPlan> {
    private String name;
    private int coachId;
    private int memberId;
    private String goal;
    private String benefits;
    private String plan;

    @OneToMany(mappedBy = "customizedPlan")
    private List<Member> members; // lista de miembros (opcional)

    public CustomizedPlan() {
        this.name = "";
        this.coachId = 0;
        this.memberId = 0;
        this.goal = "";
        this.benefits = "";
        this.plan = "";
    }

    public CustomizedPlan(String name, int coachId, int memberId, String goal, String benefits, String plan) {
        this();
        this.name = name;
        this.coachId = coachId;
        this.memberId = memberId;
        this.goal = goal;
        this.benefits = benefits;
        this.plan = plan;
    }

    public CustomizedPlan(CreateCustomizePlanCommand command) {
        this.name = command.name();
        this.coachId = command.coachId();
        this.memberId = command.memberId();
        this.goal = command.goal();
        this.benefits = command.benefits();
        this.plan = command.plan();
    }

    public CustomizedPlan updateInformation(String name, int coachId, int memberId, String goal, String benefits, String plan) {
        this.name = name;
        this.coachId = coachId;
        this.memberId = memberId;
        this.goal = goal;
        this.benefits = benefits;
        this.plan = plan;
        return this;
    }
}
