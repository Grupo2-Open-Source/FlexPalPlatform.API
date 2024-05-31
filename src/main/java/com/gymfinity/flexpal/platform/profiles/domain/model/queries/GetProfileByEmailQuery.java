package com.gymfinity.flexpal.platform.profiles.domain.model.queries;

import com.gymfinity.flexpal.platform.profiles.domain.model.valueobjects.EmailAddress;

public record GetProfileByEmailQuery(EmailAddress emailAddress) {
}
