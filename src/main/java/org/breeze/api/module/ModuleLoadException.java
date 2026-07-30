package org.breeze.api.module;

import java.util.Objects;

public class ModuleLoadException extends RuntimeException {

    private final String moduleId;

    public ModuleLoadException(final String moduleId, final String message) {
        super(message);
        this.moduleId = Objects.requireNonNull(moduleId, "moduleId");
    }

    public ModuleLoadException(final String moduleId, final String message, final Throwable cause) {
        super(message, cause);
        this.moduleId = Objects.requireNonNull(moduleId, "moduleId");
    }

    public String moduleId() {
        return moduleId;
    }
}
