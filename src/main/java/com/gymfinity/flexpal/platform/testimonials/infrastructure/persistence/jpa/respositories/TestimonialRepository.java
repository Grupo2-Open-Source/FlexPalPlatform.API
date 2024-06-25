package com.gymfinity.flexpal.platform.testimonials.infrastructure.persistence.jpa.respositories;

import com.gymfinity.flexpal.platform.counseling.domain.model.aggregates.Coach;
import com.gymfinity.flexpal.platform.profiles.domain.model.valueobjects.PersonName;
import com.gymfinity.flexpal.platform.testimonials.domain.model.aggregates.Testimonial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TestimonialRepository extends JpaRepository<Testimonial, Long> {
    Optional<Testimonial> findById(Long id);
    Optional<Testimonial> findByProfileId(Long profileId);

    Optional<Testimonial> findByName(String firstName, String lastName);
}
