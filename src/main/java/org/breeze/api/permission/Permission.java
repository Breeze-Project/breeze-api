package org.breeze.api.permission;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public record Permission(@NotNull String name) {

    public Permission {
        Objects.requireNonNull(name, "permission name must not be null");
    }
}
