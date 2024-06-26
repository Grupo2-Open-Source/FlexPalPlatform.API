package com.gymfinity.flexpal.platform.testimonials.interfaces.rest.transform;

import com.gymfinity.flexpal.platform.testimonials.domain.model.aggregates.Testimonial;
import com.gymfinity.flexpal.platform.testimonials.interfaces.rest.resources.TestimonialResource;

public class TestimonialResourceFromEntityAssembler {
    public static TestimonialResource toResourceFromEntity(Testimonial testimonial) {
        return new TestimonialResource(testimonial.getId(), testimonial.getProfileId().profileId(), testimonial.getTestimonial());
    }
}
