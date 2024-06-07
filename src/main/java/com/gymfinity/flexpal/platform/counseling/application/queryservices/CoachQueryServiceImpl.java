package com.gymfinity.flexpal.platform.counseling.application.queryservices;

import com.gymfinity.flexpal.platform.counseling.domain.model.aggregates.Coach;
import com.gymfinity.flexpal.platform.counseling.domain.model.queries.GetAllCoachesQuery;
import com.gymfinity.flexpal.platform.counseling.domain.model.queries.GetCoachByIdQuery;
import com.gymfinity.flexpal.platform.counseling.domain.model.queries.GetCoachesByLengthOfServiceQuery;
import com.gymfinity.flexpal.platform.counseling.domain.model.queries.GetCoachesBySpecialtyQuery;
import com.gymfinity.flexpal.platform.counseling.domain.services.CoachQueryService;
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
    public Optional<Coach> handle(GetCoachByIdQuery query) {
        return coachRepository.findByCoachId(query.Id());
    }

    @Override
    public List<Coach> handle(GetCoachesBySpecialtyQuery query) {
        return coachRepository.findBySpecialty(query.specialty());
    }

    @Override
    public List<Coach> handle(GetCoachesByLengthOfServiceQuery query) {
        return coachRepository.findByLengthOfService(query.lengthOfService());
    }

    @Override
    public List<Coach> handle(GetAllCoachesQuery query) {
        return coachRepository.findAllCoaches();
    }


}
