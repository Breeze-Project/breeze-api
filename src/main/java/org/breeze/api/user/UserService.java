package org.breeze.api.user;

import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface UserService {

    @NotNull
    CompletableFuture<Optional<UserProfile>> getProfile(@NotNull UUID uniqueId);

    @NotNull
    CompletableFuture<Optional<UserProfile>> getProfile(@NotNull String name);

    @NotNull
    CompletableFuture<Optional<String>> getName(@NotNull UUID uniqueId);

    @NotNull
    CompletableFuture<Optional<UserSkin>> getSkin(@NotNull UUID uniqueId);
}
