package com.gymfinity.flexpal.platform.testimonials.application.internal.queryservices;

import com.gymfinity.flexpal.platform.counseling.domain.model.queries.GetAllCoachesQuery;
import com.gymfinity.flexpal.platform.testimonials.domain.model.aggregates.Testimonial;
import com.gymfinity.flexpal.platform.testimonials.domain.model.queries.GetTestimonialByIdQuery;
import com.gymfinity.flexpal.platform.testimonials.domain.model.queries.GetTestimonialByNameQuery;
import com.gymfinity.flexpal.platform.testimonials.domain.services.queryservices.TestimonialQueryService;
import com.gymfinity.flexpal.platform.testimonials.infrastructure.persistence.jpa.respositories.TestimonialRepository;

import java.util.List;
import java.util.Optional;

public class TestimonialQueryServiceImpl implements TestimonialQueryService {

    private final TestimonialRepository testimonialRepository;

    public TestimonialQueryServiceImpl(TestimonialRepository testimonialRepository) {
        this.testimonialRepository = testimonialRepository;
    }

    @Override
    public List<Testimonial> handle(GetAllCoachesQuery query) {
        return testimonialRepository.findAll();
    }

    @Override
    public Optional<Testimonial> handle(GetTestimonialByIdQuery query) {
        return testimonialRepository.findById(query.testimonialId());
    }

    @Override
    public Optional<Testimonial> handle(GetTestimonialByNameQuery query) {
        return testimonialRepository.findByName(query.firstName(), query.lastName());
    }
}
