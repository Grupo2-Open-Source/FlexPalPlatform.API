package com.gymfinity.flexpal.platform.counseling.infrastructure.persistence.jpa.repositories;

import com.gymfinity.flexpal.platform.counseling.domain.model.aggregates.Coach;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CoachRepository extends JpaRepository<Coach, Long> {
    Optional<Coach> findByCoachId(Long Id);

    List<Coach> findByLengthOfService(int lengthOfService);

    List<Coach> findBySpecialty(String specialty);

    List<Coach> findAllCoaches();
}