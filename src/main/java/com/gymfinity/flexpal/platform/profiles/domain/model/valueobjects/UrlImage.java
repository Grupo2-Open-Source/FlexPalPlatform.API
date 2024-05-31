package com.gymfinity.flexpal.platform.profiles.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record UrlImage(String url_image) {
    public UrlImage() {
        this(null);
    }
}
