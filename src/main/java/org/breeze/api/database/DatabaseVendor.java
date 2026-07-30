package org.breeze.api.database;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public enum DatabaseVendor {

    MYSQL("mysql", 3306, true),
    POSTGRESQL("postgresql", 5432, true),
    SQLITE("sqlite", -1, false);

    private final String configKey;
    private final int defaultPort;
    private final boolean remote;

    DatabaseVendor(final String configKey, final int defaultPort, final boolean remote) {
        this.configKey = configKey;
        this.defaultPort = defaultPort;
        this.remote = remote;
    }

    public @NotNull String configKey() {
        return configKey;
    }

    public int defaultPort() {
        return defaultPort;
    }

    public boolean isRemote() {
        return remote;
    }

    public static @NotNull DatabaseVendor fromConfigValue(final @Nullable String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(
                    "Database vendor must not be null or blank. Supported values: mysql, postgresql, sqlite");
        }
        return switch (value.trim().toLowerCase()) {
            case "mysql" -> MYSQL;
            case "postgresql" -> POSTGRESQL;
            case "sqlite" -> SQLITE;
            default -> throw new IllegalArgumentException(
                    "Unknown database vendor '" + value + "'. Supported values: mysql, postgresql, sqlite");
        };
    }
}
