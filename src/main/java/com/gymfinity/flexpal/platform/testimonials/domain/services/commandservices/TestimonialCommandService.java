package com.gymfinity.flexpal.platform.testimonials.domain.services.commandservices;

import com.gymfinity.flexpal.platform.testimonials.domain.model.aggregates.Testimonial;
import com.gymfinity.flexpal.platform.testimonials.domain.model.commands.CreateTestimonialCommand;

import java.util.Optional;

public interface TestimonialCommandService {
    Optional<Testimonial> handle(CreateTestimonialCommand command);
}
