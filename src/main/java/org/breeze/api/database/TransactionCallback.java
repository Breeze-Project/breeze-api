package org.breeze.api.database;

@FunctionalInterface
public interface TransactionCallback<T> {

    T execute();
}
