package org.breeze.api.event;

import org.breeze.api.analytics.AnalyticsEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public final class AnalyticsTrackEvent extends BreezeEvent {

    private final @Nullable UUID playerId;
    private final @NotNull AnalyticsEvent event;
    private final @NotNull Map<String, Object> properties;

    public AnalyticsTrackEvent(
            final @Nullable UUID playerId,
            final @NotNull AnalyticsEvent event,
            final @NotNull Map<String, Object> properties) {
        this.playerId = playerId;
        this.event = Objects.requireNonNull(event, "event");
        this.properties = properties != null
                ? Collections.unmodifiableMap(Map.copyOf(properties))
                : Collections.emptyMap();
    }

    public @Nullable UUID getPlayerId() {
        return playerId;
    }

    public @NotNull AnalyticsEvent getEvent() {
        return event;
    }

    public @NotNull Map<String, Object> getProperties() {
        return properties;
    }
}
