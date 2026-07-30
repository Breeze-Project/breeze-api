package org.breeze.api.analytics;

import org.jetbrains.annotations.NotNull;

import java.util.Map;

public interface PostHogClient {

    void capture(@NotNull String distinctId, @NotNull String event, @NotNull Map<String, Object> properties);

    void identify(@NotNull String distinctId, @NotNull Map<String, Object> traits);

    void flush();

    boolean isEnabled();

    void shutdown();
}
