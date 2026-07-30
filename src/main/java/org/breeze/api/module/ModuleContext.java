package org.breeze.api.module;

import org.breeze.api.event.EventBus;
import org.breeze.api.scheduler.Scheduler;
import org.breeze.api.service.ServiceRegistry;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;
import java.util.logging.Logger;

public interface ModuleContext {

    @NotNull
    Logger logger();

    @NotNull
    Path dataFolder();

    @NotNull
    EventBus eventBus();

    @NotNull
    Scheduler scheduler();

    @NotNull
    ServiceRegistry services();

    @NotNull
    ModuleDescriptor descriptor();
}
