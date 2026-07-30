package org.breeze.api.event;

public abstract sealed class BreezeEvent
        permits ModuleLoadEvent, ModuleEnableEvent, ModuleDisableEvent,
        AnalyticsTrackEvent, BreezeCustomEvent {

    protected BreezeEvent() {
    }
}
