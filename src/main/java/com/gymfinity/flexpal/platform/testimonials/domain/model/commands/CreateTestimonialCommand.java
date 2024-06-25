package com.gymfinity.flexpal.platform.testimonials.domain.model.commands;

public record CreateTestimonialCommand(String firstName, String lastName, String email, String image, String testimonial) {
}
