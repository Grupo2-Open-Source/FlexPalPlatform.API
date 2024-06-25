package com.gymfinity.flexpal.platform.testimonials.services.commandservices;

import com.gymfinity.flexpal.platform.testimonials.model.aggregates.Testimonial;
import com.gymfinity.flexpal.platform.testimonials.model.commands.CreateTestimonialCommand;

import java.util.Optional;

public interface TestimonialCommandService {
    Optional<Testimonial> handle(CreateTestimonialCommand command);
}
