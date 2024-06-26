package com.gymfinity.flexpal.platform.testimonials.domain.services.queryservices;

import com.gymfinity.flexpal.platform.counseling.domain.model.queries.GetAllCoachesQuery;
import com.gymfinity.flexpal.platform.testimonials.domain.model.aggregates.Testimonial;
import com.gymfinity.flexpal.platform.testimonials.domain.model.queries.GetAllTestimonialsQuery;
import com.gymfinity.flexpal.platform.testimonials.domain.model.queries.GetTestimonialByIdQuery;
import com.gymfinity.flexpal.platform.testimonials.domain.model.queries.GetTestimonialByNameQuery;

import java.util.List;
import java.util.Optional;

public interface TestimonialQueryService {
    List<Testimonial> handle(GetAllTestimonialsQuery query);
    Optional<Testimonial> handle(GetTestimonialByIdQuery query);
    //Optional<Testimonial> handle(GetTestimonialByNameQuery query);

}
