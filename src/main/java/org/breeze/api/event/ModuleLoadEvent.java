package org.breeze.api.event;

import org.breeze.api.module.ModuleDescriptor;

import java.util.Objects;

public final class ModuleLoadEvent extends BreezeEvent {

    private final ModuleDescriptor descriptor;

    public ModuleLoadEvent(final ModuleDescriptor descriptor) {
        this.descriptor = Objects.requireNonNull(descriptor, "descriptor");
    }

    public ModuleDescriptor descriptor() {
        return descriptor;
    }
}
