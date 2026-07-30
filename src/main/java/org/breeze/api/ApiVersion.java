package org.breeze.api;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.regex.Pattern;

public record ApiVersion(int major, int minor, int patch) implements Comparable<ApiVersion> {

    private static final Pattern VERSION_PATTERN = Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)$");

    public static @NotNull ApiVersion parse(final @NotNull String version) {
        Objects.requireNonNull(version, "version must not be null");
        final var matcher = VERSION_PATTERN.matcher(version.trim());
        if (!matcher.matches()) {
            throw new IllegalArgumentException(
                    "Invalid version format: '" + version + "'. Expected major.minor.patch (e.g. 1.7.0)");
        }
        try {
            return new ApiVersion(
                    Integer.parseInt(matcher.group(1)),
                    Integer.parseInt(matcher.group(2)),
                    Integer.parseInt(matcher.group(3)));
        } catch (final NumberFormatException e) {
            throw new IllegalArgumentException("Invalid version format: '" + version + "'", e);
        }
    }

    public boolean isCompatibleWith(final @NotNull ApiVersion required) {
        Objects.requireNonNull(required, "required version must not be null");
        return major == required.major && this.compareTo(required) >= 0;
    }

    @Override
    public @NotNull String toString() {
        return major + "." + minor + "." + patch;
    }

    @Override
    public int compareTo(final @NotNull ApiVersion o) {
        int cmp = Integer.compare(major, o.major);
        if (cmp != 0)
            return cmp;
        cmp = Integer.compare(minor, o.minor);
        if (cmp != 0)
            return cmp;
        return Integer.compare(patch, o.patch);
    }
}
