package org.breeze.api.analytics;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public record AnalyticsEvent(@NotNull String key) {

    public AnalyticsEvent {
        Objects.requireNonNull(key, "event key must not be null");
        if (key.isBlank()) {
            throw new IllegalArgumentException("event key must not be blank");
        }
    }

    @Override
    public @NotNull String toString() {
        return key;
    }
}
