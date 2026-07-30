package org.breeze.api;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public final class BreezeApiVersion {

    public static final String CURRENT_STRING = "1.7.0";
    public static final @NotNull ApiVersion CURRENT = ApiVersion.parse(CURRENT_STRING);

    public static boolean isCompatible(final @NotNull String moduleApiVersion) {
        Objects.requireNonNull(moduleApiVersion, "moduleApiVersion must not be null");
        return CURRENT.isCompatibleWith(ApiVersion.parse(moduleApiVersion));
    }

    private BreezeApiVersion() {
    }
}
