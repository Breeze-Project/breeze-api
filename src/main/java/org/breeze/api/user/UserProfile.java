package org.breeze.api.user;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public record UserProfile(
        @NotNull UUID uniqueId,
        @NotNull String name,
        @Nullable UserSkin skin) {

    public UserProfile {
        Objects.requireNonNull(uniqueId, "uniqueId must not be null");
        Objects.requireNonNull(name, "name must not be null");
    }

    public UserProfile(final @NotNull UUID uniqueId, final @NotNull String name) {
        this(uniqueId, name, null);
    }

    public @NotNull Optional<UserSkin> getSkin() {
        return Optional.ofNullable(skin);
    }
}
