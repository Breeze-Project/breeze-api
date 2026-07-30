package org.breeze.api.module;

import org.jetbrains.annotations.NotNull;

public interface BreezeModule {

    @NotNull
    ModuleDescriptor descriptor();

    default void onLoad(final @NotNull ModuleContext context) {
    }

    default void onEnable() {
    }

    default void onDisable() {
    }
}
