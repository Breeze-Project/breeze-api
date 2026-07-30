package org.breeze.api.scheduler;

import java.time.Duration;

public interface Scheduler {

    void run(Runnable task);

    void runLater(Runnable task, Duration delay);

    void runAtFixedRate(Runnable task, Duration delay, Duration period);

    void runAtNextTick(Runnable task);
}
