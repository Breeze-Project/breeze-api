package org.breeze.api.user;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public record UserSkin(
        @NotNull String value,
        @Nullable String signature) {

    public UserSkin {
        Objects.requireNonNull(value, "value must not be null");
    }

    public UserSkin(final @NotNull String value) {
        this(value, "");
    }

    public boolean hasSignature() {
        return signature != null && !signature.isBlank();
    }
}
