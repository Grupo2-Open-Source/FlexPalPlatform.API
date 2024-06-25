package com.gymfinity.flexpal.platform.testimonials.interfaces.rest.transform;

import com.gymfinity.flexpal.platform.testimonials.domain.model.commands.CreateTestimonialCommand;
import com.gymfinity.flexpal.platform.testimonials.interfaces.rest.resources.CreateTestimonialResource;

public class CreateTestimonialCommandFromResourceAssembler {
    public static CreateTestimonialCommand toCommandFromResource(CreateTestimonialResource resource) {
        return new CreateTestimonialCommand(resource.firstName(),
                resource.lastName(),
                resource.email(),
                resource.image(),
                resource.testimonial());
    }
}
