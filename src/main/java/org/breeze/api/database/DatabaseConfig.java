package org.breeze.api.database;

import java.util.Map;
import java.util.Objects;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public record DatabaseConfig(
        @NotNull String type,
        @Nullable String host,
        int port,
        @NotNull String name,
        @Nullable String user,
        @Nullable String password,
        int poolSize) {

    private static final int DEFAULT_POOL_SIZE = 10;
    private static final String DEFAULT_HOST = "localhost";

    public DatabaseConfig {
        Objects.requireNonNull(type, "type must not be null");
        Objects.requireNonNull(name, "name must not be null");
        if (poolSize < 1) {
            throw new IllegalArgumentException("poolSize must be at least 1, got " + poolSize);
        }
    }

    public static @NotNull DatabaseConfig fromMap(final @NotNull Map<String, Object> map) {
        Objects.requireNonNull(map, "map must not be null");

        final String type = getRequired(map, "type");
        final DatabaseVendor vendor = DatabaseVendor.fromConfigValue(type);

        final String name = getRequired(map, "name");
        final String host = getOptional(map, "host", DEFAULT_HOST);
        final int port = getInt(map, "port", vendor.defaultPort());
        final String user = getOptional(map, "user", null);
        final String password = getOptional(map, "password", null);
        final int poolSize = getInt(map, "pool-size",
                getInt(map, "poolSize", DEFAULT_POOL_SIZE));

        return new DatabaseConfig(
                vendor.configKey(),
                host,
                port,
                name,
                user,
                password,
                poolSize);
    }

    public @NotNull Map<String, Object> toMap() {
        final var map = java.util.LinkedHashMap.<String, Object>newLinkedHashMap(7);
        map.put("type", type);
        map.put("host", host);
        map.put("port", port);
        map.put("name", name);
        map.put("user", user);
        map.put("password", password == null ? null : "******");
        map.put("pool-size", poolSize);
        return map;
    }

    @Override
    public String toString() {
        return "DatabaseConfig["
                + "type=" + type
                + ", host=" + host
                + ", port=" + port
                + ", name=" + name
                + ", user=" + user
                + ", poolSize=" + poolSize
                + "]";
    }

    private static @NotNull String getRequired(final @NotNull Map<String, Object> map, final @NotNull String key) {
        final Object value = map.get(key);
        if (value == null || value.toString().isBlank()) {
            throw new IllegalArgumentException(
                    "Missing required configuration key '" + key + "'");
        }
        return value.toString().trim();
    }

    private static @Nullable String getOptional(final @NotNull Map<String, Object> map,
            final @NotNull String key,
            final @Nullable String fallback) {
        final Object value = map.get(key);
        if (value == null || value.toString().isBlank()) {
            return fallback;
        }
        return value.toString().trim();
    }

    private static int getInt(final @NotNull Map<String, Object> map,
            final @NotNull String key,
            final int fallback) {
        final Object value = map.get(key);
        if (value == null) {
            return fallback;
        }
        if (value instanceof final Number number) {
            return number.intValue();
        }
        try {
            return Integer.parseInt(value.toString().trim());
        } catch (final NumberFormatException e) {
            throw new IllegalArgumentException(
                    "Invalid integer value for '" + key + "': " + value, e);
        }
    }
}
