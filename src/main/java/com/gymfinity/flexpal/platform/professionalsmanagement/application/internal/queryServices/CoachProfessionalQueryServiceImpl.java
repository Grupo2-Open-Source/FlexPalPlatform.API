package com.gymfinity.flexpal.platform.professionalsmanagement.application.internal.queryServices;

import com.gymfinity.flexpal.platform.professionalsmanagement.domain.model.aggregates.CoachProfessional;
import com.gymfinity.flexpal.platform.professionalsmanagement.domain.model.queries.GetAllCoachesProfessionalsQuery;
import com.gymfinity.flexpal.platform.professionalsmanagement.domain.model.queries.GetCoachProfessionalByIdQuery;
import com.gymfinity.flexpal.platform.professionalsmanagement.domain.services.CoachProfessionalQueryService;
import com.gymfinity.flexpal.platform.professionalsmanagement.infrastructure.persistence.jpa.repositories.CoachProfessionalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoachProfessionalQueryServiceImpl implements CoachProfessionalQueryService {

    private final CoachProfessionalRepository coachProfessionalRepository;

    public CoachProfessionalQueryServiceImpl(CoachProfessionalRepository coachProfessionalRepository) {
        this.coachProfessionalRepository = coachProfessionalRepository;
    }

    @Override
    public Optional<CoachProfessional> handle(GetCoachProfessionalByIdQuery query) {
        return coachProfessionalRepository.findById(query.coachId());
    }

    @Override
    public List<CoachProfessional> handle(GetAllCoachesProfessionalsQuery query) {
        return coachProfessionalRepository.findAll();
    }
}
