package com.gymfinity.flexpal.platform.counseling.application.internal.queryservices;

import com.gymfinity.flexpal.platform.counseling.domain.model.aggregates.Coach;
import com.gymfinity.flexpal.platform.counseling.domain.model.queries.*;
import com.gymfinity.flexpal.platform.counseling.domain.services.queryservices.CoachQueryService;
import com.gymfinity.flexpal.platform.counseling.infrastructure.persistence.jpa.repositories.CoachRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoachQueryServiceImpl implements CoachQueryService {

    private final CoachRepository coachRepository;

    public CoachQueryServiceImpl(CoachRepository coachRepository) {
        this.coachRepository = coachRepository;
    }

    @Override
    public List<Coach> handle(GetAllCoachesQuery query) {
        return coachRepository.findAll();
    }

    @Override
    public Optional<Coach> handle(GetCoachByIdQuery query) {
        return coachRepository.findById(query.coachId());
    }

    @Override
    public Optional<Coach> handle(GetCoachBySpecializationQuery query) {
        return coachRepository.findBySpecialization(query.specialization());
    }

    @Override
    public Optional<Coach> handle(GetCoachByNameQuery query) {
        return coachRepository.findByName(query.coachName());
    }

    @Override
    public Optional<Coach> handle(GetCoachByEmailQuery query) {
        return coachRepository.findByEmail(query.coachEmail());
    }
}
