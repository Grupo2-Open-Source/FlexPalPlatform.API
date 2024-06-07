package com.gymfinity.flexpal.platform.counseling.infrastructure.persistence.jpa.repositories;

import com.gymfinity.flexpal.platform.counseling.domain.model.aggregates.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByMemberId(Long Id);

    List<Member> findByObjective(String objective);

    List<Member> findByLevelOfExperience(String levelOfExperience);

    List<Member> findAllMembers();
}
