package com.gymfinity.flexpal.platform.testimonials.application.internal.commandservices;

import com.gymfinity.flexpal.platform.testimonials.application.internal.outboundservices.acl.ExternalProfileService;
import com.gymfinity.flexpal.platform.testimonials.domain.model.aggregates.Testimonial;
import com.gymfinity.flexpal.platform.testimonials.domain.model.commands.CreateTestimonialCommand;
import com.gymfinity.flexpal.platform.testimonials.domain.services.commandservices.TestimonialCommandService;
import com.gymfinity.flexpal.platform.testimonials.infrastructure.persistence.jpa.respositories.TestimonialRepository;

import java.util.Optional;

public class TestimonialCommandServiceImpl implements TestimonialCommandService {
    private final TestimonialRepository testimonialRepository;
    private final ExternalProfileService externalProfileService;

    public TestimonialCommandServiceImpl(TestimonialRepository testimonialRepository, ExternalProfileService externalProfileService) {
        this.testimonialRepository = testimonialRepository;
        this.externalProfileService = externalProfileService;
    }

    @Override
    public Optional<Testimonial> handle(CreateTestimonialCommand command) {

        var profileId = externalProfileService.fetchProfileIdByEmail(command.email());

        if (profileId.isEmpty()) {
            profileId = externalProfileService.createProfile(command.firstName(), command.lastName(), command.email(), command.image());
        } else {
            testimonialRepository.findByProfileId(profileId.get().profileId());
        }

        if (profileId.isEmpty()) throw new IllegalArgumentException("Unable to create profile");

        var testimonial = new Testimonial(profileId.get().profileId(), command.testimonial());
        testimonialRepository.save(testimonial);
        return Optional.of(testimonial);
    }
}
