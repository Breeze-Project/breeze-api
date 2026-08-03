package org.breeze.api.database;

import java.sql.Connection;

import org.jetbrains.annotations.NotNull;

@FunctionalInterface
public interface TransactionCallback<T> {

    T execute(@NotNull Connection connection);
}
