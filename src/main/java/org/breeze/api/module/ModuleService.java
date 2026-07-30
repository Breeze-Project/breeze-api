package org.breeze.api.module;

import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.SequencedCollection;
import java.util.concurrent.CompletableFuture;

public interface ModuleService {

    void registerModule(@NotNull BreezeModule module);

    @NotNull
    Optional<BreezeModule> getModule(@NotNull String id);

    @NotNull
    SequencedCollection<BreezeModule> getModules();

    @NotNull
    ModuleState getState(@NotNull String id);

    @NotNull
    CompletableFuture<Void> loadModule(@NotNull String id);

    @NotNull
    CompletableFuture<Void> unloadModule(@NotNull String id);

    @NotNull
    CompletableFuture<Void> reloadModule(@NotNull String id);
}
