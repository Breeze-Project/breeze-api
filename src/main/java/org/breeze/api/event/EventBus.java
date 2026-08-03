package org.breeze.api.event;

import org.breeze.api.module.BreezeModule;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public interface EventBus {

    @NotNull
    <T extends BreezeEvent> Subscription subscribe(
            @NotNull Class<T> eventType,
            @NotNull Consumer<T> handler);

    @NotNull
    <T extends BreezeEvent> Subscription subscribe(
            @NotNull Class<T> eventType,
            @NotNull EventPriority priority,
            @NotNull Consumer<T> handler);

    @NotNull
    <T extends BreezeEvent> Subscription subscribe(
            @NotNull BreezeModule module,
            @NotNull Class<T> eventType,
            @NotNull Consumer<T> handler);

    @NotNull
    <T extends BreezeEvent> Subscription subscribe(
            @NotNull BreezeModule module,
            @NotNull Class<T> eventType,
            @NotNull EventPriority priority,
            @NotNull Consumer<T> handler);

    void unsubscribeAll(@NotNull BreezeModule module);

    <T extends BreezeEvent> void publish(@NotNull T event);
}
