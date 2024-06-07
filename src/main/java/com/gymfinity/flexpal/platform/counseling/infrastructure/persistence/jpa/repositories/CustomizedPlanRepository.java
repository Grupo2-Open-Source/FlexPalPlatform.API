package com.gymfinity.flexpal.platform.counseling.infrastructure.persistence.jpa.repositories;

import com.gymfinity.flexpal.platform.counseling.domain.model.aggregates.CustomizedPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomizedPlanRepository extends JpaRepository<CustomizedPlan, Long> {
    Optional<CustomizedPlan> findByPlanId(Long Id);

    List<CustomizedPlan> findAllPlans();
}
