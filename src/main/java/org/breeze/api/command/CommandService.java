package org.breeze.api.command;

import com.mojang.brigadier.tree.LiteralCommandNode;
import org.breeze.api.module.BreezeModule;
import org.jetbrains.annotations.NotNull;

public interface CommandService {

    void register(@NotNull BreezeModule module, @NotNull LiteralCommandNode<?> command);

    void unregisterAll(@NotNull BreezeModule module);
}
