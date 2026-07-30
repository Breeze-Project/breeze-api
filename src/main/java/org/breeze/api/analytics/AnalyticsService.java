package org.breeze.api.analytics;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.UUID;

public interface AnalyticsService {

    void track(@Nullable UUID playerId, @NotNull AnalyticsEvent event, @NotNull Map<String, Object> properties);

    void identify(@NotNull UUID playerId, @NotNull Map<String, Object> traits);

    boolean isEnabled();
}
