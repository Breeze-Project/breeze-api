package org.breeze.api.command;

import org.breeze.api.module.BreezeModule;
import org.jetbrains.annotations.NotNull;

import com.mojang.brigadier.tree.LiteralCommandNode;

import io.papermc.paper.command.brigadier.CommandSourceStack;

public interface CommandService {

    void register(@NotNull BreezeModule module, @NotNull LiteralCommandNode<CommandSourceStack> command);

    void unregisterAll(@NotNull BreezeModule module);
}
