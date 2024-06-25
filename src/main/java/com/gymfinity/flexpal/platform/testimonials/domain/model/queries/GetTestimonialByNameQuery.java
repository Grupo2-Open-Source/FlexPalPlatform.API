package com.gymfinity.flexpal.platform.testimonials.domain.model.queries;

import com.gymfinity.flexpal.platform.testimonials.domain.model.valueobjects.PersonName;

public record GetTestimonialByNameQuery(String firstName, String lastName) {
}
