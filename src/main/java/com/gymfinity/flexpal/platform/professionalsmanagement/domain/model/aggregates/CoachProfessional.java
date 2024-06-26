package com.gymfinity.flexpal.platform.professionalsmanagement.domain.model.aggregates;

import com.gymfinity.flexpal.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
@Entity
public class CoachProfessional extends AuditableAbstractAggregateRoot<CoachProfessional> {

    @NotBlank
    @Size(max = 50)
    private String firstName;

    @NotBlank
    @Size(max = 50)
    private String lastName;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(max = 100)
    private String phrase;

    public CoachProfessional(String firstName, String lastName, String phrase, String email) {
        this.phrase = phrase;
        this.email = email;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public CoachProfessional() {}
}
