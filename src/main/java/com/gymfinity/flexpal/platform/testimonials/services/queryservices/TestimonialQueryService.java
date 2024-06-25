package com.gymfinity.flexpal.platform.testimonials.services.queryservices;

import com.gymfinity.flexpal.platform.counseling.domain.model.queries.GetAllCoachesQuery;
import com.gymfinity.flexpal.platform.testimonials.model.aggregates.Testimonial;
import com.gymfinity.flexpal.platform.testimonials.model.queries.GetTestimonialByIdQuery;
import com.gymfinity.flexpal.platform.testimonials.model.queries.GetTestimonialByNameQuery;

import java.util.List;
import java.util.Optional;

public interface TestimonialQueryService {
    List<Testimonial> handle(GetAllCoachesQuery query);
    Optional<Testimonial> handle(GetTestimonialByIdQuery query);
    Optional<Testimonial> handle(GetTestimonialByNameQuery query);
}
