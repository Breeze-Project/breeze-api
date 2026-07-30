package org.breeze.api.analytics;

import org.jetbrains.annotations.NotNull;

public final class AnalyticsEvents {

    public static final @NotNull AnalyticsEvent PLAYER_JOIN = new AnalyticsEvent("player_join");

    public static final @NotNull AnalyticsEvent PLAYER_QUIT = new AnalyticsEvent("player_quit");

    public static final @NotNull AnalyticsEvent PLAYER_LOGIN = new AnalyticsEvent("player_login");

    public static final @NotNull AnalyticsEvent PLAYER_KICK = new AnalyticsEvent("player_kick");

    public static final @NotNull AnalyticsEvent PLAYER_DEATH = new AnalyticsEvent("player_death");

    public static final @NotNull AnalyticsEvent PLAYER_KILL = new AnalyticsEvent("player_kill");

    public static final @NotNull AnalyticsEvent MOB_KILL = new AnalyticsEvent("mob_kill");

    public static final @NotNull AnalyticsEvent PLAYER_CHAT = new AnalyticsEvent("player_chat");

    public static final @NotNull AnalyticsEvent PLAYER_COMMAND = new AnalyticsEvent("player_command");

    public static final @NotNull AnalyticsEvent PLAYER_WORLD_CHANGE = new AnalyticsEvent("player_world_change");

    public static final @NotNull AnalyticsEvent PLAYER_TELEPORT = new AnalyticsEvent("player_teleport");

    public static final @NotNull AnalyticsEvent PLAYER_RESPAWN = new AnalyticsEvent("player_respawn");

    public static final @NotNull AnalyticsEvent PLAYER_PORTAL = new AnalyticsEvent("player_portal");

    public static final @NotNull AnalyticsEvent PLAYER_GAMEMODE_CHANGE = new AnalyticsEvent("player_gamemode_change");

    public static final @NotNull AnalyticsEvent BLOCK_BREAK = new AnalyticsEvent("block_break");

    public static final @NotNull AnalyticsEvent BLOCK_PLACE = new AnalyticsEvent("block_place");

    public static final @NotNull AnalyticsEvent ITEM_DROP = new AnalyticsEvent("item_drop");

    public static final @NotNull AnalyticsEvent ITEM_PICKUP = new AnalyticsEvent("item_pickup");

    public static final @NotNull AnalyticsEvent ITEM_BREAK = new AnalyticsEvent("item_break");

    public static final @NotNull AnalyticsEvent PLAYER_DAMAGE = new AnalyticsEvent("player_damage");

    public static final @NotNull AnalyticsEvent PLAYER_ATTACK = new AnalyticsEvent("player_attack");

    public static final @NotNull AnalyticsEvent PLAYER_TOTEM = new AnalyticsEvent("player_totem");

    public static final @NotNull AnalyticsEvent PLAYER_INTERACT = new AnalyticsEvent("player_interact");

    public static final @NotNull AnalyticsEvent PLAYER_INTERACT_ENTITY = new AnalyticsEvent("player_interact_entity");

    public static final @NotNull AnalyticsEvent SIGN_EDIT = new AnalyticsEvent("sign_edit");

    public static final @NotNull AnalyticsEvent PLAYER_TRADE = new AnalyticsEvent("player_trade");

    public static final @NotNull AnalyticsEvent PLAYER_FISH = new AnalyticsEvent("player_fish");

    public static final @NotNull AnalyticsEvent PLAYER_SLEEP = new AnalyticsEvent("player_sleep");

    public static final @NotNull AnalyticsEvent PLAYER_BED_LEAVE = new AnalyticsEvent("player_bed_leave");

    public static final @NotNull AnalyticsEvent PLAYER_CRAFT = new AnalyticsEvent("player_craft");

    public static final @NotNull AnalyticsEvent PLAYER_SMITH = new AnalyticsEvent("player_smith");

    public static final @NotNull AnalyticsEvent PLAYER_CONSUME = new AnalyticsEvent("player_consume");

    public static final @NotNull AnalyticsEvent PLAYER_BUCKET_FILL = new AnalyticsEvent("player_bucket_fill");

    public static final @NotNull AnalyticsEvent PLAYER_BUCKET_EMPTY = new AnalyticsEvent("player_bucket_empty");

    public static final @NotNull AnalyticsEvent PLAYER_HARVEST = new AnalyticsEvent("player_harvest");

    public static final @NotNull AnalyticsEvent PLAYER_SHEAR = new AnalyticsEvent("player_shear");

    public static final @NotNull AnalyticsEvent ADVANCEMENT_DONE = new AnalyticsEvent("advancement_done");

    public static final @NotNull AnalyticsEvent RECIPE_DISCOVER = new AnalyticsEvent("recipe_discover");

    public static final @NotNull AnalyticsEvent PLAYER_LEVEL_UP = new AnalyticsEvent("player_level_up");

    public static final @NotNull AnalyticsEvent PLAYER_MOUNT = new AnalyticsEvent("player_mount");

    public static final @NotNull AnalyticsEvent PLAYER_DISMOUNT = new AnalyticsEvent("player_dismount");

    public static final @NotNull AnalyticsEvent PLAYER_TAME = new AnalyticsEvent("player_tame");

    private AnalyticsEvents() {
    }
}
