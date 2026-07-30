package org.breeze.api.module;

import org.breeze.api.ApiVersion;
import org.breeze.api.BreezeApiVersion;

import java.util.List;
import java.util.Objects;

public record ModuleDescriptor(
        String id,
        String name,
        ApiVersion version,
        String description,
        List<String> authors,
        List<String> dependencies,
        ApiVersion requiredApiVersion) {

    public ModuleDescriptor {
        Objects.requireNonNull(id, "id");
        Objects.requireNonNull(name, "name");
        Objects.requireNonNull(version, "version");
        Objects.requireNonNull(requiredApiVersion, "requiredApiVersion");
        if (!BreezeApiVersion.CURRENT.isCompatibleWith(requiredApiVersion)) {
            throw new IllegalArgumentException(
                    "Module requires API " + requiredApiVersion
                            + " but current API version is " + BreezeApiVersion.CURRENT);
        }
        authors = List.copyOf(authors);
        dependencies = List.copyOf(dependencies);
    }

    public ModuleDescriptor(final String id, final String name, final ApiVersion version) {
        this(id, name, version, "", List.of(), List.of(), BreezeApiVersion.CURRENT);
    }
}
