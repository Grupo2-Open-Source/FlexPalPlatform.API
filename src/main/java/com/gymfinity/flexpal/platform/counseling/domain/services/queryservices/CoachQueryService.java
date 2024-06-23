package com.gymfinity.flexpal.platform.counseling.domain.services.queryservices;

import com.gymfinity.flexpal.platform.counseling.domain.model.aggregates.Coach;
import com.gymfinity.flexpal.platform.counseling.domain.model.queries.*;

import java.util.List;
import java.util.Optional;

public interface CoachQueryService {
    List<Coach> handle(GetAllCoachesQuery query);

    Optional<Coach> handle(GetCoachByIdQuery query);

    Optional<Coach> handle(GetCoachBySpecializationQuery query);
}