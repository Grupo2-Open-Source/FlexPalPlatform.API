package com.gymfinity.flexpal.platform.professionalsmanagement.domain.services;

import com.gymfinity.flexpal.platform.professionalsmanagement.domain.model.aggregates.CoachProfessional;
import com.gymfinity.flexpal.platform.professionalsmanagement.domain.model.queries.GetAllCoachesProfessionalsQuery;
import com.gymfinity.flexpal.platform.professionalsmanagement.domain.model.queries.GetCoachProfessionalByIdQuery;

import java.util.List;
import java.util.Optional;

public interface CoachProfessionalQueryService {
    Optional<CoachProfessional> handle(GetCoachProfessionalByIdQuery query);
    List<CoachProfessional> handle(GetAllCoachesProfessionalsQuery query);
}
