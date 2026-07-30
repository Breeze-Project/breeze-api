package org.breeze.api.event;

import org.jetbrains.annotations.NotNull;

public interface Subscription {

    @NotNull
    Class<? extends BreezeEvent> eventType();

    void unsubscribe();

    boolean isSubscribed();
}
