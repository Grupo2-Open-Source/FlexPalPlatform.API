package com.gymfinity.flexpal.platform.counseling.domain.services;

import com.gymfinity.flexpal.platform.counseling.domain.model.aggregates.Coach;
import com.gymfinity.flexpal.platform.counseling.domain.model.queries.GetAllCoachesQuery;
import com.gymfinity.flexpal.platform.counseling.domain.model.queries.GetCoachByIdQuery;
import com.gymfinity.flexpal.platform.counseling.domain.model.queries.GetCoachesByLengthOfServiceQuery;
import com.gymfinity.flexpal.platform.counseling.domain.model.queries.GetCoachesBySpecialtyQuery;

import java.util.List;
import java.util.Optional;

public interface CoachQueryService {
    Optional<Coach> handle(GetCoachByIdQuery query);

    List<Coach> handle(GetCoachesBySpecialtyQuery query);

    List<Coach> handle(GetCoachesByLengthOfServiceQuery query);

    List<Coach> handle(GetAllCoachesQuery query);
}
