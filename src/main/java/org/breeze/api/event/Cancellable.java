package org.breeze.api.event;

public interface Cancellable {

    boolean cancelled();

    void setCancelled(boolean cancelled);
}
