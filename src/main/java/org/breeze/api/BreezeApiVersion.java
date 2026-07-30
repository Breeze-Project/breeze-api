package org.breeze.api;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;
import java.util.logging.Logger;

public final class BreezeApiVersion {

    private static final Logger LOGGER = Logger.getLogger(BreezeApiVersion.class.getName());

    public static final @NotNull String CURRENT_STRING = loadVersion();
    public static final @NotNull ApiVersion CURRENT = ApiVersion.parse(CURRENT_STRING);

    private static @NotNull String loadVersion() {
        final var props = new Properties();
        try (final InputStream in = BreezeApiVersion.class.getClassLoader()
                .getResourceAsStream("breeze-version.properties")) {
            if (in == null) {
                LOGGER.warning("breeze-version.properties not found, falling back to 0.0.0");
                return "0.0.0";
            }
            props.load(in);
            final var v = props.getProperty("api.version");
            if (v == null || v.isBlank()) {
                LOGGER.warning("api.version not set in breeze-version.properties, falling back to 0.0.0");
                return "0.0.0";
            }
            return v.trim();
        } catch (final IOException e) {
            LOGGER.warning("Failed to load breeze-version.properties: " + e.getMessage());
            return "0.0.0";
        }
    }

    public static boolean isCompatible(final @NotNull String moduleApiVersion) {
        Objects.requireNonNull(moduleApiVersion, "moduleApiVersion must not be null");
        return CURRENT.isCompatibleWith(ApiVersion.parse(moduleApiVersion));
    }

    private BreezeApiVersion() {
    }
}
