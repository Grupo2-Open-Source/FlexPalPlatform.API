package com.gymfinity.flexpal.platform.counseling.infrastructure.persistence.jpa.repositories;

import com.gymfinity.flexpal.platform.counseling.domain.model.aggregates.Member;
import com.gymfinity.flexpal.platform.counseling.domain.model.valueobjects.ProfileId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);
    Optional<Member> findByName(String name);
    Optional<Member> findByCustomizedPlan(Long customizedPlan);
    Optional<Member> findByProfileId(ProfileId profileId);
}
