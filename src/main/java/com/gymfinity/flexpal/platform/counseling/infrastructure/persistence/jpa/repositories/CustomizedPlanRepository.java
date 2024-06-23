package com.gymfinity.flexpal.platform.counseling.infrastructure.persistence.jpa.repositories;

import com.gymfinity.flexpal.platform.counseling.domain.model.aggregates.CustomizedPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomizedPlanRepository extends JpaRepository<CustomizedPlan, Long>{
    Optional<CustomizedPlan> findByMemberId(Long memberId);
    Optional<CustomizedPlan> findByName(String name);
}
