package org.breeze.api.module;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.breeze.api.event.EventBus;
import org.breeze.api.scheduler.Scheduler;
import org.breeze.api.service.ServiceRegistry;
import org.jetbrains.annotations.NotNull;

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

    default void saveDefaultConfig(@NotNull final Path relativePath, @NotNull final Class<?> moduleClass) {
        final var logger = logger();
        final var dataFolder = dataFolder();
        final var configFile = dataFolder().resolve(relativePath);

        if (Files.exists(configFile)) {
            return;
        }

        try {
            if (configFile.getParent() != null) {
                Files.createDirectories(configFile.getParent());
            } else {
                Files.createDirectories(dataFolder);
            }
        } catch (final IOException error) {
            logger.log(Level.WARNING, "Failed to create module data directory", error);
            return;
        }

        final String resourcePath = relativePath.toString().replace("\\", "/");

        try (InputStream in = moduleClass.getClassLoader().getResourceAsStream(resourcePath)) {
            if (in == null) {
                logger.warning("Default resource '" + resourcePath + "' not found in module jar");
                return;
            }
            Files.copy(in, configFile, StandardCopyOption.REPLACE_EXISTING);
            logger.info("Create default config at " + configFile);
        } catch (final IOException error) {
            logger.log(Level.WARNING, "Failed to save default config " + resourcePath, error);
        }
    }
}
