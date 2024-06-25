package com.gymfinity.flexpal.platform.profiles.domain.model.aggregates;

import com.gymfinity.flexpal.platform.profiles.domain.model.commands.CreateProfileCommand;
import com.gymfinity.flexpal.platform.profiles.domain.model.valueobjects.EmailAddress;
import com.gymfinity.flexpal.platform.profiles.domain.model.valueobjects.PersonName;
import com.gymfinity.flexpal.platform.profiles.domain.model.valueobjects.UrlImage;
import com.gymfinity.flexpal.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Profile extends AuditableAbstractAggregateRoot<Profile> {

    @Embedded
    private PersonName name;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "address", column = @Column(name = "email_address"))})
    private EmailAddress email;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "url", column = @Column(name = "url_image"))})
    private UrlImage image;

    public Profile(String firstName, String lastName, String email, String image) {
        this.name = new PersonName(firstName, lastName);
        this.email = new EmailAddress(email);
        this.image = new UrlImage(image);
    }

    public Profile() { }

    public Profile(CreateProfileCommand command) {
        this.name = new PersonName(command.firstName(), command.lastName());
        this.email = new EmailAddress(command.email());
        this.image = new UrlImage(command.image());
    }

    public void updateName(String firstName, String lastName) {
        this.name = new PersonName(firstName, lastName);
    }

    public void updateEmail(String email) {
        this.email = new EmailAddress(email);
    }

    public void updateImage(String image) {
        this.image = new UrlImage(image);
    }

    public String getFirstName(){ return name.firstName(); }
    public String getLastName(){ return name.lastName(); }

    public String getFullName() {
        return name.getFullName();
    }

    public String getEmailAddress() {
        return email.address();
    }

    public String getUrlImage() {
        return image.url_image();
    }
}


















