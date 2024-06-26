package com.gymfinity.flexpal.platform.professionalsmanagement.infrastructure.persistence.jpa.repositories;

import com.gymfinity.flexpal.platform.professionalsmanagement.domain.model.aggregates.CoachProfessional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoachProfessionalRepository extends JpaRepository<CoachProfessional, Long> {
    List<CoachProfessional> findAll();
}
