package org.breeze.api.analytics;

import org.jetbrains.annotations.NotNull;

public enum AnalyticsEvents {

    PLAYER_JOIN("player_join"),
    PLAYER_QUIT("player_quit"),
    PLAYER_LOGIN("player_login"),
    PLAYER_KICK("player_kick"),
    PLAYER_DEATH("player_death"),
    PLAYER_KILL("player_kill"),
    MOB_KILL("mob_kill"),
    PLAYER_CHAT("player_chat"),
    PLAYER_COMMAND("player_command"),
    PLAYER_WORLD_CHANGE("player_world_change"),
    PLAYER_TELEPORT("player_teleport"),
    PLAYER_RESPAWN("player_respawn"),
    PLAYER_PORTAL("player_portal"),
    PLAYER_GAMEMODE_CHANGE("player_gamemode_change"),
    BLOCK_BREAK("block_break"),
    BLOCK_PLACE("block_place"),
    ITEM_DROP("item_drop"),
    ITEM_PICKUP("item_pickup"),
    ITEM_BREAK("item_break"),
    PLAYER_DAMAGE("player_damage"),
    PLAYER_ATTACK("player_attack"),
    PLAYER_TOTEM("player_totem"),
    PLAYER_INTERACT("player_interact"),
    PLAYER_INTERACT_ENTITY("player_interact_entity"),
    SIGN_EDIT("sign_edit"),
    PLAYER_TRADE("player_trade"),
    PLAYER_FISH("player_fish"),
    PLAYER_SLEEP("player_sleep"),
    PLAYER_BED_LEAVE("player_bed_leave"),
    PLAYER_CRAFT("player_craft"),
    PLAYER_SMITH("player_smith"),
    PLAYER_CONSUME("player_consume"),
    PLAYER_BUCKET_FILL("player_bucket_fill"),
    PLAYER_BUCKET_EMPTY("player_bucket_empty"),
    PLAYER_HARVEST("player_harvest"),
    PLAYER_SHEAR("player_shear"),
    ADVANCEMENT_DONE("advancement_done"),
    RECIPE_DISCOVER("recipe_discover"),
    PLAYER_LEVEL_UP("player_level_up"),
    PLAYER_MOUNT("player_mount"),
    PLAYER_DISMOUNT("player_dismount"),
    PLAYER_TAME("player_tame");

    private final AnalyticsEvent event;

    AnalyticsEvents(final @NotNull String key) {
        this.event = new AnalyticsEvent(key);
    }

    public @NotNull AnalyticsEvent event() {
        return event;
    }

    public @NotNull String key() {
        return event.key();
    }
}
