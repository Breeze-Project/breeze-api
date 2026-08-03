package org.breeze.api.service;

import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public interface ServiceRegistry extends AutoCloseable {

    <T> void register(@NotNull Class<T> serviceType, @NotNull T implementation);

    @NotNull
    <T> Optional<T> get(@NotNull Class<T> serviceType);

    @NotNull
    default <T> T getOrThrow(final @NotNull Class<T> serviceType) {
        return get(serviceType)
                .orElseThrow(() -> new IllegalStateException(
                        "No service registered for " + serviceType.getName()));
    }

    void unregister(@NotNull Class<?> serviceType);

    @Override
    void close();
}
